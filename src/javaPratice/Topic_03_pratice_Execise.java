package javaPratice;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_03_pratice_Execise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	@Test
	private void CheckintegerNum() {
		int Num = scanner.nextInt();
				
		if (Num % 2==0) {
			System.out.println("Num is a integer");
		}else {
			System.out.println("Num is NOT a integer");
		}
	}
	
	@Test
	private void compare2values() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();		
		if (a>=b) {
			System.out.println("number a more than or equal number b");
		}else if (a<=b) {
			System.out.println("number a less than or equal number b");
		}
	}
	
	@Test
	private void checkName2People() {
		String Person1 = scanner.nextLine();
		String Person2 = scanner.nextLine();
		Person1 = "Nguyen Van Teo";
		Person2 = "Nguyen Van Teo";
		
		if (Person1.equals(Person2)) {
			System.out.println("2 People have same name");
		}else {
			System.out.println("2 People haven't same name");
		}
	}
	
	@Test
	private void compare3values() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		if (a<b && b <c) {
			System.out.println(c + " is a biggest number");
		}else if (a<b && b>c) {
			System.out.println(b + " is a biggest number");
		}else {
			System.out.println(a + " is a biggest number");
		}
	}
	
	@Test
	private void compareBoundary() {
		int number = scanner.nextInt();
		if (10 <= number && number <= 100) {
			System.out.println(number + " in rand");
		}else {
			System.out.println(number + " out rand because the rand from 10 to 100");
		}
		
	}
	
	@Test
	private void comparePointandAnalysisRatings() {
		double Point = scanner.nextInt();
		
		if (0 <= Point && Point <= 5) {
			System.out.println("Your rating is D. Because your score is between 0 and 5" + " Your point: " + Point);
		}else if (5 <= Point && Point <= 7.5) {
			System.out.println("Your rating is C. Because your score is between 5 and 7.5" + " Your point: " + Point);
		}else if (7.5 <= Point && Point <= 8.5) {
			System.out.println("Your rating is B. Because your score is between 7.5 and 8.5" + " Your point: " + Point);
		}else if (8.5 <= Point && Point <= 10) {
			System.out.println("Your rating is A. Because your score is between 8.5 and 10" + " Your point: " + Point);
		}else {
			System.out.println("Please enter again.");
		}
	}
	
	@Test
	private void InputMonthPrintDayofMonth() {
		int month = scanner.nextInt();
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("This month have 31 days");
		}else if (month == 1) {
			System.out.println("This month have 28 days");
		}else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("This month have 30 days");
		}
	}
}

