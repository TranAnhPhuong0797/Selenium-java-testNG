package javaPratice_OOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_13_Java_This_and_Super extends Topic_12_Java_Non_AccessModifier{
	// This only use in current class
	// Super use in the parent class
	
	// Interface NOT have the contractor, but Attract class has the contractor
	
	
	private int number_01;
	private int number_02;
	
	private WebDriver driver;
	
	public Topic_13_Java_This_and_Super(int num01, int num02) {
		// TODO Auto-generated constructor stub
		number_01 = num01;
		number_02 = num02;
	}

	public void sum() {
		System.out.println(number_01 + number_02);
	}
	
	
	public Topic_13_Java_This_and_Super() {
		this(20,5);
	}
	
	public void setImplicitWait() {
		long longTime = 30;
		
		// Super call to the variable in Parent class.
		// This call to the variable in global variable in same class.
		// If not This & Super the system will use the local variable.
		
		driver.manage().timeouts().implicitlyWait(super.longTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(super.shortTime, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) {
		Topic_13_Java_This_and_Super topic = new Topic_13_Java_This_and_Super(7,18);
		topic.sum();
	}
}
