package testcases;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listener implements WebDriverListener {

	@Override
	public void afterActiveElement(TargetLocator targetLocator, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterActiveElement(targetLocator, driver);
	}

	@Override
	public void afterAccept(Alert alert) {
		System.out.println("Passed: An alert has accepted");
	}

	@Override
	public void afterAddCookie(Options options, Cookie cookie) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAddCookie(options, cookie);
	}

	@Override
	public void afterAlert(TargetLocator targetLocator, Alert alert) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAlert(targetLocator, alert);
	}

	@Override
	public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyAlertCall(alert, method, args, result);
	}

	@Override
	public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyCall(target, method, args, result);
	}

	@Override
	public void afterAnyNavigationCall(Navigation navigation, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyNavigationCall(navigation, method, args, result);
	}

	@Override
	public void afterAnyOptionsCall(Options options, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyOptionsCall(options, method, args, result);
	}

	@Override
	public void afterAnyTargetLocatorCall(TargetLocator targetLocator, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyTargetLocatorCall(targetLocator, method, args, result);
	}

	@Override
	public void afterAnyTimeoutsCall(Timeouts timeouts, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyTimeoutsCall(timeouts, method, args, result);
	}

	@Override
	public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyWebDriverCall(driver, method, args, result);
	}

	@Override
	public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyWebElementCall(element, method, args, result);
	}

	@Override
	public void afterAnyWindowCall(Window window, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterAnyWindowCall(window, method, args, result);
	}

	@Override
	public void afterBack(Navigation navigation) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterBack(navigation);
	}

	@Override
	public void afterClear(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterClear(element);
	}

	@Override
	public void afterClick(WebElement element) {
		System.out.println("Passed: clicked on element ");
	}

	@Override
	public void afterClose(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterClose(driver);
	}

	@Override
	public void afterDefaultContent(TargetLocator targetLocator, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterDefaultContent(targetLocator, driver);
	}

	@Override
	public void afterDeleteAllCookies(Options options) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterDeleteAllCookies(options);
	}

	@Override
	public void afterDeleteCookie(Options options, Cookie cookie) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterDeleteCookie(options, cookie);
	}

	@Override
	public void afterDeleteCookieNamed(Options options, String name) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterDeleteCookieNamed(options, name);
	}

	@Override
	public void afterDismiss(Alert alert) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterDismiss(alert);
	}

	@Override
	public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterExecuteAsyncScript(driver, script, args, result);
	}

	@Override
	public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterExecuteScript(driver, script, args, result);
	}

	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Passed: Element found for locator " + locator.toString());
	}

	@Override
	public void afterFindElement(WebElement element, By locator, WebElement result) {
		System.out.println("Passed: Element found for locator " + locator.toString());
	}

	@Override
	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterFindElements(driver, locator, result);
	}

	@Override
	public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterFindElements(element, locator, result);
	}

	@Override
	public void afterForward(Navigation navigation) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterForward(navigation);
	}

	@Override
	public void afterFrame(TargetLocator targetLocator, int index, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterFrame(targetLocator, index, driver);
	}

	@Override
	public void afterFrame(TargetLocator targetLocator, String nameOrId, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterFrame(targetLocator, nameOrId, driver);
	}

	@Override
	public void afterFrame(TargetLocator targetLocator, WebElement frameElement, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterFrame(targetLocator, frameElement, driver);
	}

	@Override
	public void afterFullscreen(Window window) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterFullscreen(window);
	}

	@Override
	public void afterGet(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGet(driver, url);
	}

	@Override
	public void afterGetAttribute(WebElement element, String name, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetAttribute(element, name, result);
	}

	@Override
	public void afterGetCookieNamed(Options options, String name, Cookie result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetCookieNamed(options, name, result);
	}

	@Override
	public void afterGetCookies(Options options, Set<Cookie> result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetCookies(options, result);
	}

	@Override
	public void afterGetCssValue(WebElement element, String propertyName, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetCssValue(element, propertyName, result);
	}

	@Override
	public void afterGetCurrentUrl(WebDriver driver, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetCurrentUrl(driver, result);
	}

	@Override
	public void afterGetLocation(WebElement element, Point result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetLocation(element, result);
	}

	@Override
	public void afterGetPageSource(WebDriver driver, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetPageSource(driver, result);
	}

	@Override
	public void afterGetPosition(Window window, Point result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetPosition(window, result);
	}

	@Override
	public void afterGetSize(WebElement element, Dimension result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetSize(element, result);
	}

	@Override
	public void afterGetSize(Window window, Dimension result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetSize(window, result);
	}

	@Override
	public void afterGetTagName(WebElement element, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetTagName(element, result);
	}

	@Override
	public void afterGetText(Alert alert, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetText(alert, result);
	}

	@Override
	public void afterGetText(WebElement element, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetText(element, result);
	}

	@Override
	public void afterGetTitle(WebDriver driver, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetTitle(driver, result);
	}

	@Override
	public void afterGetWindowHandle(WebDriver driver, String result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetWindowHandle(driver, result);
	}

	@Override
	public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterGetWindowHandles(driver, result);
	}

	@Override
	public void afterImplicitlyWait(Timeouts timeouts, Duration duration) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterImplicitlyWait(timeouts, duration);
	}

	@Override
	public void afterIsDisplayed(WebElement element, boolean result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterIsDisplayed(element, result);
	}

	@Override
	public void afterIsEnabled(WebElement element, boolean result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterIsEnabled(element, result);
	}

	@Override
	public void afterIsSelected(WebElement element, boolean result) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterIsSelected(element, result);
	}

	@Override
	public void afterMaximize(Window window) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterMaximize(window);
	}

	@Override
	public void afterNewWindow(TargetLocator targetLocator, WindowType typeHint, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterNewWindow(targetLocator, typeHint, driver);
	}

	@Override
	public void afterPageLoadTimeout(Timeouts timeouts, Duration duration) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterPageLoadTimeout(timeouts, duration);
	}

	@Override
	public void afterParentFrame(TargetLocator targetLocator, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterParentFrame(targetLocator, driver);
	}

	@Override
	public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterPerform(driver, actions);
	}

	@Override
	public void afterQuit(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterQuit(driver);
	}

	@Override
	public void afterRefresh(Navigation navigation) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterRefresh(navigation);
	}

	@Override
	public void afterResetInputState(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterResetInputState(driver);
	}

	@Override
	public void afterSendKeys(Alert alert, String text) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterSendKeys(alert, text);
	}

	@Override
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Passed: Enter text on element");
	}

	@Override
	public void afterSetPosition(Window window, Point position) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterSetPosition(window, position);
	}

	@Override
	public void afterSetScriptTimeout(Timeouts timeouts, Duration duration) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterSetScriptTimeout(timeouts, duration);
	}

	@Override
	public void afterSetSize(Window window, Dimension size) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterSetSize(window, size);
	}

	@Override
	public void afterSubmit(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterSubmit(element);
	}

	@Override
	public void afterTo(Navigation navigation, String url) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterTo(navigation, url);
	}

	@Override
	public void afterTo(Navigation navigation, URL url) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterTo(navigation, url);
	}

	@Override
	public void afterWindow(TargetLocator targetLocator, String nameOrHandle, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterWindow(targetLocator, nameOrHandle, driver);
	}

	@Override
	public void beforeAccept(Alert alert) {
		System.out.println("In-Progress: About to accept an alert..");
	}

	@Override
	public void beforeActiveElement(TargetLocator targetLocator) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeActiveElement(targetLocator);
	}

	@Override
	public void beforeAddCookie(Options options, Cookie cookie) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAddCookie(options, cookie);
	}

	@Override
	public void beforeAlert(TargetLocator targetLocator) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAlert(targetLocator);
	}

	@Override
	public void beforeAnyAlertCall(Alert alert, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyAlertCall(alert, method, args);
	}

	@Override
	public void beforeAnyCall(Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyCall(target, method, args);
	}

	@Override
	public void beforeAnyNavigationCall(Navigation navigation, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyNavigationCall(navigation, method, args);
	}

	@Override
	public void beforeAnyOptionsCall(Options options, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyOptionsCall(options, method, args);
	}

	@Override
	public void beforeAnyTargetLocatorCall(TargetLocator targetLocator, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyTargetLocatorCall(targetLocator, method, args);
	}

	@Override
	public void beforeAnyTimeoutsCall(Timeouts timeouts, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyTimeoutsCall(timeouts, method, args);
	}

	@Override
	public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyWebDriverCall(driver, method, args);
	}

	@Override
	public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyWebElementCall(element, method, args);
	}

	@Override
	public void beforeAnyWindowCall(Window window, Method method, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeAnyWindowCall(window, method, args);
	}

	@Override
	public void beforeBack(Navigation navigation) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeBack(navigation);
	}

	@Override
	public void beforeClear(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeClear(element);
	}

	@Override
	public void beforeClick(WebElement element) {
		System.out.println("In-Progress: Clicking on element " + element.getText());
	}

	@Override
	public void beforeClose(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeClose(driver);
	}

	@Override
	public void beforeDefaultContent(TargetLocator targetLocator) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeDefaultContent(targetLocator);
	}

	@Override
	public void beforeDeleteAllCookies(Options options) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeDeleteAllCookies(options);
	}

	@Override
	public void beforeDeleteCookie(Options options, Cookie cookie) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeDeleteCookie(options, cookie);
	}

	@Override
	public void beforeDeleteCookieNamed(Options options, String name) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeDeleteCookieNamed(options, name);
	}

	@Override
	public void beforeDismiss(Alert alert) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeDismiss(alert);
	}

	@Override
	public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeExecuteAsyncScript(driver, script, args);
	}

	@Override
	public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeExecuteScript(driver, script, args);
	}

	@Override
	public void beforeFindElement(WebDriver driver, By locator) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeFindElement(driver, locator);
	}

	@Override
	public void beforeFindElement(WebElement element, By locator) {
		System.out.println("In-Progress: Findin element by locator " + locator.toString());
	}

	@Override
	public void beforeFindElements(WebDriver driver, By locator) {
		System.out.println("In-Progress: Findin element by locator " + locator.toString());
	}

	@Override
	public void beforeFindElements(WebElement element, By locator) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeFindElements(element, locator);
	}

	@Override
	public void beforeForward(Navigation navigation) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeForward(navigation);
	}

	@Override
	public void beforeFrame(TargetLocator targetLocator, int index) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeFrame(targetLocator, index);
	}

	@Override
	public void beforeFrame(TargetLocator targetLocator, String nameOrId) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeFrame(targetLocator, nameOrId);
	}

	@Override
	public void beforeFrame(TargetLocator targetLocator, WebElement frameElement) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeFrame(targetLocator, frameElement);
	}

	@Override
	public void beforeFullscreen(Window window) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeFullscreen(window);
	}

	@Override
	public void beforeGet(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGet(driver, url);
	}

	@Override
	public void beforeGetAttribute(WebElement element, String name) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetAttribute(element, name);
	}

	@Override
	public void beforeGetCookieNamed(Options options, String name) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetCookieNamed(options, name);
	}

	@Override
	public void beforeGetCookies(Options options) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetCookies(options);
	}

	@Override
	public void beforeGetCssValue(WebElement element, String propertyName) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetCssValue(element, propertyName);
	}

	@Override
	public void beforeGetCurrentUrl(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetCurrentUrl(driver);
	}

	@Override
	public void beforeGetLocation(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetLocation(element);
	}

	@Override
	public void beforeGetPageSource(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetPageSource(driver);
	}

	@Override
	public void beforeGetPosition(Window window) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetPosition(window);
	}

	@Override
	public void beforeGetSize(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetSize(element);
	}

	@Override
	public void beforeGetSize(Window window) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetSize(window);
	}

	@Override
	public void beforeGetTagName(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetTagName(element);
	}

	@Override
	public void beforeGetText(Alert alert) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetText(alert);
	}

	@Override
	public void beforeGetText(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetText(element);
	}

	@Override
	public void beforeGetTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetTitle(driver);
	}

	@Override
	public void beforeGetWindowHandle(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetWindowHandle(driver);
	}

	@Override
	public void beforeGetWindowHandles(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeGetWindowHandles(driver);
	}

	@Override
	public void beforeImplicitlyWait(Timeouts timeouts, Duration duration) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeImplicitlyWait(timeouts, duration);
	}

	@Override
	public void beforeIsDisplayed(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeIsDisplayed(element);
	}

	@Override
	public void beforeIsEnabled(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeIsEnabled(element);
	}

	@Override
	public void beforeIsSelected(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeIsSelected(element);
	}

	@Override
	public void beforeMaximize(Window window) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeMaximize(window);
	}

	@Override
	public void beforeNewWindow(TargetLocator targetLocator, WindowType typeHint) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeNewWindow(targetLocator, typeHint);
	}

	@Override
	public void beforePageLoadTimeout(Timeouts timeouts, Duration duration) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforePageLoadTimeout(timeouts, duration);
	}

	@Override
	public void beforeParentFrame(TargetLocator targetLocator) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeParentFrame(targetLocator);
	}

	@Override
	public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforePerform(driver, actions);
	}

	@Override
	public void beforeQuit(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeQuit(driver);
	}

	@Override
	public void beforeRefresh(Navigation navigation) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeRefresh(navigation);
	}

	@Override
	public void beforeResetInputState(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeResetInputState(driver);
	}

	@Override
	public void beforeSendKeys(Alert alert, String text) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeSendKeys(alert, text);
	}

	@Override
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("In-Progress: Entering text on element..");
	}

	@Override
	public void beforeSetPosition(Window window, Point position) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeSetPosition(window, position);
	}

	@Override
	public void beforeSetScriptTimeout(Timeouts timeouts, Duration duration) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeSetScriptTimeout(timeouts, duration);
	}

	@Override
	public void beforeSetSize(Window window, Dimension size) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeSetSize(window, size);
	}

	@Override
	public void beforeSubmit(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeSubmit(element);
	}

	@Override
	public void beforeTo(Navigation navigation, String url) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeTo(navigation, url);
	}

	@Override
	public void beforeTo(Navigation navigation, URL url) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeTo(navigation, url);
	}

	@Override
	public void beforeWindow(TargetLocator targetLocator, String nameOrHandle) {
		// TODO Auto-generated method stub
		WebDriverListener.super.beforeWindow(targetLocator, nameOrHandle);
	}

	@Override
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		// TODO Auto-generated method stub
		WebDriverListener.super.onError(target, method, args, e);
	}

}
