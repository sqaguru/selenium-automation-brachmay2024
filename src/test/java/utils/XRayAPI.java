package utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import java.util.Base64;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class XRayAPI {

    public static String getXrayApiToken(String clientId, String clientSecret) throws Exception {
        // Create the HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Define the API endpoint and request body
        String apiUrl = "https://xray.cloud.getxray.app/api/v2/authenticate";
        String jsonBody = String.format("""
                {
                    "client_id": "%s",
                    "client_secret": "%s"
                }
                """, clientId, clientSecret);

        // Build the POST request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Check for successful response (HTTP status 200)
        if (response.statusCode() == 200) {
            String token = response.body();
            // Remove starting and ending quotes if present
            if (token.startsWith("\"") && token.endsWith("\"")) {
                token = token.substring(1, token.length() - 1);
            }
            return token;
        } else {
            // Handle error response
            throw new RuntimeException("Failed to authenticate xray: " + response.statusCode());
        }
    }

    public static String createTestExecution(String username, String password, String projectKey, String summary,
            String description) throws Exception {
        // Create the HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Encode username and password in Base64 for Basic Authentication
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        // Define the API endpoint
        String apiUrl = "https://" + System.getenv("JIRA_BASE_URL") + "/rest/api/2/issue";

        // Construct the request body dynamically based on parameters
        String jsonBody = String.format("""
                {
                    "fields": {
                        "project": {
                            "key": "%s"
                        },
                        "summary": "%s",
                        "description": "%s",
                        "issuetype": {
                            "name": "Test Execution"
                        }
                    }
                }
                """, projectKey, summary, description);

        // Build the POST request with Basic Auth in the Authorization header
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + encodedAuth)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Check for successful response (HTTP status 201 indicates issue created
        // successfully)
        if (response.statusCode() == 201) {
            // Parse the response body to get the 'key'
            JSONObject jsonResponse = new JSONObject(response.body());

            // Return the issue key
            return jsonResponse.getString("key");
        } else {
            // Handle error response
            throw new RuntimeException(
                    "Failed to create test execution: " + response.statusCode() + " " + response.body());
        }
    }

    public static String updateTestResult(String token, String testExecutionKey, String testKey, String status)
            throws Exception {
        // Create the HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Define the API endpoint
        String apiUrl = "https://" + System.getenv("JIRA_XRAY_BASE_URL") + "/api/v2/import/execution";

        // Construct the request body dynamically based on parameters
        String jsonBody = String.format("""
                {
                    "testExecutionKey": "%s",
                    "tests": [
                        {
                            "testKey": "%s",
                            "status": "%s",
                            "testInfo": {
                                "type": "Automated"
                            }
                        }
                    ]
                }
                """, testExecutionKey, testKey, status);

        // Build the POST request with the Bearer token in the Authorization header
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Check for successful response (HTTP status 200 or 201)
        if (response.statusCode() == 200 || response.statusCode() == 201) {
            System.out.println(response.body());
            return "Test result updated successfully!";
        } else {
            // Handle error response
            throw new RuntimeException(
                    "Failed to update test result: " + response.statusCode() + " " + response.body());
        }
    }

    // Function to generate a dynamic date-time string in ddMMyyyyHHmmss format
    public static String getCurrentDateTimeString() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define the date-time format: ddMMyyyyHHmmss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

        // Format the current date and time
        String formattedDateTime = now.format(formatter);

        return formattedDateTime;
    }

    public final String  str1 = "";
 

    public static void main(String[] args) {
        // str1 = "4";
    }

}