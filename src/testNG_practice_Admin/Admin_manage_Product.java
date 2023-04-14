package testNG_practice_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Admin_manage_Product {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeTest(alwaysRun = true)
	public void initBroser() {
		System.out.println("----------------Print Open Browser--------------");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	
	@Test(groups = "product")
	public void product_01() {
		
	}
	
	@Test(groups = "product")
	public void product_02() {
		
	}
	
	@Test(groups = "product")
	public void product_03() {
		
	}
	
	@AfterTest(alwaysRun = true)
	public void closeBroser() {
		System.out.println("----------------Print Close Browser--------------");
		driver.quit();
	}
	
}
