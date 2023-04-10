package WebElement_Pratice_Exercise;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

/*Implicit Wait: Impact to the function Find Element & Find Elements - If not find element throw the exception NoSuchElement*/
/*Explicit Wait: */
/*Implicit Wait include Explicit Wait because if you use to Explicit wait. This function must be find Element so it impart to Implicit Wait */
public class Topic_27_Selenium_Mix_Implicit_Explicit {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicit;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	

	@Test
	public void TC_01_Element_Found(){
		//Get timeout Implicit
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		//Get timeout Explicit
		explicit = new WebDriverWait(driver, 8);
		
		driver.get("https://www.facebook.com/");
		
		//Explicit
		System.out.println("TC_01: Start Explicit" + getDateTimeSecondNow() + "-----");
		explicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
		System.out.println("TC_01: End Explicit" + getDateTimeSecondNow() + "-----");
		
		//Implicit
		System.out.println("TC_01: Start Implicit" + getDateTimeSecondNow() + "-----");
		driver.findElement(By.cssSelector("input#email"));
		System.out.println("TC_01: End Implicit" + getDateTimeSecondNow() + "-----");	
	}
	
	@Test
	public void TC_02_Element_Not_Found_Only_Implicit(){		
		//Get timeout Implicit
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		System.out.println("TC_02: Start Implicit" + getDateTimeSecondNow() + "-----");
		try {
			driver.findElement(By.cssSelector("input#email"));
		} catch (Exception e) {
			System.out.println("TC_02: End Implicit" + getDateTimeSecondNow() + "-----");
		}			
			
	}
	
	@Test
	public void TC_03_Element_Not_Found_Implicit_Explicit(){		
		//Get timeout Implicit
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		//Get timeout Explicit
		explicit = new WebDriverWait(driver, 8);

		driver.get("https://www.facebook.com/");
		
		System.out.println("TC_03: Start Implicit" + getDateTimeSecondNow() + "-----");
		try {
			driver.findElement(By.cssSelector("input#email"));
		} catch (Exception e) {
			System.out.println("TC_03: End Implicit" + getDateTimeSecondNow() + "-----");
		}	
		
		//Explicit
		System.out.println("TC_03: Start Explicit" + getDateTimeSecondNow() + "-----");
		try {
			explicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("TC_03: End Explicit" + getDateTimeSecondNow() + "-----");		
		}		
		
	}
	
	@Test
	public void TC_04_Element_Not_Found_Explicit_By(){	
		//Get timeout Explicit
		explicit = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
		
		//Explicit
		System.out.println("TC_04: Start Explicit" + getDateTimeSecondNow() + "-----");
		try {
			explicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("TC_03: End Explicit" + getDateTimeSecondNow() + "-----");	
		}
	}
	
	@Test
	public void TC_05_Element_Not_Found_Explicit_Element(){	
		//Get timeout Explicit
		explicit = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
		
		//Explicit
		System.out.println("TC_04: Start Explicit" + getDateTimeSecondNow() + "-----");
		try {
			explicit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#automate"))));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("TC_03: End Explicit" + getDateTimeSecondNow() + "-----");	
		}
	}
	
	@Test
	public void TC_06_Real(){	
		//Get timeout Explicit
		explicit = new WebDriverWait(driver, 15);
		
		driver.get("https://www.facebook.com/");
		
		explicit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#email"))));
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("");
	}
	
	public String getDateTimeSecondNow() {
		// TODO Auto-generated method stub
		Date date = new Date(0);	
		return date.toString();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
