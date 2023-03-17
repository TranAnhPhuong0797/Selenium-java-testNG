package Webriver_Partice_Exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Selenium_Pratice_Textbox_TextArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Random rand = new Random();
	String employee_id = "AFC" + rand.nextInt(9999);
	String passport_num = rand.nextInt(99999) + "-" + rand.nextInt(999) + "-" + rand.nextInt(99) + "-" + rand.nextInt(9999);
	
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

	}
	
	public String random_email() {
		String email_address = "Automation" + rand.nextInt(9999) + "@gmail.com";
		return email_address;
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
		//driver.get("http://live.techpanda.org/");
		//driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		
	}
	
	@Test
	public void TC_02_Create_Employee() {
		//Step 1
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//Login page
		//Step 2
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepfunction(5);
		
		//Open PIM
		//Step 3
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		sleepfunction(3);
		
		//Add employee
		//Step 4
		driver.findElement(By.xpath("//a[contains(text(),'Add Employee')]")).click();
		sleepfunction(3);
		
		//Input valid Text box First name / Last name
		//Step 5
		WebElement value_firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		WebElement value_middlename = driver.findElement(By.xpath("//input[@name='middleName']"));
		WebElement value_lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
		
		value_firstname.sendKeys("Automation");
		value_middlename.sendKeys("Test");
		value_lastname.sendKeys("FC");

		WebElement txt_employee = driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div//following-sibling::div/input"));
		txt_employee.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		sleepfunction(1);
		txt_employee.sendKeys(Keys.DELETE);
		txt_employee.sendKeys(employee_id);
		sleepfunction(2);
		driver.findElement(By.xpath("//p[text()='Create Login Details']/parent::div//span")).click();
		sleepfunction(5);
		
		driver.findElement(By.xpath("//label[text()='Username']//parent::div//following-sibling::div//input")).sendKeys("Automation " + employee_id);
		driver.findElement(By.xpath("//label[text()='Password']//parent::div//following-sibling::div//input")).sendKeys("Pass@123456");
		driver.findElement(By.xpath("//label[text()='Confirm Password']//parent::div//following-sibling::div//input")).sendKeys("Pass@123456");
		//Step 6
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		sleepfunction(8);
		
		//Step 7
		WebElement value_idemployee = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div//following-sibling::div/input"));		

		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Automation");
		Assert.assertEquals(driver.findElement(By.name("middleName")).getAttribute("value"), "Test");
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "FC");
		Assert.assertEquals(value_idemployee.getAttribute("value"), employee_id);
		
		//Step 8
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepfunction(5);
		
		//Step 9
		driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();
		sleepfunction(2);
		
		//Step 10
		WebElement txt_passportNum = driver.findElement(By.xpath("//label[text()='Number']/parent::div//following-sibling::div/input"));
		WebElement tat_comment = driver.findElement(By.xpath("//label[text()='Comments']/parent::div//following-sibling::div/textarea"));
		
		txt_passportNum.sendKeys(passport_num);
		tat_comment.sendKeys("Automation test comment");		
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		sleepfunction(8);
		
		//Step 11
		driver.findElement(By.xpath("//i[contains(@class,'pencil')]")).click();
		sleepfunction(3);
		//Step 12
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div//following-sibling::div/input")).getAttribute("value"), passport_num);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div//following-sibling::div/textarea")).getAttribute("value"), "Automation test comment");
		
		//Step 14
		driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		sleepfunction(8);
		
		//Step 15
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Automation " + employee_id);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepfunction(5);
		
		//Step 16
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//span[text()='My Info']")).click();
		sleepfunction(5);
		
		//Step 17
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Automation");
		Assert.assertEquals(driver.findElement(By.name("middleName")).getAttribute("value"), "Test");
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "FC");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div//following-sibling::div/input")).getAttribute("value"), employee_id);
		
		//Step 18
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepfunction(5);
		driver.findElement(By.xpath("//i[contains(@class,'pencil')]")).click();
		sleepfunction(3);
		
		//Step 19
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div//following-sibling::div/input")).getAttribute("value"), passport_num);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div//following-sibling::div/textarea")).getAttribute("value"), "Automation test comment");
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
