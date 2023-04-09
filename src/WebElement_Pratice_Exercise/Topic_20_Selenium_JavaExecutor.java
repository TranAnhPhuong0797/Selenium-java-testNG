package WebElement_Pratice_Exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Selenium_JavaExecutor {
	WebDriver driver;
	WebDriverWait explicitwait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		explicitwait = new WebDriverWait(driver, 30);
	}
	
	public void sleepfunction(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond, 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TC_01_JE() {
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepfunction(4);
		
		Assert.assertEquals(executeForBrowser("return document.domain;"), "live.techpanda.org");
		Assert.assertEquals(executeForBrowser("return document.URL;"), "http://live.techpanda.org/");
		
		hightlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");
		sleepfunction(2);
		
		hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		sleepfunction(2);
		
		Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart"));
		
		hightlightElement("//input[@id='newsletter']");
		scrollToElementOnDown("//input[@id='newsletter']");
		sleepfunction(2);
		
		sendkeyToElementByJS("//input[@id='newsletter']", "Auto" + randomNum() + "@gmail.com");
		hightlightElement("//button[@title='Subscribe']");
		clickToElementByJS("//button[@title='Subscribe']");
		sleepfunction(2);
		
		Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
		
		navigateToUrlByJS("http://demo.guru99.com/v4/");
		sleepfunction(4);
		
		Assert.assertEquals(executeForBrowser("return document.domain;"), "demo.guru99.com");
	}
	
	@Test
	public void TC_02_ValidationHTML5() {
		navigateToUrlByJS("https://automationfc.github.io/html5/index.html");
		sleepfunction(2);
		
		hightlightElement("//input[@type='submit']");
		clickToElementByJS("//input[@type='submit']");
		sleepfunction(2);
		//Error mess field Name
		Assert.assertEquals(getElementValidationMessage("//input[@name='fname']"), "Please fill out this field.");
		
		sendkeyToElementByJS("//input[@name='fname']", "Phuong");
		hightlightElement("//input[@type='submit']");
		clickToElementByJS("//input[@type='submit']");
		sleepfunction(2);
		
		//Error mess field Name
		Assert.assertEquals(getElementValidationMessage("//input[@name='pass']"), "Please fill out this field.");
		
		sendkeyToElementByJS("//input[@name='pass']", "Pass123456@");
		hightlightElement("//input[@type='submit']");
		clickToElementByJS("//input[@type='submit']");
		sleepfunction(2);
		
		//Error mess field Email
		Assert.assertEquals(getElementValidationMessage("//input[@name='em']"), "Please fill out this field.");
		
		sendkeyToElementByJS("//input[@name='em']", "Pass123456@");
		hightlightElement("//input[@type='submit']");
		clickToElementByJS("//input[@type='submit']");
		sleepfunction(2);
		//Error mess Invalid Email
		Assert.assertEquals(getElementValidationMessage("//input[@name='em']"), "Please enter a part following '@'. 'Pass123456@' is incomplete.");
		
		sendkeyToElementByJS("//input[@name='em']", "auto" + randomNum() + "@gmail.com");
		hightlightElement("//input[@type='submit']");
		clickToElementByJS("//input[@type='submit']");
		sleepfunction(2);
		
		//Error mess field Address
		Assert.assertEquals(getElementValidationMessage("//select"), "Please select an item in the list.");
	}
	
	@Test
	public void TC_03_ValidationHTML5() {
		navigateToUrlByJS("https://warranty.rode.com/");
		sleepfunction(3);
		
		String registorButton = "//button[contains(text(),'Register')]";
		String firstName = "//input[@id='firstname']";
		String sureName = "//input[@id='surname']";
		String email = "//input[@id='email']";		
		String pass = "//input[@id='password']";
		String cpass = "//input[@id='password-confirm']";
		
		clickToElementByJS(registorButton);
		sleepfunction(2);
		
		Assert.assertEquals(getElementValidationMessage(firstName), "Please fill out this field.");
		
		sendkeyToElementByJS(firstName, "ABC");
		clickToElementByJS(registorButton);
		sleepfunction(2);
		
		Assert.assertEquals(getElementValidationMessage(sureName), "Please fill out this field.");
		
		sendkeyToElementByJS(sureName, "Test");
		clickToElementByJS(registorButton);
		sleepfunction(2);
		
		Assert.assertEquals(getElementValidationMessage(email), "Please fill out this field.");
		
		sendkeyToElementByJS(email, "Test@email@");
		clickToElementByJS(registorButton);
		sleepfunction(2);
		
		Assert.assertEquals(getElementValidationMessage(email), "A part following '@' should not contain the symbol '@'.");
		
		sendkeyToElementByJS(email, "testAuto@gmail.com");
		clickToElementByJS(registorButton);
		sleepfunction(2);
		
		Assert.assertEquals(getElementValidationMessage(pass), "Please fill out this field.");
		
		sendkeyToElementByJS(pass, "Autopass124@");
		clickToElementByJS(registorButton);
		sleepfunction(2);
		
		Assert.assertEquals(getElementValidationMessage(pass), "Please fill out this field.");
	}
	
	public int randomNum() {
		return new Random().nextInt(9999);
	}
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepfunction(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
