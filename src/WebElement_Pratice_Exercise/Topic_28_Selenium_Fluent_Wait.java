package WebElement_Pratice_Exercise;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_28_Selenium_Fluent_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicit;
	FluentWait<WebDriver> fluentD;
	FluentWait<WebElement> fluentE;
	long allTime = 15;
	long pollingTime = 200;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	

	public void TC_01_Fluent_Wait(){	
		//Implicit Wait
		driver.findElement(By.id("email"));
		
		//Explicit Wait
		explicit.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		//Fluent Wait
		//Initialization Fluent wait
		fluentD = new FluentWait<WebDriver>(driver);
		//Fluent Wait, Set total time and frequency
		fluentD.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(300))
			.ignoring(NoSuchElementException.class);
		//Apply condition
		fluentD.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.cssSelector(""));
			}
		});
	}
	
	@Test
	public void TC_02_Fluent_Wait(){	
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		//Initialization Fluent wait
		fluentD = new FluentWait<WebDriver>(driver);
		//Fluent Wait, Set total time and frequency
		fluentD.withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofMillis(300))
		.ignoring(NoSuchElementException.class);
		
		//Apply condition
		WebElement startButton =  fluentD.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("div#start>button"));
			}
		});
		
		startButton.click();
	}
	
	@Test
	public void TC_03_Fluent_Wait_usingFunction(){	
		driver.get("https://automationfc.github.io/fluent-wait/");
		
		WebElement coundDown = findElement("//div[@id='javascript_countdown_time']");
		fluentE = new FluentWait<WebElement>(coundDown);
		
		fluentE.withTimeout(Duration.ofSeconds(allTime))
		.pollingEvery(Duration.ofMillis(pollingTime))
		.ignoring(NoSuchElementException.class);
		
		fluentE.until(new Function<WebElement, Boolean>() {

			@Override
			public Boolean apply(WebElement element) {
				String text = element.getText();
				System.out.println(text);
				return text.endsWith("00");
			}
		});
	}
	
	@Test
	public void TC_04_Fluent_Wait_usingFunction(){	
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		findElement("//div[@id='start']/button").click();
		Assert.assertEquals(findElement("//div[@id='finish']/h4").getText(), "Hello World!");
	}
	
	
	public WebElement findElement(final String xpath) {
		fluentD = new FluentWait<WebDriver>(driver);
		fluentD.withTimeout(Duration.ofSeconds(allTime)).pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class);
		return fluentD.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath(xpath));
			}
		});
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
