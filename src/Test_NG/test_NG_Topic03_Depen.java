package Test_NG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_NG_Topic03_Depen {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeTest
	public void initBroser() {
		System.out.println("----------------Print Open Browser--------------");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test
	public void product_01() {
		System.out.println("Test 01");
	}
	
	@Test(dependsOnGroups = "product_01")
	public void product_02() {
		System.out.println("Test 02");
	}
	
	@Test(dependsOnGroups = "product_02")
	public void product_03() {
		System.out.println("Test 03");
	}
	
	@AfterTest
	public void closeBroser() {
		System.out.println("----------------Print Close Browser--------------");
		driver.quit();
	}
}
