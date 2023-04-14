package Test_NG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class test_NG_Topic02_Annotation {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Print Before Suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Print Before TEST");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Print Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Print Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Print After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Print After Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Print After TEST");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Print After Suite");
	}

}
