package WebElement_Pratice_Exercise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Note: Auto IT is a third party tool and only use it on WINDOW

public class Topic_22_Selenium_UploadFile_autoIT_javaRobo {
	WebDriver driver;
	WebDriverWait explicitwait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	//Name Picture
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
	public void TC_01_JavaRobo_one_file_per_time() throws AWTException {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		sleepfunction(2);
		
		driver.findElement(By.cssSelector("span.btn-success")).click();
		
		//Load file
		loadfilebyRobo(WfilePath01);
		
		//Verify load file successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ workspace_03 + "']")).isDisplayed());
	}
	
	
	public void loadfilebyRobo(String fiepath) throws AWTException {
		//Copy file path
		StringSelection select = new StringSelection(fiepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		
		//load file
		Robot robo = new Robot();
		sleepfunction(1);
		
		//Put Ctrl + V
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		//
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		sleepfunction(2);
		
		//Click enter
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		sleepfunction(1);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
