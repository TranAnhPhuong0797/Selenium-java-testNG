package Webriver_Partice_Exercise;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Selenium_Pratice_Handle_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, emailAddress, companyName, password;
	Random rand = new Random();
	String day, month, year;
	Select select;
	String countryName, provinceName, cityName, address, postalCode, phoneNum, faxNum;
	
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
		
		firstName = "Tony";
		lastName = "Stark";
		emailAddress = firstName+lastName + rand.nextInt(9999) + "@gmail.com";
		companyName = "FaceBook";
		password = "123456789";
		
		day = "30";
		month = "July";
		year = "1986";
		
		countryName = "United States";
		provinceName = "California";
		cityName = "Sacramento";
		address = "3440 C St, Sacramento, CA 95816, Hoa Kỳ";
		postalCode = "90210";
		phoneNum = "+19164427370";
		faxNum = "800-689-4776";
		}
	
	public void sleepfunction(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TC_01_CreateAccount() {
		//Step 1
		driver.get("https://demo.nopcommerce.com/register");
		sleepfunction(3);
		
		//Step 2
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		
		//Step 3
		driver.findElement(By.xpath("//span[@class='male']//input")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(day);
		new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
		new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);
		
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		
		//Step 4
		driver.findElement(By.id("register-button")).click();
		
		//Step 5
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		//Step 6
		//Login new account
		driver.findElement(By.cssSelector("a.ico-login")).click();
		sleepfunction(3);
		driver.findElement(By.xpath("//input[@class='email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		sleepfunction(2);
		
		driver.findElement(By.cssSelector("a.ico-account")).click();
		sleepfunction(2);
		//Verify value text field
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);
		
		//Verify value of drop-down-list
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);
	}
	
	@Test
	public void TC_02_addAddress() {
		driver.findElement(By.xpath("//li[@class='customer-addresses inactive']//a[contains(text(),'Addresses')]")).click();
		driver.findElement(By.xpath("//button[text()='Add new']")).click();
		sleepfunction(2);
		
		driver.findElement(By.id("Address_FirstName")).sendKeys(firstName);
		driver.findElement(By.id("Address_LastName")).sendKeys(lastName);
		driver.findElement(By.id("Address_Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Address_Company")).sendKeys(companyName);
		
		new Select(driver.findElement(By.id("Address_CountryId"))).selectByVisibleText(countryName);
		new Select(driver.findElement(By.id("Address_StateProvinceId"))).selectByVisibleText(provinceName);
		
		driver.findElement(By.id("Address_City")).sendKeys(cityName);
		driver.findElement(By.id("Address_Address1")).sendKeys(address);
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(postalCode);
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys(phoneNum);
		driver.findElement(By.id("Address_FaxNumber")).sendKeys(faxNum);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		sleepfunction(3);
		
		//Verify information new Account
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='name']")).getText(), firstName +  " " + lastName);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='email']")).getText().contains(emailAddress));
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='phone']")).getText().contains(phoneNum));
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='company']")).getText(), companyName);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='address1']")).getText(), address);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='city-state-zip']")).getText(), cityName + ", " + provinceName + ", " + postalCode);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='country']")).getText(), countryName);
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
