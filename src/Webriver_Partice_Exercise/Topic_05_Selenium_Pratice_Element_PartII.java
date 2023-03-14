package Webriver_Partice_Exercise;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Selenium_Pratice_Element_PartII {
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

	public void navigatetoURL() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
	}

	public void sleepfunction(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String random_email() {
		Random rand = new Random();
		String email_address = "Automation" + rand.nextInt(9999) + "@gmail.com";
		return email_address;
	}

	@Test
	public void TC_01_Login_Empty_Email_Pass() {
		navigatetoURL();
		sleepfunction(2);

		// empty email and password field
		// click submit
		driver.findElement(By.xpath("//button[@type='submit'and@title='Login']")).click();

		// Get element error mess
		WebElement err_email = driver.findElement(By.xpath(
				"//input[@type='email'and@title='Email Address']//following-sibling::div[@id='advice-required-entry-email']"));
		WebElement err_pass = driver.findElement(By.xpath(
				"//input[@type='password'and@title='Password']//following-sibling::div[@id='advice-required-entry-pass']"));
		// Verify err mess displayed
		if (err_email.isDisplayed()) {
			System.out.println("error message Email textbox is displayed");
		} else {
			System.out.println("error message Email textbox is NOT displayed");
		}

		if (err_pass.isDisplayed()) {
			System.out.println("error message Password textbox is displayed");
		} else {
			System.out.println("error message Password textbox is NOT displayed");
		}

	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		navigatetoURL();
		sleepfunction(2);
		// Input valid password and invalid email
		driver.findElement(By.xpath("//input[@type='email'and@title='Email Address']")).sendKeys("123456@999111");
		driver.findElement(By.xpath("//input[@type='password'and@title='Password']")).sendKeys("123456");
		// click submit
		driver.findElement(By.xpath("//button[@type='submit'and@title='Login']")).click();

		// Verify error message invalid field
		WebElement err_invalid_email = driver
				.findElement(By.xpath("//div[@class='validation-advice' and @id='advice-validate-email-email']"));
		if (err_invalid_email.isDisplayed()) {
			Assert.assertEquals(err_invalid_email.getText(),
					"Please enter a valid email address. For example johndoe@domain.com.");
		} else {
			System.out.println("error message Email textbox is NOT displayed");
		}
	}

	@Test
	public void TC_03_Login_Pass_less_than_6Char() {
		navigatetoURL();
		sleepfunction(2);

		// Input valid email and invalid password
		driver.findElement(By.xpath("//input[@type='email'and@title='Email Address']"))
				.sendKeys("phuongtran@gmail.com");
		driver.findElement(By.xpath("//input[@type='password'and@title='Password']")).sendKeys("123");
		// click submit
		driver.findElement(By.xpath("//button[@type='submit'and@title='Login']")).click();
		// Verify error message invalid field
		WebElement err_invalid_password = driver
				.findElement(By.xpath("//div[@class='validation-advice' and @id='advice-validate-password-pass']"));
		if (err_invalid_password.isDisplayed()) {
			Assert.assertEquals(err_invalid_password.getText(),
					"Please enter 6 or more characters without leading or trailing spaces.");
		} else {
			System.out.println("error message Password textbox is NOT displayed");
		}
	}

	@Test
	public void TC_04_Login_Incorrect_Email_Pass() {
		navigatetoURL();
		sleepfunction(2);

		driver.findElement(By.xpath("//input[@type='email'and@title='Email Address']")).sendKeys(random_email());
		driver.findElement(By.xpath("//input[@type='password'and@title='Password']")).sendKeys("123456");
		// click submit
		driver.findElement(By.xpath("//button[@type='submit'and@title='Login']")).click();
		// Verify error message invalid field
		WebElement err_invalid_password = driver.findElement(By.xpath("//li[@class='error-msg']//span"));
		if (err_invalid_password.isDisplayed()) {
			Assert.assertEquals(err_invalid_password.getText(), "Invalid login or password.");
		} else {
			System.out.println("error message Password textbox is NOT displayed");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
