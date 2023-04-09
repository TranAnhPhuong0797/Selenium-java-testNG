package WebElement_Pratice_Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Note: Condition Wait:
// Case 1: Element visible (Visible, Displayed, Visibility)
//			+) Have on UI - Required
//			+) Have on HTML Tree (DOM) - Required

// Case 2: Element NOT visible (Invisible, Undisplayed, Invisibility)
//			+) NOT have on UI - Required
//			+) Have on HTML Tree (DOM)

// Case 3: Element have in HTML Tree (Presence)
//			+) NOT have on UI
//			+) Have on HTML Tree (DOM) - Required

//			+) Have on UI
//			+) Have on HTML Tree (DOM) - Required

// Case 4: Element staleness
//		+) NOT have on UI - Required
//		+) NOT have on HTML Tree (DOM) - Required

public class Topic_23_Selenium_Wait_Part_I {
	WebDriver driver;
	WebDriverWait explicitwait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		explicitwait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void TC_01_Visible(){
		driver.get("https://www.facebook.com/");
		// Case 1: Element visible (Visible, Displayed, Visibility)
		//		+) Have on UI - Required
		//		+) Have on HTML Tree (DOM) - Required
		
		//Wait until element visible
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	}
	
	@Test
	public void TC_02_Invisible_I(){
		driver.get("https://www.facebook.com/");
		// Case 2: Element NOT visible (Invisible, Undisplayed, Invisibility)
		//		+) NOT have on UI - Required
		//		+) Have on HTML Tree (DOM)
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Wait untile element invisible
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
	}
	
	@Test
	public void TC_02_Invisible_II(){
		driver.get("https://www.facebook.com/");
		// Case 4: Element staleness
		//		+) NOT have on UI - Required
		//		+) NOT have on HTML Tree (DOM) - Required
		
		//Wait untile element invisible
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
	}
	
	@Test
	public void TC_03_Presence_I(){
		driver.get("https://www.facebook.com/");
		// Case 3: Element have in HTML Tree (Presence)
		//		+) NOT have on UI
		//		+) Have on HTML Tree (DOM) - Required
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		explicitwait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
	}	
	
	@Test
	public void TC_03_Presence_II(){
		driver.get("https://www.facebook.com/");
		// Case 3: Element have in HTML Tree (Presence)
		//		+) Have on UI
		//		+) Have on HTML Tree (DOM) - Required
		
		explicitwait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
	}
	
	@Test
	public void TC_04_Staleness(){
		driver.get("https://www.facebook.com/");
		// Case 4: Element staleness
		//		+) NOT have on UI - Required
		//		+) NOT have on HTML Tree (DOM) - Required
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		WebElement reEnterTextbox = driver.findElement(By.name("reg_email_confirmation__"));
		//Close Pop-up
		driver.findElement(By.cssSelector("img._8idr")).click();
		
		explicitwait.until(ExpectedConditions.stalenessOf(reEnterTextbox));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
