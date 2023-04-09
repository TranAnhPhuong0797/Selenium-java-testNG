package WebElement_Pratice_Exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/*Static Wait*/
/*Implicit Wait*/
/*Explicit Wait*/

public class Topic_25_26_Selenium_Explicitwait_Part_III {
	WebDriver driver;
	WebDriverWait explicitwait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	String workspace_01 = "03.JPG";
	String workspace_02 = "04.jpg";
	String workspace_03 = "05.jpg";
	
	String WfilePath01 = projectPath + "\\UploadFiles\\" + workspace_01;
	String WfilePath02 = projectPath + "\\UploadFiles\\" + workspace_02;
	String WfilePath03 = projectPath + "\\UploadFiles\\" + workspace_03;
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
		explicitwait = new WebDriverWait(driver, 50);
	}
	
	// This is the function related to Static Wait
	public void sleepfunction(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond, 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	//@Test
	public void TC_01(){
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		//Wait until loading Icon visible
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.RadCalendar")));
		
		//Verify no selected date to display
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");
		
		//Wait until 19th can click
		explicitwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=19]")));
		//Click element
		driver.findElement(By.xpath("//a[text()=19]")).click();
		
		//Wait until loading Icon Invisible
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
		
		//Wait the date is selected still can click again
		explicitwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='rcSelected']/a[text()='19']")));
		
		//Verify Selected dates
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Wednesday, April 19, 2023");
	}
	
	@Test
	public void TC_02(){
		driver.get("https://gofile.io/uploadFiles");
		
		//Wait until the element "Add files" visible
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#filesUpload button.filesUploadButton")));
		
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(WfilePath01 + "\n" + WfilePath02 + "\n" + WfilePath03);
		
		//Wait for the Loading Icons for each file Invisible
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.progress")));
		
		//Wait the successfully mess is visible
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-auto text-center']//div[text()='Your files have been successfully uploaded']")));
		
		//Verify the successfully mess is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-auto text-center']//div[text()='Your files have been successfully uploaded']")).isDisplayed());
		
		//Wait until the element "Add files" clickable
		explicitwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a")));
		
		//Click button Show file
		driver.findElement(By.cssSelector("div.mainUploadSuccessLink a")).click();
		
		//Wait until the file name & Buttons Download / Play visible
		Assert.assertTrue(explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+workspace_01+"']/parent::a/parent::div/following-sibling::div//button/span[text()='Download']"))).isDisplayed());
		Assert.assertTrue(explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+workspace_01+"']/parent::a/parent::div/following-sibling::div//button/span[text()='Close']"))).isDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
