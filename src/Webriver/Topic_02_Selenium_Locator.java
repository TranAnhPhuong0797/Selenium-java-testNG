package Webriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_ID() {
		//Get Locator by ID
		driver.get("https://demos.telerik.com/kendo-ui/button/index");
		driver.findElement(By.id("primaryTextButton")).click();
	}

	@Test
	public void TC_02_Class() {
		//Get Locator by Class
		driver.get("https://demo.nopcommerce.com/search");
		driver.findElement(By.className("search-text")).sendKeys("Dell");
	}

	@Test
	public void TC_03_Name() {
		//Get Locator by Name
		driver.findElement(By.name("advs")).click();
	}

	@Test
	public void TC_04_Tagname() {
		//Get Locator by Tagname
		System.out.print(driver.findElement(By.tagName("button")).getSize());
	}
	
	@Test
	public void TC_05_Linktext() {
		//Get Locator by Link text
		//Link tuyet doi
		driver.findElement(By.linkText("Privacy notice")).click();
	}
	
	@Test
	public void TC_06_PartialLinktext() {
		//Get Locator by Partial Link Text
		//Link tuong doi
		driver.findElement(By.partialLinkText("Privacy")).click();
	}
	
	@Test
	public void TC_07_CSS() {
		//Get Locator by CSS
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("ATF-CSS First name");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("ATF-CSS Last name");
		driver.findElement(By.cssSelector("input[id=Email]")).sendKeys("ATF-CSS Email");
		driver.findElement(By.cssSelector("input[name=Company]")).sendKeys("ATF-CSS Company");
	}
	
	@Test
	public void TC_08_Xpath() {
		//Get Locator by Xpath
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.findElement(By.xpath("//label[text()= 'First name:']//following::input[@id='FirstName']")).sendKeys("ATF-Xpath First name");
		driver.findElement(By.xpath("//input[@name= 'LastName']")).sendKeys("ATF-Xpath");
		driver.findElement(By.xpath("//input[@data-val-required= 'Email is required.']")).sendKeys("ATF-Xpath");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("ATF-Xpath Company");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
