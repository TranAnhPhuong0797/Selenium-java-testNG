package WebElement_Pratice_Exercise;

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

public class Topic_05_Selenium_Pratice_Element_PartI {
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
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}

	public void sleepfunction(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TC_01_Verify_isDisplayed() {
		navigatetoURL();
		sleepfunction(3);
		//get element
		WebElement txt_email = driver.findElement(By.xpath("//label[@for = 'mail']//following-sibling::input[@id='mail']"));

		WebElement rdo_age = driver.findElement(By.xpath("//label[text()='Age:']//following-sibling::input[@id='under_18']"));

		WebElement txa_edu = driver.findElement(By.xpath("//label[text()='Education:']//following-sibling::textarea[@id='edu']"));
		
		WebElement href_profileUser = driver.findElement(By.xpath("//div[@class='figcaption']//h5[contains(text(),'User5')]//following-sibling::a"));
				
		//verify element is displayed
		if(txt_email.isDisplayed())
		{
			txt_email.sendKeys("automationtesting@email.com");
			System.out.println("Email textbox is displayed");
		}else {
			System.out.println("Email textbox is NOT displayed");
		}
		
		if(rdo_age.isDisplayed()) {
			System.out.println("Value under 18 is displayed");
		}else {
			System.out.println("Value under 18 is NOT displayed");
		}
		
		if(txa_edu.isDisplayed()) {
			txa_edu.sendKeys("Automation Testing");
			System.out.println("Education textbox is displayed");
		}else {
			System.out.println("Education textbox is NOT displayed");
		}
		
		//Verify element is not visible
		if(href_profileUser.isDisplayed()) {
			System.out.println("User textbox is displayed");
		}else {
			System.out.println("User textbox is NOT displayed");
		}
		//Select radio button
		rdo_age.click();
	}

	@Test
	public void TC_02_Verify_isEnabled() {
		navigatetoURL();
		sleepfunction(3);
		//get element
		WebElement txt_email = driver.findElement(By.xpath("//label[@for = 'mail']//following-sibling::input[@id='mail']"));

		WebElement rdo_age = driver.findElement(By.xpath("//label[text()='Age:']//following-sibling::input[@id='under_18']"));

		WebElement txa_edu = driver.findElement(By.xpath("//label[text()='Education:']//following-sibling::textarea[@id='edu']"));
		
		WebElement dropdown_job = driver.findElement(By.xpath("//label[@for='job1']//following-sibling::select[@name='user_job1']"));
		
		WebElement mulselect_job = driver.findElement(By.xpath("//label[@for='job2']//following-sibling::select[@name='user_job2' and @multiple='multiple']"));
		
		WebElement checkbox_dev = driver.findElement(By.xpath("//label[contains(text(),'Interests:')]//following-sibling::input[@type='checkbox' and @id='development']"));
		
		WebElement slider_01 = driver.findElement(By.xpath("//input[@name='slider-1']"));
		
		//Get element disable
		WebElement txt_pass = driver.findElement(By.xpath("//label[@for = 'password']//following-sibling::input[@type='password']"));
		
		WebElement rdo_agedisable = driver.findElement(By.xpath("//label[text()='Age:']//following-sibling::input[@id='radio-disabled']"));
		
		WebElement txa_biography = driver.findElement(By.xpath("//label[text()='Biography:']//following-sibling::textarea[@id='bio']"));
		
		WebElement dropdown_jobdisable = driver.findElement(By.xpath("//label[@for='job3']//following-sibling::select[@name='user_job3']"));
		
		WebElement checkbox_disbale = driver.findElement(By.xpath("//label[contains(text(),'Interests:')]//following-sibling::input[@type='checkbox' and @id='check-disbaled']"));
		
		WebElement slider_02 = driver.findElement(By.xpath("//input[@name='slider-2']"));
		
		//Verify element is enabled		
		Assert.assertEquals(txt_email.isEnabled(), true);
		Assert.assertEquals(rdo_age.isEnabled(), true);
		Assert.assertEquals(txa_edu.isEnabled(), true);
		Assert.assertEquals(dropdown_job.isEnabled(), true);
		Assert.assertEquals(mulselect_job.isEnabled(), true);
		Assert.assertEquals(checkbox_dev.isEnabled(), true);
		Assert.assertEquals(slider_01.isEnabled(), true);
		
		////Verify element is disabled
		Assert.assertEquals(txt_pass.isEnabled(), false);
		Assert.assertEquals(rdo_agedisable.isEnabled(), false);
		Assert.assertEquals(txa_biography.isEnabled(), false);
		Assert.assertEquals(dropdown_jobdisable.isEnabled(), false);
		Assert.assertEquals(checkbox_disbale.isEnabled(), false);
		Assert.assertEquals(slider_02.isEnabled(), false);
	}

	@Test
	public void TC_03_Verify_isSelected() {
		navigatetoURL();
		sleepfunction(3);
		//Get elements
		WebElement rdo_age = driver.findElement(By.xpath("//label[text()='Age:']//following-sibling::input[@id='under_18']"));
		WebElement checkbox_java = driver.findElement(By.xpath("//label[contains(text(),'Languagues:')]//following-sibling::input[@type='checkbox' and @id='java']"));
		
		//Verify default value are unchecked
		Assert.assertEquals(rdo_age.isSelected(), false);
		Assert.assertEquals(checkbox_java.isSelected(), false);
		
		//Click elements
		rdo_age.click();
		checkbox_java.click();
		
		//Verify elements is selected
		sleepfunction(2);
		if(rdo_age.isSelected()) {
			System.out.println("Value under 18 is selected");
		}else {
			System.out.println("Value under 18 is NOT selected");
		}
		
		if(checkbox_java.isSelected()) {
			System.out.println("Value Java is selected");
		}else {
			System.out.println("Value Java is NOT selected");
		}		
				
		//Uncheck element
		checkbox_java.click();
		
		//Verify elements is NOT selected
		Assert.assertEquals(checkbox_java.isSelected(), false);
	}

	@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		sleepfunction(3);
		//Get Elements
		WebElement txt_email = driver.findElement(By.xpath("//input[@id = 'email']"));
		WebElement txt_user = driver.findElement(By.xpath("//input[@id = 'new_username']"));
		WebElement txt_password = driver.findElement(By.xpath("//input[@id = 'new_password']"));
		WebElement btn_signup = driver.findElement(By.id("create-account-enabled"));
		

		txt_password.sendKeys("abc");
		sleepfunction(3);
		
		//Verify Lower case
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		txt_password.clear();
		txt_password.sendKeys("ACB");
		sleepfunction(3);
		
		//Verify Upper case
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		txt_password.clear();
		txt_password.sendKeys("7");
		sleepfunction(3);
		//Verify One number
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		txt_password.clear();
		txt_password.sendKeys("@");
		sleepfunction(3);
		//Verify One special character
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		txt_password.clear();
		txt_password.sendKeys("123456789");
		sleepfunction(3);
		//Verify 8 characters minimum
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		txt_password.clear();
		txt_password.sendKeys("rey:9fipQGw6Jc:");
		sleepfunction(3);
		//Verify correct password
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@aria-label='Password helper text']")).isDisplayed(), false);
		/*
		driver.navigate().refresh();
		sleepfunction(3);
		//Input value the field Email
		txt_email.sendKeys("phuonganh@gmail.com");
		sleepfunction(3);
		btn_signup.click();
		sleepfunction(3);
		Assert.assertEquals(txt_user.getText(), "phuonganh@gmail.com");
		*/
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
