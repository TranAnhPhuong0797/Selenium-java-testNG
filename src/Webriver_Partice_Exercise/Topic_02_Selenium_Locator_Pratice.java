package Webriver_Partice_Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator_Pratice {
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

	@Test
	public void TC_01_Register_emptyData() {
		// Navigate to Register page
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Get element button Register
		WebElement btn_Register = driver.findElement(By.xpath("//button[@type='submit']"));

		// Scenario
		// 1- Click register button
		btn_Register.click();

		// 2- Get element err mess
		WebElement err_txtName = driver.findElement(By.xpath("//label[@id='txtFirstname-error']"));
		WebElement err_txtEmail = driver.findElement(By.xpath("//label[@id='txtEmail-error']"));
		WebElement err_txtConfirmEmail = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));
		WebElement err_txtPassword = driver.findElement(By.xpath("//label[@id='txtPassword-error']"));
		WebElement err_txtConfrimPassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']"));
		WebElement err_txtPhone = driver.findElement(By.xpath("//label[@id='txtPhone-error']"));

		// 3- get text err mess
		String err_Name = err_txtName.getText();
		String err_Email = err_txtEmail.getText();
		String err_cEmail = err_txtConfirmEmail.getText();
		String err_Password = err_txtPassword.getText();
		String err_cPassword = err_txtConfrimPassword.getText();
		String err_Phone = err_txtPhone.getText();

		// 4- compare text
		Assert.assertEquals(err_Name, "Vui l??ng nh???p h??? t??n");
		Assert.assertEquals(err_Email, "Vui l??ng nh???p email");
		Assert.assertEquals(err_cEmail, "Vui l??ng nh???p l???i ?????a ch??? email");
		Assert.assertEquals(err_Password, "Vui l??ng nh???p m???t kh???u");
		Assert.assertEquals(err_cPassword, "Vui l??ng nh???p l???i m???t kh???u");
		Assert.assertEquals(err_Phone, "Vui l??ng nh???p s??? ??i???n tho???i.");

	}

	@Test
	public void TC_02_Register_invalidEmail() {
		// Navigate to Register page
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Get Element
		WebElement txtName = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='txtEmail']"));
		WebElement txtConfirmEmail = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		WebElement txtConfrimPassword = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
		WebElement txtPhone = driver.findElement(By.xpath("//input[@id='txtPhone']"));

		// Get element button Register
		WebElement btn_Register = driver.findElement(By.xpath("//button[@type='submit']"));

		// Scenario
		// 1-Input invalid email and fill all valid value for remain fields
		txtName.sendKeys("Tran Van A");
		txtEmail.sendKeys("tranvan@a@mail");
		txtConfirmEmail.sendKeys("tranvan@a@mail");
		txtPassword.sendKeys("TVA1232");
		txtConfrimPassword.sendKeys("TVA1232");
		txtPhone.sendKeys("0933283910");

		// 2- click button Register
		btn_Register.click();

		// 3- Get element err email mess
		WebElement err_txtEmail = driver.findElement(By.xpath("//label[@id='txtEmail-error']"));
		WebElement err_txtConfirmEmail = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));

		// 4- Get text err email mess
		String err_invalidEmail = err_txtEmail.getText();
		String err_invalidCemail = err_txtConfirmEmail.getText();

		// 5- compare text
		Assert.assertEquals(err_invalidEmail, "Vui l??ng nh???p email h???p l???");
		Assert.assertEquals(err_invalidCemail, "Email nh???p l???i kh??ng ????ng");
	}

	@Test
	public void TC_03_Register_confirmEmail() {
		// Navigate to Register page
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Get Element
		WebElement txtName = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='txtEmail']"));
		WebElement txtConfirmEmail = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		WebElement txtConfrimPassword = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
		WebElement txtPhone = driver.findElement(By.xpath("//input[@id='txtPhone']"));

		// Get element button Register
		WebElement btn_Register = driver.findElement(By.xpath("//button[@type='submit']"));

		// Scenario
		// 1-Input invalid email and fill all valid value for remain fields
		txtName.sendKeys("Tran Van A");
		txtEmail.sendKeys("tranvana@gmail.com");
		txtConfirmEmail.sendKeys("tranvanB@gmail.com");
		txtPassword.sendKeys("TVA1232");
		txtConfrimPassword.sendKeys("TVA1232");
		txtPhone.sendKeys("0933283910");

		// 2- click button Register
		btn_Register.click();

		// 3- Get element err confirm email mess
		WebElement err_txtConfirmEmail = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));

		// 4- Get text err confirm email mess
		String err_invalidCemail = err_txtConfirmEmail.getText();

		// 5- compare text
		Assert.assertEquals(err_invalidCemail, "Email nh???p l???i kh??ng ????ng");

	}

	@Test
	public void TC_04_Register_PasswordLessthan6characters() {
		// Navigate to Register page
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Get Element
		WebElement txtName = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='txtEmail']"));
		WebElement txtConfirmEmail = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		WebElement txtConfrimPassword = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
		WebElement txtPhone = driver.findElement(By.xpath("//input[@id='txtPhone']"));

		// Get element button Register
		WebElement btn_Register = driver.findElement(By.xpath("//button[@type='submit']"));

		// Scenario
		// 1-Input invalid email and fill all valid value for remain fields
		txtName.sendKeys("Tran Van A");
		txtEmail.sendKeys("tranvana@gmail.com");
		txtConfirmEmail.sendKeys("tranvana@gmail.com");
		txtPassword.sendKeys("TVA");
		txtConfrimPassword.sendKeys("TVA");
		txtPhone.sendKeys("0933283910");

		// 2- click button Register
		btn_Register.click();

		// 3- Get element err password mess
		WebElement err_txtPassword = driver.findElement(By.xpath("//label[@id='txtPassword-error']"));
		WebElement err_txtConfrimPassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']"));

		// 4- Get text err password mess
		String err_lenPassword = err_txtPassword.getText();
		String err_lenCpassword = err_txtConfrimPassword.getText();

		// 5- compare text
		Assert.assertEquals(err_lenPassword, "M???t kh???u ph???i c?? ??t nh???t 6 k?? t???");
		Assert.assertEquals(err_lenCpassword, "M???t kh???u ph???i c?? ??t nh???t 6 k?? t???");
	}

	@Test
	public void TC_05_Register_incorrectConfirmpassword() {
		// Navigate to Register page
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Get Element
		WebElement txtName = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='txtEmail']"));
		WebElement txtConfirmEmail = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		WebElement txtConfrimPassword = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
		WebElement txtPhone = driver.findElement(By.xpath("//input[@id='txtPhone']"));

		// Get element button Register
		WebElement btn_Register = driver.findElement(By.xpath("//button[@type='submit']"));

		// Scenario
		// 1-Input invalid email and fill all valid value for remain fields
		txtName.sendKeys("Tran Van A");
		txtEmail.sendKeys("tranvana@gmail.com");
		txtConfirmEmail.sendKeys("tranvana@gmail.com");
		txtPassword.sendKeys("TVA112233@");
		txtConfrimPassword.sendKeys("TVA112233@@");
		txtPhone.sendKeys("0933283910");

		// 2- click button Register
		btn_Register.click();

		// 3- Get element err confirm password mess
		WebElement err_txtConfrimPassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']"));

		// 4- Get text err confirm password mess
		String err_lenCpassword = err_txtConfrimPassword.getText();

		// 5- compare text
		Assert.assertEquals(err_lenCpassword, "M???t kh???u b???n nh???p kh??ng kh???p");
	}

	@Test
	public void TC_06_Register_incorrectPhonenumber() {
		// Navigate to Register page
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Get Element
		WebElement txtName = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='txtEmail']"));
		WebElement txtConfirmEmail = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		WebElement txtConfrimPassword = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
		WebElement txtPhone = driver.findElement(By.xpath("//input[@id='txtPhone']"));

		// Get element button Register
		WebElement btn_Register = driver.findElement(By.xpath("//button[@type='submit']"));

		// Scenario
		// 1-Input invalid email and fill all valid value for remain fields
		txtName.sendKeys("Tran Van A");
		txtEmail.sendKeys("tranvana@gmail.com");
		txtConfirmEmail.sendKeys("tranvana@gmail.com");
		txtPassword.sendKeys("TVA112233@");
		txtConfrimPassword.sendKeys("TVA112233@");
		txtPhone.sendKeys("09332839");

		// 2- click button Register
		btn_Register.click();

		// 3- Get element err phone mess
		WebElement err_txtPhone = driver.findElement(By.xpath("//label[@id='txtPhone-error']"));

		// 4- Get text err phone mess
		String err_lenPhone = err_txtPhone.getText();

		// 5- compare text
		Assert.assertEquals(err_lenPhone, "S??? ??i???n tho???i ph???i t??? 10-11 s???.");

		// 6- clear value phone field
		txtPhone.clear();

		// 7 - Input the number difference house network
		txtPhone.sendKeys("88211331");

		// 8- click button Register
		btn_Register.click();

		// 9 - Get text err phone mess
		err_lenPhone = err_txtPhone.getText();

		// 10- compare text
		Assert.assertEquals(err_lenPhone,
				"S??? ??i???n tho???i b???t ?????u b???ng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
