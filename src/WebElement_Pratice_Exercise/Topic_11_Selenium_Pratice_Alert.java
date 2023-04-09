package WebElement_Pratice_Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Selenium_Pratice_Alert {
	WebDriver driver;
	WebDriverWait explicitwait;
	Alert alert;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String alerkey;
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();

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
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		sleepfunction(3);
		
		//Case 1 - can switch and interact
		//alert = driver.switchTo().alert();
		
		//Case 2 - need to wait function before switch to alert (This case should use)
		explicitwait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		
		//Verify alert title as expected result
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
		
	}
	
	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		sleepfunction(3);
		
		explicitwait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		//Verify alert title as expected result
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		
		alert.dismiss();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
	}
	
	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		sleepfunction(3);
		
		explicitwait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		
		alerkey = "SendKey";
		alert.sendKeys(alerkey);
		sleepfunction(2);
		
		alert.accept();
		 
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + alerkey);
	}
	
	@Test
	public void TC_04_Authentication_Alert() {
		
		driver.get(passUserandPasstourl("http://the-internet.herokuapp.com/basic_auth", "admin", "admin"));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}
	
	
	public String passUserandPasstourl(String URL, String userName, String Pass) {
		String[] array = URL.split("//");
		return array[0] + "//" + userName + ":" + Pass + "@" + array[1];
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
