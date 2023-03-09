package Webriver_Partice_Exercise;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Selenium_Pratice_Browser {
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

	public void sleepfunction(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TC_01_Verify_Url() {
		// Click button My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		sleepfunction(3);

		// Verify URL Login Page
		String CurrentURL_Loginpage = driver.getCurrentUrl();
		assertEquals(CurrentURL_Loginpage, "http://live.techpanda.org/index.php/customer/account/login/");
		// Click button Create an Account
		driver.findElement(
				By.xpath("//span[contains(text(),'Create an Account')]//ancestor::a[@title='Create an Account']"))
				.click();
		sleepfunction(3);

		String CurrentURL_Registerpage = driver.getCurrentUrl();
		assertEquals(CurrentURL_Registerpage, "http://live.techpanda.org/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_Verify_Title() {
		// Click button My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		sleepfunction(3);
		// Verify Title Login Page
		String title_Loginpage = driver.getTitle();
		assertEquals(title_Loginpage, "Customer Login");
		// Click button Create an Account
		driver.findElement(
				By.xpath("//span[contains(text(),'Create an Account')]//ancestor::a[@title='Create an Account']"))
				.click();
		sleepfunction(3);
		// Verify Title Register Page
		String title_Registerpage = driver.getTitle();
		assertEquals(title_Registerpage, "Create New Customer Account");
	}

	@Test
	public void TC_03_Navigae_Fuction() {
		// Click button My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		sleepfunction(3);
		// Click button Create an Account
		driver.findElement(
				By.xpath("//span[contains(text(),'Create an Account')]//ancestor::a[@title='Create an Account']"))
				.click();
		sleepfunction(3);

		// Verify URL Register Page
		String currentURL_Registerpage = driver.getCurrentUrl();
		assertEquals(currentURL_Registerpage, "http://live.techpanda.org/index.php/customer/account/create/");

		// Create variable
		Navigation Nav = driver.navigate();

		// Back to Login Page
		Nav.back();
		sleepfunction(3);
		assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		// Forward to Register page
		Nav.forward();
		sleepfunction(3);
		assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_04_Get_Page_Source_Code() {
		// Click button My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepfunction(3);

		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

		// Click button Create an Account
		driver.findElement(
				By.xpath("//span[contains(text(),'Create an Account')]//ancestor::a[@title='Create an Account']"))
				.click();
		sleepfunction(3);
		
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
