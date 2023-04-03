package Webriver_Partice_Exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Note: Landscape & Portrait
//Step 1 Load File
//Step 2 Upload
//Step 3 Should add files into source code to another user can run test case

public class Topic_21_Selenium_UploadFile{
	WebDriver driver;
	WebDriverWait explicitwait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	//Name Picture
	String workspace_01 = "01.jpeg";
	String workspace_02 = "02.jpeg";
	String workspace_03 = "03.JPG";
	String workspace_04 = "04.jpg";
	String workspace_05 = "05.jpg";
	
	String WfilePath01 = projectPath + "\\UploadFiles\\" + workspace_03;
	String WfilePath02 = projectPath + "\\UploadFiles\\" + workspace_04;
	String WfilePath03 = projectPath + "\\UploadFiles\\" + workspace_05;
	
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
	public void TC_01_one_file_per_time() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		sleepfunction(2);
		
		//Upload 1 file
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(WfilePath01);
		sleepfunction(2);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(WfilePath02);
		sleepfunction(2);
		
		//Verify load file successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ workspace_03 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ workspace_04 + "']")).isDisplayed());
		
		//Click upload
		List<WebElement> buttonUpload = driver.findElements(By.xpath("//button[contains(@class,'btn-primary start')]/span[text()='Start upload']"));
		
		for (WebElement button : buttonUpload) {
			button.click();
			sleepfunction(3);
		}
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[text()='"+ workspace_03 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[text()='"+ workspace_04 + "']")).isDisplayed());
		sleepfunction(2);
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='preview']//img[contains(@src,'"+ workspace_03 +"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='preview']//img[contains(@src,'"+ workspace_04 +"')]")).isDisplayed());
	}
	@Test
	public void TC_02_multiple_files_per_time() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		sleepfunction(2);
		//Upload multiple files
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(WfilePath01 + "\n" + WfilePath02 + "\n" + WfilePath03);
		//Verify load file successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ workspace_03 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ workspace_04 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ workspace_05 + "']")).isDisplayed());
		
		//Click upload
		List<WebElement> buttonUpload = driver.findElements(By.xpath("//button[contains(@class,'btn-primary start')]/span[text()='Start upload']"));
		
		for (WebElement button : buttonUpload) {
			button.click();
			sleepfunction(3);
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[text()='"+ workspace_03 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[text()='"+ workspace_04 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[text()='"+ workspace_05 + "']")).isDisplayed());
		sleepfunction(2);
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='preview']//img[contains(@src,'"+ workspace_03 +"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='preview']//img[contains(@src,'"+ workspace_04 +"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='preview']//img[contains(@src,'"+ workspace_05 +"')]")).isDisplayed());
	}
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
