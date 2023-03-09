package Webriver_Partice_Exercise;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Selenium_WebDriver_WebElement_Pratice {
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

		driver.get("http://live.techpanda.org/");
	}

	@Test
	public void TC_01_Verify_Url() {
		// Get elements
		WebElement footer_Myaccount = driver
				.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]"));

		footer_Myaccount.click();
		// Verify URL Login Page
		String CurrentURL = driver.getCurrentUrl();
		assertEquals(CurrentURL, "http://live.techpanda.org/index.php/customer/account/login/");
	}

	@Test
	public void TC_02_Verify_Title() {
		//Precondition - Navigate to Login page - based on TC01
		// Verify Title Login Page
		String title_Loginpage = driver.getTitle();
		assertEquals(title_Loginpage, "Customer Login");

		// Get elements
		WebElement btb_createAccount = driver.findElement(
				By.xpath("//span[contains(text(),'Create an Account')]//ancestor::a[@title='Create an Account']"));
		btb_createAccount.click();
		// Verify Title Register Page
		String title_Registerpage = driver.getTitle();
		assertEquals(title_Registerpage, "Create New Customer Account");
	}

	@Test
	public void TC_03_Navigae_Fuction() {
		//Precondition - Navigate to Register page - based on TC02
		// Verify URL Register Page
		String currentURL_Registerpage = driver.getCurrentUrl();
		assertEquals(currentURL_Registerpage, "http://live.techpanda.org/index.php/customer/account/create/");
		
		// Create variable
		Navigation Nav = driver.navigate();
		
		// Back to Login Page
		Nav.back();
		assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		// Forward to Register page
		Nav.forward();
		assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_04_Get_Page_Source_Code() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
