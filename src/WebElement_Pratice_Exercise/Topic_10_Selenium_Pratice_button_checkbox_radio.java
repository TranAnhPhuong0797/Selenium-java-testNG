package WebElement_Pratice_Exercise;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Selenium_Pratice_button_checkbox_radio {
	WebDriver driver;
	WebDriverWait explicitwait;
	JavascriptExecutor jsExcutor;
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
		//Variable initialization JS after Driver variable
		jsExcutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		explicitwait = new WebDriverWait(driver, 30);
	}

	public void sleepfunction(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		sleepfunction(2);
		
		driver.findElement(By.xpath("//li[contains(@class,'tab-login')]")).click();
		
		By btn_login = By.xpath("//button[contains(@class,'btn-login')]");
		// Verify button login disable
		Assert.assertFalse(driver.findElement(btn_login).isEnabled());
		String loginButtonbackground = driver.findElement(btn_login).getCssValue("background");
		//System.out.print(loginButtonbackgroundcolor);
		Assert.assertTrue(loginButtonbackground.contains("rgb(224, 224, 224)"));
		
		driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("Username@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("1235467");
		sleepfunction(2);
		
		// Verify button login enable
		Assert.assertTrue(driver.findElement(btn_login).isEnabled());
		
		loginButtonbackground = driver.findElement(btn_login).getCssValue("background-color");
		
		Color loginButtonbackgroundColor = Color.fromString(loginButtonbackground);
		Assert.assertEquals(loginButtonbackgroundColor.asHex().toUpperCase(), "#C92127");
	}
	
	
	@Test
	public void TC_02_Checkbox_Radiobutton() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		sleepfunction(2);
		
		//Verify checkbox tick
		if (!driver.findElement(By.xpath("//ul[@class='fieldlist']//li//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//ul[@class='fieldlist']//li//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).click();
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='fieldlist']//li//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected());
		
		//Verify checkbox untick
		if (driver.findElement(By.xpath("//ul[@class='fieldlist']//li//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//ul[@class='fieldlist']//li//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).click();
		}
		Assert.assertFalse(driver.findElement(By.xpath("//ul[@class='fieldlist']//li//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected());
		
		//Step 6,7
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
		verifyCheckboxTick("//ul[@class='fieldlist']//li//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");
	}
	
	@Test
	public void TC_03_Checkbox_Radiobutton() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		sleepfunction(2);
		
		By radiobtn = By.xpath("//div[@aria-label='Hà Nội']");
		By checkbox = By.xpath("//div[@aria-label='Quảng Nam']");
		// Syntax JavascriptExecutor
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(radiobtn));
		sleepfunction(2);
		
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(checkbox));
		sleepfunction(2);
		
		// Verify the radio button select successful
//		Assert.assertTrue(driver.findElement(radiobtn).isSelected());	
//		Assert.assertTrue(driver.findElement(checkbox).isSelected());
		
		Assert.assertEquals(driver.findElement(radiobtn).getAttribute("ariaChecked"), "true");
		Assert.assertEquals(driver.findElement(checkbox).getAttribute("ariaChecked"), "true");
	}
	
	@Test
	public void TC_04_Checkbox_Radiobutton() {
		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		sleepfunction(2);
		
		/* Case 4 */
		// Input card is disable But still use to click
		// The click function of WebElement is not click the element hidden
		// => The element must be visible and it must have a Height and Width greater than 0;
		
		// So, we should use a Click function of Javascript to click (Can click the Element is hidden)
		// Selenium provides a library for embedding code JS into the test scenario => JavascriptExecutor
		
		
		By radiobtn = By.xpath("//div[text()='Đăng ký cho người thân']//preceding-sibling::div/input");
		// Syntax JavascriptExecutor
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(radiobtn));
		sleepfunction(2);
		
		// Verify the radio button select successful
		Assert.assertTrue(driver.findElement(radiobtn).isSelected());
		
	}
	
	public void verifyCheckboxTick(String checkboxXpath) {
		if (!driver.findElement(By.xpath(checkboxXpath)).isSelected()) {
			driver.findElement(By.xpath(checkboxXpath)).click();
		}
	}
	
	public void verifyCheckboxUntick(String checkboxXpath) {
		if (driver.findElement(By.xpath(checkboxXpath)).isSelected()) {
			driver.findElement(By.xpath(checkboxXpath)).click();
		}
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
