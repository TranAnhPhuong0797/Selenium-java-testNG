package Webriver_Partice_Exercise;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12__Selenium_User_Interaction_I_II_III {
	WebDriver driver;
	Actions action;
	WebDriverWait explicitwait;
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
		action = new Actions(driver);
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
	public void TC_01_hoverTootip() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		sleepfunction(3);
		
		action.moveToElement(driver.findElement(By.id("age"))).perform();
		
		Assert.assertEquals(driver.findElement(By.className("ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
	}
	
	@Test
	public void TC_02_hoverTootip() {
		driver.get("http://www.myntra.com/");
		sleepfunction(3);
		
		action.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-navLinks']//a[text()='Kids']"))).perform();
		sleepfunction(3);
		driver.findElement(By.xpath("//div[@class='desktop-paneContent']//a[text()='Home & Bath']")).click();
		sleepfunction(2);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.myntra.com/kids-home-bath");
	}
	
//	@Test
//	public void TC_03_hoverTootip() {
//		driver.get("https://www.fahasa.com/");
//		sleepfunction(3);
//		
//		action.moveToElement(driver.findElement(By.xpath("//span[@class='icon_menu']"))).perform();
//		sleepfunction(1);
//		
//		action.moveToElement(driver.findElement(By.xpath("//a[@title='Sách Trong Nước']"))).perform();
//		sleepfunction(2);
//		
//		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'menu_content')]//span[text()='TIỂU SỬ - HỒI KÝ']//ancestor::h3//following-sibling::ul//a[text()='Kinh Tế']"))).perform();
//		sleepfunction(2);
//	}
	
	@Test
	public void TC_04_ClickandHold() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		sleepfunction(2);
		
		List<WebElement> listNumber = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		
		action.clickAndHold(listNumber.get(0))
		.moveToElement(listNumber.get(3))
		.release()
		.perform();
		
		sleepfunction(2);
		
		List<WebElement> listSelectedNumber = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		Assert.assertEquals(listSelectedNumber.size(), 4);
	}
	
	@Test
	public void TC_05_ClickandSelected() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		sleepfunction(2);
		
		
		List<WebElement> listNumber = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		
		//click ctrl down
		action.keyDown(Keys.CONTROL).perform();
		
		//Click random
		action.click(listNumber.get(0))
		.click(listNumber.get(5))
		.click(listNumber.get(7)).perform();
		sleepfunction(2);
		
		List<WebElement> listSelectedNumber = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		Assert.assertEquals(listSelectedNumber.size(), 3);		
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
