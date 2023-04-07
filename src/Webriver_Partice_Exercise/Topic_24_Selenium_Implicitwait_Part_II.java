package Webriver_Partice_Exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_24_Selenium_Implicitwait_Part_II {
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

		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		//Apply 10s for waiting find element
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	
	@Test
	public void TC_01_FindElement(){
		// - Find only 1 element/Node
		// - Find and do action on the Node
		// - Can find the Node, so do not wait until 10s timeout
		driver.findElement(By.cssSelector("input#email"));
		
		// - If find more than 1 element/Node
		// - It will take action the first Node
		// - Don't care the remain node
		// - In case if you find wrong element -> it will find the element wrong
		driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
		
		// - If no element can find
		// - Re-check again = 0.5s will find once
		// - If in the time can see the element -> this case will Pass
		// - If until 10s and don't see the element
		// => Fail test case
		// => Throw: NoSuchElementExeption
		driver.findElement(By.cssSelector("input#company"));
	}
	
	@Test
	public void TC_02_FindElements(){
		// - Find only 1 element/Node
		// - Save it into the list = 1 Element
		// - Can find the Node, so do not wait until 10s timeout
		List<WebElement> elements = driver.findElements(By.cssSelector("input#email"));
		System.out.print("Number: " + elements.size());
		
		// - If find more than 1 element/Node
		// - Save it into the list = all the elements can find
		elements = driver.findElements(By.cssSelector("input"));
		System.out.print("Number: " + elements.size());
		
		// - If no element can find
		// - Re-check again = 0.5s will find once
		// - If in the time can see the element -> this case will Pass
		// - If until 10s and don't see the element
		// => Not Fail test case
		// => Return the empty list = 0
		elements = driver.findElements(By.cssSelector("input#employee"));
		System.out.print("Number: " + elements.size());
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
