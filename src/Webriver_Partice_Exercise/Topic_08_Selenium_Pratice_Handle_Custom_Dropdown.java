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
		selectIteminDropdown("//label[text()='Select a speed']//following-sibling::span[@id='speed-button']",
				"//ul[@id='speed-menu']//div[@role='option']", "Medium");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(),
				"Medium");

		// Select slower value
		selectIteminDropdown("//label[text()='Select a speed']//following-sibling::span[@id='speed-button']",
				"//ul[@id='speed-menu']//div[@role='option']", "Slower");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(),
				"Slower");

		// Select faster value
		selectIteminDropdown("//label[text()='Select a speed']//following-sibling::span[@id='speed-button']",
				"//ul[@id='speed-menu']//div[@role='option']", "Faster");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(),
				"Faster");

	}

	@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

		selectIteminDropdown("//div[@role='listbox']", "//div[@class='visible menu transition']//div[@role='option']",
				"Elliot Fu");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@role='listbox']//div[@class='divider text']")).getText(),
				"Elliot Fu");

		selectIteminDropdown("//div[@role='listbox']", "//div[@class='visible menu transition']//div[@role='option']",
				"Christian");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@role='listbox']//div[@class='divider text']")).getText(),
				"Christian");

		selectIteminDropdown("//div[@role='listbox']", "//div[@class='visible menu transition']//div[@role='option']",
				"Jenny Hess");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@role='listbox']//div[@class='divider text']")).getText(),
				"Jenny Hess");
	}

	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		selectIteminDropdown("//div[@class='btn-group']", "//ul[@class='dropdown-menu']//li//a", "Second Option");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),
				"Second Option");
		
		selectIteminDropdown("//div[@class='btn-group']", "//ul[@class='dropdown-menu']//li//a", "First Option");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),
				"First Option");
		
		selectIteminDropdown("//div[@class='btn-group']", "//ul[@class='dropdown-menu']//li//a", "Third Option");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),
				"Third Option");
	}
	
	@Test
	public void TC_04_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		enterIteminDropdown("//input[@type='text']", "//div[@role='listbox']//div[@role='option']", "Anguilla");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='divider text']")).getText(),
				"Anguilla");
		
		enterIteminDropdown("//input[@type='text']", "//div[@role='listbox']//div[@role='option']", "Albania");
		sleepfunction(3);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='divider text']")).getText(),
				"Albania");
	}

	public void selectIteminDropdown(String parentXpath, String allItembyXpath, String expectedItem) {
		// This function build for TC-01,02,03

		// 1 - Click the element to open drop-down list
		driver.findElement(By.xpath(parentXpath)).click();
		sleepfunction(1);

		// 2 - Wait all items are loading successfully
		// Condition - the locator must be represent for all items
		// Get the text of element
		explicitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItembyXpath)));

		// Move all elements are got to a List
		List<WebElement> speedDropdown = driver.findElements(By.xpath(allItembyXpath));

		// 3 - Find the item you want to use it (Use the for function)
		for (WebElement tempItem : speedDropdown) {
			//String itemText = tempItem.getText();

			// 4 - find the text of item
			if (tempItem.getText().trim().equals(expectedItem)) {
				sleepfunction(1);
				// 5- Click the item
				tempItem.click();

				// Break after can select item
				break;
			}
		}
	}
	
	public void enterIteminDropdown(String textboxtXpath, String allItembyXpath, String expectedItem) {
		// This function build for TC-04
		// 1- ensure the element empty value
		driver.findElement(By.xpath(textboxtXpath)).clear();
		sleepfunction(1);
		
		// 2 - send key the element to open drop-down list
		driver.findElement(By.xpath(textboxtXpath)).sendKeys(expectedItem);;
		sleepfunction(1);

		// 2 - Wait all items are loading successfully
		// Condition - the locator must be represent for all items
		// Get the text of element
		explicitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItembyXpath)));

		// Move all elements are got to a List
		List<WebElement> speedDropdown = driver.findElements(By.xpath(allItembyXpath));

		// 3 - Find the item you want to use it (Use the for function)
		for (WebElement tempItem : speedDropdown) {
			//String itemText = tempItem.getText();

			// 4 - find the text of item
			if (tempItem.getText().trim().equals(expectedItem)) {
				sleepfunction(1);
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
