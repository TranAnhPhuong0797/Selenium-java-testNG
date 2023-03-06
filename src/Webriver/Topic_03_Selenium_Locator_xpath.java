package Webriver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Selenium_Locator_xpath {
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
	public void TC_01_xpath_text() {
		// https://automationfc.github.io/basic-form/
		// text()=''

		driver.get("https://automationfc.github.io/basic-form/");
		WebElement btn_disable = driver.findElement(By.xpath("//button[text()='Button is disabled']"));
		btn_disable.click();

	}

	@Test
	public void TC_02_xpath_text() {
		// https://automationfc.github.io/basic-form/
		// Contain(text(),'')

		driver.get("https://automationfc.github.io/basic-form/");
		WebElement h5 = driver.findElement(By.xpath("//h5[contains(text(),'Michael Jackson')]"));
		System.out.print(h5.getSize());
	}

	@Test
	public void TC_03_xpath_text() {
		// https://automationfc.github.io/basic-form/
		// contains(.,'') = contains(string(),'')

		driver.get("https://automationfc.github.io/basic-form/");
		WebElement h5 = driver.findElement(By.xpath("//h5[contains(.,'Michael Jackson')]"));
		WebElement h5_01 = driver.findElement(By.xpath("//h5[contains(string(),'Michael Jackson')]"));
		System.out.print(h5.getSize());
		System.out.print(h5_01.getSize());
	}

	@Test
	public void TC_04_xpath_text() {
		// https://automationfc.github.io/basic-form/
		// concat

		driver.get("https://automationfc.github.io/basic-form/");
		WebElement h5 = driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));
		assertEquals(h5.getText(), "Hello \"John\", What's happened?");
	}

	@Test
	public void TC_05_xpath_and_or() {
		// https://automationfc.github.io/basic-form/
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// and
		WebElement txtName = driver.findElement(By.xpath("//input[@type='text'and@id='txtFirstname']"));
		// Or
		WebElement txtConfirmEmail = driver
				.findElement(By.xpath("//input[@placeholder='Nhập lại địa chỉ email'or@id='txtCEmail']"));

		txtName.sendKeys("Tran Van A");
		txtConfirmEmail.sendKeys("TVA1232");
	}

	@Test
	public void TC_06_xpath_not() {
		// https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx
		// Not
		driver.get(
				"https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		WebElement icon_ra = driver.findElement(By.xpath("//div[not(@stype='display:none;')]/div[@class='raDiv']"));
	}

	@Test
	public void TC_07_xpath_insideParent() {
		// https://automationfc.github.io/jquery-selectable/
		// Inside Parent
		driver.get("https://automationfc.github.io/jquery-selectable/");
		WebElement li_number = driver.findElement(By.xpath("//li[7]"));
		Assert.assertEquals(li_number.getText(), "7");
	}

	@Test
	public void TC_08_xpath_Outside_Parent() {
		// https://demo.nopcommerce.com/cell-phones
		// Outside Parent
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement image_Nokia = driver.findElement(By.xpath("(//div[@class='picture'])[1]"));

	}

	@Test
	public void TC_09_xpath_Position_Last() {
		// https://automationfc.github.io/jquery-selectable/
		// Position & Last
		driver.get("https://automationfc.github.io/jquery-selectable/");
		WebElement posiion = driver.findElement(By.xpath("//ol[@id='selectable']/li[position()='7']"));
		WebElement last = driver.findElement(By.xpath("//ol[@id='selectable']/li[last()]"));
		Assert.assertEquals(posiion.getText(), "7");
		Assert.assertEquals(last.getText(), "12");

	}

	@Test
	public void TC_09_xpath_Axes_Ancestor() {
		// https://demo.nopcommerce.com/cell-phones
		// Axes-Ancestor
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement product_card = driver
				.findElement(By.xpath("//a[text()='HTC One Mini Blue']//ancestor::div[@class='product-item']"));
		product_card.click();
	}

	@Test
	public void TC_10_xpath_Axes_Parent() {
		// https://demo.nopcommerce.com/cell-phones
		// Axes-Parent
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement lbl_prices = driver.findElement(By.xpath(
				"//a[text()='HTC One Mini Blue']//parent::h2//following-sibling::div[@class='add-info']//div[@class='prices']//span"));
		Assert.assertEquals(lbl_prices.getText(), "$100.00");
	}

	@Test
	public void TC_11_xpath_Axes_Preceding() {
		// https://demo.nopcommerce.com/cell-phones
		// Axes-Preceding
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement lbl_breadcrumb = driver
				.findElement(By.xpath("//strong[text()='Manufacturers']//preceding::div[@class='breadcrumb']//strong"));
		Assert.assertEquals(lbl_breadcrumb.getText(), "Cell phones");
	}

	@Test
	public void TC_12_xpath_Axes_Following() {
		// https://demo.nopcommerce.com/cell-phones
		// Axes-Following
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement lbl_manufacturers = driver
				.findElement(By.xpath("//strong[text()='Categories']//following::div//strong[text()='Manufacturers']"));
		Assert.assertEquals(lbl_manufacturers.getText(), "Manufacturers");
	}

	@Test
	public void TC_13_xpath_Axes_Preceding_sibling() {
		// https://demo.nopcommerce.com/cell-phones
		// Axes-Preceding sibling
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement product_picture = driver
				.findElement(By.xpath("//a[text()='HTC One Mini Blue']//ancestor::div[@class='product-item']//preceding-sibling::div[@class='picture']"));
		product_picture.click();
		
	}

	@Test
	public void TC_14_xpath_Axes_Following_sibling() {
		// https://demo.nopcommerce.com/cell-phones
		// Axes-Following sibling
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement lbl_prices = driver.findElement(By.xpath(
				"//a[text()='HTC One Mini Blue']//parent::h2//following-sibling::div[@class='add-info']//div[@class='prices']//span"));
		Assert.assertEquals(lbl_prices.getText(), "$100.00");
	}

	@Test
	public void TC_15_xpath_Axes_Child() {
		// https://demo.nopcommerce.com/cell-phones
		// Axes-Child
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement lbl_categories = driver.findElement(By.xpath(
				"//strong[text()='Categories']//parent::div//following-sibling::div//child::a[contains(text(),'Computers')]"));
		Assert.assertEquals(lbl_categories.getText(), "Computers");
	}

	@Test
	public void TC_16_xpath_Axes_Descendant() {
		// https://demo.nopcommerce.com/cell-phones
		// Axes-Descendant
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement lbl_categories = driver.findElement(By.xpath(
				"//strong[text()='Categories']//parent::div//following-sibling::div//descendant::a[contains(text(),'Cell phones')]"));
		Assert.assertEquals(lbl_categories.getText(), "Cell phones");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
