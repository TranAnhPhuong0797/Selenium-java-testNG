package Webriver_Partice_Exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Selenium_Pratice_Handle_Custom_Dropdown {

	WebDriver driver;
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
	public void TC_01_JQuery() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		// Select medium value
		selectIteminDropdown("//label[text()='Select a speed']//following-sibling::span[@id='speed-button']", "//ul[@id='speed-menu']//div[@role='option']", "Medium");
		sleepfunction(3);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(), "Medium");
		
		// Select slower value
		selectIteminDropdown("//label[text()='Select a speed']//following-sibling::span[@id='speed-button']", "//ul[@id='speed-menu']//div[@role='option']", "Slower");
		sleepfunction(3);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(), "Slower");
		
		// Select faster value
		selectIteminDropdown("//label[text()='Select a speed']//following-sibling::span[@id='speed-button']", "//ul[@id='speed-menu']//div[@role='option']", "Faster");
		sleepfunction(3);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(), "Faster");
		
	}

	@Test
	public void TC_02_ReactJS() {
		// Step 1
		// driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
	}

	@Test
	public void TC_03_VueJS() {
		// Step 1
//		driver.get("https://mikerodham.github.io/vue-dropdowns/");
	}

	public void selectIteminDropdown(String parentXpath, String allItembyXpath, String expectedItem) {
		//This function build for TC-01
		
		// 1 - Click the element to open drop-down list
		driver.findElement(By.xpath(parentXpath)).click();

		// 2 - Wait all items are loading successfully
		// Condition - the locator must be represent for all items
		// Get the text of element
		explicitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItembyXpath)));

		// Move all elements are got to a List
		List<WebElement> speedDropdown = driver.findElements(By.xpath(allItembyXpath));

		// 3 - Find the item you want to use it (Use the for function)
		for (WebElement tempItem : speedDropdown) {
			String itemText = tempItem.getText();

			// 4 - find the text of item
			if (itemText.equals(expectedItem)) {
				// 5- Click the item
				tempItem.click();

				// Break after can select item
				break;
			}
		}
	}

	public WebDriver getDriver() {

		return driver;
	}

	@Test
	public void TC_04_Editable() {
		// Step 1
		// driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
