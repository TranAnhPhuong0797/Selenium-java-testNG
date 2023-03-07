package Webriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//Note: This class introduces about the method used to Run on Multiple Browsers

public class Topic_04_run_on_browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@Test
	public void TC_01_run_on_Chrome() {
		// Browser Chrome
		if(osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
		
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/cell-phones");
		driver.quit();
	}

	@Test
	public void TC_02_run_on_Firefox() {
		// Browser Firefox
		if(osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/cell-phones");
		driver.quit();
	}

	@Test
	public void TC_03_run_on_Edge() {
		// Browser Edge
		if(osName.contains("Windows")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}else {
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
		}
		
		driver = new EdgeDriver();
		driver.get("https://demo.nopcommerce.com/cell-phones");
		driver.quit();
	}
}
