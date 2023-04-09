package WebElement_Pratice_Exercise;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Selenium_Window_Tab {
	WebDriver driver;
	WebDriverWait explicitwait;
	Alert aler;
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
			Thread.sleep(timeInsecond, 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Only use for 2 Id, if more than 2 id this function will run fail
	public void switchtoWindowByID(String currentWindowID) {
		//Get all ID
		Set<String> allID = driver.getWindowHandles();
		
		//Use For function to check ID tab
		for (String Id : allID) {
			if (!Id.equals(currentWindowID)) {
				driver.switchTo().window(Id);
				sleepfunction(2);
			}
		}
	}
	
	//This function can use more than 2 ID
	public void switchtoWindowByTitle(String pageTitle) {
		//Get all ID
		Set<String> allID = driver.getWindowHandles();
		
		for (String Id : allID) {
			driver.switchTo().window(Id);
			System.out.println(driver.getTitle());
			String actualTitle = driver.getTitle();
			
			if (actualTitle.equals(pageTitle)) {
				break;
			}
		}
	}
	
	public void closeAllwindowWithoutParent(String parentID) {
		//Get all ID
		Set<String> allID = driver.getWindowHandles();
		
		for (String Id : allID) {
			if (!Id.equals(parentID)) {
				driver.switchTo().window(Id);
				driver.close();
				sleepfunction(2);
			}
		}
	}
	
	@Test
	public void TC_01_TabID() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Get Current ID of current tab
		String parentWindow = driver.getWindowHandle();
		System.out.println("Page: " + parentWindow);
		
		//Click the Google link to open new tab
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepfunction(3);
		
		//function switch window
		parentWindow = driver.getWindowHandle();
		switchtoWindowByID(parentWindow);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");
		
		//Get current ID again
		String googleWindow = driver.getWindowHandle();
		
		//function switch window
		switchtoWindowByID(googleWindow);
		assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		
		//Facebook
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();	
		sleepfunction(2);
		//Tiki
		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		sleepfunction(2);
		
		switchtoWindowByTitle("Facebook – log in or sign up");
		assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		
		switchtoWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		assertEquals(driver.getCurrentUrl(), "https://tiki.vn/");
		
		switchtoWindowByTitle("Google");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");
		
		closeAllwindowWithoutParent(parentWindow);
	}
	
	@Test
	public void TC_02_Title() {
		driver.get("https://kyna.vn/");
		sleepfunction(2);
		String parentWindow = driver.getWindowHandle();
		//Click Facebook
		driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='facebook']")).click();
		sleepfunction(2);
		//Click Youtobe
		driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='youtube']")).click();
		sleepfunction(2);
		
		//Verify new tab Facebook
		switchtoWindowByTitle("Kyna.vn | Facebook");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/kyna.vn");
		sleepfunction(2);
		//Verify new tab Youtobe
		switchtoWindowByTitle("Kyna.vn - YouTube");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/user/kynavn");
		sleepfunction(2);
		
		//Back to tab Kyna
		switchtoWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
		Assert.assertEquals(driver.getCurrentUrl(), "https://skills.kynaenglish.vn/");
		
		//Click Bo Cong Thuong
		driver.findElement(By.xpath("//img[contains(@src,'dathongbao')]")).click();
		sleepfunction(4);
		//Verify tab Bo Cong Thuong
		switchtoWindowByTitle("Thông tin website thương mại điện tử - Online.Gov.VN");
		Assert.assertEquals(driver.getCurrentUrl(), "http://online.gov.vn/Home/WebDetails/61473");
		sleepfunction(2);
		
		//Back to tab Kyna
		switchtoWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
		Assert.assertEquals(driver.getCurrentUrl(), "https://skills.kynaenglish.vn/");
		sleepfunction(2);
		
		//Verify tab Bo Cong Thuong
		driver.findElement(By.xpath("//img[contains(@src,'logoCCDV')]")).click();
		sleepfunction(4);
		
		switchtoWindowByTitle("Thông tin website thương mại điện tử - Online.Gov.VN");
		Assert.assertEquals(driver.getCurrentUrl(), "http://online.gov.vn/Home/WebDetails/60140");
		sleepfunction(2);
		
		closeAllwindowWithoutParent(parentWindow);
	}
	
	@Test
	public void TC_03_Liveguru() {
		driver.get("http://live.techpanda.org/");
		sleepfunction(2);
		
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		sleepfunction(2);
		
		driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		sleepfunction(2);
		Assert.assertEquals(driver.findElement(By.xpath("(//li[@class='success-msg']//li/span)[1]")).getText(), "The product Samsung Galaxy has been added to comparison list.");
		driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		sleepfunction(2);				
		Assert.assertEquals(driver.findElement(By.xpath("(//li[@class='success-msg']//li/span)[1]")).getText(), "The product IPhone has been added to comparison list.");
		
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		sleepfunction(2);
		
		switchtoWindowByTitle("Products Comparison List - Magento Commerce");
		Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='product-name']//a[@title='IPhone']")).getText().contains("IPHONE"));
		Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='product-name']//a[@title='Samsung Galaxy']")).getText().contains("SAMSUNG GALAXY"));
		driver.findElement(By.xpath("//button[@title='Close Window']")).click();
		
		switchtoWindowByTitle("Mobile");
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/mobile.html");
		
		driver.findElement(By.xpath("//a[text()='Clear All']")).click();
		sleepfunction(2);
		
		aler = driver.switchTo().alert();
		Assert.assertEquals(aler.getText(), "Are you sure you would like to remove all products from your comparison?");
		aler.accept();
		
	}
	
	@Test
	public void TC_04_Liveguru() {
		driver.get("https://dictionary.cambridge.org/vi/");
		sleepfunction(2);
		String parentWindow = driver.getWindowHandle();
		
		
		
		driver.findElement(By.xpath("//header//span[text()='Đăng nhập']")).click();
		sleepfunction(2);
		
		switchtoWindowByTitle("Login");
		sleepfunction(2);
		
		driver.findElement(By.xpath("//h2[text()='Log in with your email account']//following-sibling::div[contains(@class,'submit')]/input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@aria-label='Email']//following-sibling::span[text()='This field is required']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@aria-label='Password']//following-sibling::span[text()='This field is required']")).isDisplayed());
		
		closeAllwindowWithoutParent(parentWindow);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}