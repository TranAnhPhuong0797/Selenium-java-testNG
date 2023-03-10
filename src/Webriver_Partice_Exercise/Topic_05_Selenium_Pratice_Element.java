package Webriver_Partice_Exercise;

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

public class Topic_05_Selenium_Pratice_Element {
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
	public void TC_01_() {
		navigatetoURL();
		sleepfunction(3);
		//get element
		WebElement txt_email = driver.findElement(By.xpath("//label[@for = 'mail']//following-sibling::input[@id='mail']"));

		WebElement rdo_age = driver.findElement(By.xpath("//label[text()='Age:']//following-sibling::input[@id='under_18']"));

		WebElement txa_edu = driver.findElement(By.xpath("//label[text()='Education:']//following-sibling::textarea[@id='edu']"));
		
		WebElement href_profileUser = driver.findElement(By.xpath("//div[@class='figcaption']//h5[contains(text(),'User5')]//following-sibling::a"));
		//verify element is displayed
		Assert.assertEquals(txt_email.isDisplayed(), true);
		Assert.assertEquals(rdo_age.isDisplayed(), true);
		Assert.assertEquals(txa_edu.isDisplayed(), true);		
		
		//Verify element is not visible
		Assert.assertEquals(href_profileUser.isDisplayed(), false);
		
		//Input value 2 fields Email & Education
		txt_email.sendKeys("automationtesting@email.com");
		txa_edu.sendKeys("Automation Testing");
		
		//Select radio button
		rdo_age.click();
	}

	@Test
	public void TC_02_() {
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
	public void TC_03_() {
		navigatetoURL();
		sleepfunction(3);
	}

	@Test
	public void TC_04_() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
