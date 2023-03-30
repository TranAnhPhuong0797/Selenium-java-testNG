package Webriver_Partice_Exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Selenium_Frame_Iframe {
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
	public void TC_01_() {
		driver.get("https://skills.kynaenglish.vn/");
		sleepfunction(2);
		
		//Verify Facebook Iframe displayed
		if (driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")).isDisplayed()) {
			//Need switch to Iframe
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")));
			sleepfunction(2);
			
			String FacebookLike = driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText();
			Assert.assertEquals(FacebookLike, "165K likes");
			
			//Switch to Mainline
			driver.switchTo().defaultContent();
			sleepfunction(2);
			
			//From Main line switch to Iframe chat
			driver.switchTo().frame("cs_chat_iframe");
			sleepfunction(2);
			
			driver.findElement(By.xpath("//div[contains(@class,'button_bar')]")).click();
			sleepfunction(1);
			
			driver.findElement(By.xpath("//input[contains(@class,'input_name')]")).sendKeys("Test user");
			driver.findElement(By.xpath("//input[contains(@class,'input_phone')]")).sendKeys("0922381920");
			new Select(driver.findElement(By.xpath("//select[@id='serviceSelect']"))).selectByVisibleText("HỖ TRỢ KỸ THUẬT");
			driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Test comment");
			sleepfunction(2);
			
			//Switch to Mainline
			driver.switchTo().defaultContent();
			
			//Search on global search
			driver.findElement(By.id("live-search-bar")).sendKeys("Excel");
			driver.findElement(By.xpath("//button[@class='search-button']")).click();
			sleepfunction(2);
			
		}else {
			System.out.println("NOT Visible");
		}
	}
	
	@Test
	public void TC_02_() {
		//driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
