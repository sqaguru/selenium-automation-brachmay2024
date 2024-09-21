package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDropTest extends BasePage {

	public void actionsDragAndDropTest() throws InterruptedException, IOException {

		driver.get("https://demoqa.com/droppable");// navigate url

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions action = new Actions(driver);

		WebElement draggable = driver.findElement(By.id("draggable"));

		WebElement droppable = driver.findElement(By.id("droppable"));

		action.dragAndDrop(draggable, droppable).build().perform();// drag & drop method

		driver.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed();

	}
}
