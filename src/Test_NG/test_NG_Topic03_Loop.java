package Test_NG;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test_NG_Topic03_Loop {
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
	
	@Test (invocationCount = 3)
	public void Register() {
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");
		
		driver.findElement(By.id("firstname")).sendKeys("Automation");
		driver.findElement(By.id("lastname")).sendKeys("Tester");
		String emailadds = "auto" + getrandomnum() + "@gmail.com";
		System.out.println("Email add:" + emailadds);
		driver.findElement(By.id("email_address")).sendKeys(emailadds);
		driver.findElement(By.id("password")).sendKeys("1243678");
		driver.findElement(By.id("confirmation")).sendKeys("1243678");
		driver.findElement(By.cssSelector("button[title='Register']")).click();
		
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("Automation Tester"));
		
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}
	
	private int getrandomnum() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
