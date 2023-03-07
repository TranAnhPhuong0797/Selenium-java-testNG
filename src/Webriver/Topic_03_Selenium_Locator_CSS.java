package Webriver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//Note: This class introduces about the method used to get elements by "CSS"

public class Topic_03_Selenium_Locator_CSS {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_CSS() {
		// Direct child node
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement txtFirstname = driver.findElement(By.cssSelector("div>input[id='txtFirstname']"));
		txtFirstname.sendKeys("A");
	}

	@Test
	public void TC_02_CSS() {
		// Sub child
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement menu = driver.findElement(By.cssSelector("ul[class='fsubmenu'] a[rel='nofollow']"));

	}

	@Test
	public void TC_03_CSS() {
		// Id
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement txtEmail = driver.findElement(By.cssSelector("input[id='txtEmail']"));
		WebElement txtCEmail = driver.findElement(By.cssSelector("#txtCEmail"));
		WebElement txtPassword = driver.findElement(By.cssSelector("input#txtPassword"));

		txtEmail.sendKeys("tranvana@gmail.com");
		txtCEmail.sendKeys("tranvana@gmail.com");
		txtPassword.sendKeys("AAhhaopp@");
	}

	@Test
	public void TC_04_CSS() {
		// Class
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement btnRegistor = driver.findElement(By.cssSelector("button[class='btn_pink_sm fs16']"));

		btnRegistor.click();
	}

	@Test
	public void TC_05_CSS() {
		// Attribute @ là được
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement txtfName = driver.findElement(By.cssSelector("input[name='txtFirstname']"));

		txtfName.sendKeys("David Degea");

	}

	@Test
	public void TC_06_CSS() {
		// Multiple Attribute - And
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");

	}

	@Test
	public void TC_07_CSS() {
		// Multiple Attribute - or
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement txtEmail = driver.findElement(By.cssSelector("input[id='txtEmail'],[name='email']"));

		txtEmail.sendKeys("dgea@gmail.com");
	}

	@Test
	public void TC_08_CSS() {
		// Not
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement NottxtCEmail = driver.findElement(By.cssSelector("input:not([id='txtCEmail'])"));
	}

	@Test
	public void TC_09_CSS() {
		// Contains
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement placePhone = driver.findElement(By.cssSelector("input[placeholder*='Chúng tôi cam kết']"));

		placePhone.sendKeys("0944261672");
	}

	@Test
	public void TC_10_CSS() {
		// Start with
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement placePhone = driver.findElement(By.cssSelector("input[placeholder^='Chúng tôi']"));

		placePhone.sendKeys("0944261672");
	}

	@Test
	public void TC_11_CSS() {
		// End with
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement placePhone = driver.findElement(By.cssSelector("input[placeholder$='điện thoại của bạn.']"));

		placePhone.sendKeys("0944261672");
	}

	@Test
	public void TC_12_CSS() {
		// Index
		driver.get("https://automationfc.github.io/jquery-selectable/");
		WebElement index = driver.findElement(By.cssSelector("ol[class='ui-selectable']>li:nth-child(7)"));
		assertEquals(index.getText(), "7");
	}
	
	@Test
	public void TC_13_CSS() {
		// First Index
		driver.get("https://automationfc.github.io/jquery-selectable/");
		WebElement Firstindex = driver.findElement(By.cssSelector("ol[class='ui-selectable']>li:first-child"));
		assertEquals(Firstindex.getText(), "1");
	}
	
	@Test
	public void TC_14_CSS() {
		// Last Index
		driver.get("https://automationfc.github.io/jquery-selectable/");
		WebElement Lastindex = driver.findElement(By.cssSelector("ol[class='ui-selectable']>li:last-child"));
		assertEquals(Lastindex.getText(), "12");
	}
	
	@Test
	public void TC_15_CSS() {
		// Following-sibling
		driver.get("https://automationfc.github.io/jquery-selectable/");
		WebElement followingsibling = driver.findElement(By.cssSelector(""));
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
