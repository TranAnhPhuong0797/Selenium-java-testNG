package Webriver_Partice_Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Selenium_Handle_Popup_Dialog_I {
	
	
	/* Note: In case find the element NOT present in DOM. We need to use FindElements instead use FindElement function */
	
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	
	//Part I
	@Test
	public void TC_01_FixedPopup() {
		driver.get("https://ngoaingu24h.vn/");
		sleepfunction(2);
		
		By Login_popup = By.xpath("//div[@id='modal-login-v1'and@style='display: block;']//div[@class='modal-dialog']//div[@class='modal-content']");
		//By Login_popup = By.xpath("(//div[@id='modal-login-v1']//div[@class='modal-content'])[1]");
		
		//Pop-up is NOT displayed
		Assert.assertEquals(driver.findElements(Login_popup).size(), 0);
		
		driver.findElement(By.xpath("//button[@class='login_ icon-before']")).click();
		sleepfunction(2);
		
		//Pop-up is displayed
		//Assert.assertEquals(driver.findElements(Login_popup).size(), 1);
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@id='modal-login-v1']//div[@class='modal-content'])[1]")).isDisplayed());
		
		driver.findElement(By.xpath("(//input[@id='account-input'])[1]")).sendKeys("automatic");
		driver.findElement(By.xpath("(//input[@id='password-input'])[1]")).sendKeys("automatic");
		driver.findElement(By.xpath("(//button[@onclick='onLoginUser(this)'])[1]")).click();
		sleepfunction(2);
		
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='modal-login-v1']//div[@class='row error-login-panel'])[1]")).getText(), "Tài khoản không tồn tại!");
		driver.findElement(By.xpath("(//div[@id='modal-login-v1']//button[@class='close'])[1]")).click();
		
		//Pop-up is NOT displayed
		Assert.assertEquals(driver.findElements(Login_popup).size(), 0);
	}
	
	@Test
	public void TC_02_FixedPopupinDom() {
		driver.get("https://skills.kynaenglish.vn/");
		sleepfunction(2);
		
		By login_popup_KyNa = By.xpath("//div[contains(@class,'popup-account-mb')]//div[@class='modal-content']");
		
		//Pop-up is NOT displayed
		Assert.assertEquals(driver.findElements(login_popup_KyNa).size(), 0);
		
		driver.findElement(By.xpath("//a[@class='login-btn']")).click();
		sleepfunction(2);
		
		//Pop-up is displayed
		Assert.assertTrue(driver.findElement(login_popup_KyNa).isDisplayed());
		
		driver.findElement(By.xpath("//input[@id='user-login']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='user-password']")).sendKeys("123456");
		sleepfunction(1);
		
		driver.findElement(By.xpath("//button[@id='btn-submit-login']")).click();
		sleepfunction(1);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='password-form-login-message']")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
	}
	
	//Part II
	@Test
	public void TC_03_FixedPopupNotinDOM() {
		driver.get("https://tiki.vn/");
		sleepfunction(2);
		
		By loginPopup = By.xpath("//div[contains(@class,'ReactModal__Content')]");
		
		//Verify pop up still not visible
		Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
		
		//Click open Pop-up
		driver.findElement(By.xpath("//div[contains(@data-view-id,'account_container')]")).click();
		sleepfunction(2);
		
		//Verify pop up is displayed
		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
		//Assert.assertEquals(driver.findElements(loginPopup).size(), 1);
		
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("09222221434");
		sleepfunction(2);
		
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		sleepfunction(1);
		
		//Verify pop up still not visible
		Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
		
		//Click open Pop-up
		driver.findElement(By.xpath("//div[contains(@data-view-id,'account_container')]")).click();
		sleepfunction(2);
		
		driver.findElement(By.xpath("//p[@class='login-with-email']")).click();
		sleepfunction(1);
		
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		sleepfunction(1);
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).getText(), "Email không được để trống");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).getText(), "Mật khẩu không được để trống");
		
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		sleepfunction(1);
		
		//Verify pop up still not visible
		Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
	}
	
	@Test
	public void TC_04_FixedPopupNotinDOM() {
		driver.get("https://www.facebook.com/");
		sleepfunction(2);
		
		By createAccountpopup = By.xpath("//div[text()='Sign Up']/parent::div/parent::div");
		
		driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
		sleepfunction(1);
		
		//Verify pop up is displayed
		Assert.assertTrue(driver.findElement(createAccountpopup).isDisplayed());
		
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		sleepfunction(1);
		
		//Verify pop up still not visible
		Assert.assertEquals(driver.findElements(createAccountpopup).size(), 0);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
