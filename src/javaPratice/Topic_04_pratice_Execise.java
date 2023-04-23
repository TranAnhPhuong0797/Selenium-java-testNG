package javaPratice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_pratice_Execise {
	Scanner scanner = new Scanner(System.in);
	@Test
	private void TC_01() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
			System.out.println("This month have 31 days");
			break;
		case 2:
			System.out.println("This month have 28 days");
			break;
		case 3:
			System.out.println("This month have 31 days");
			break;
		case 4:
			System.out.println("This month have 30 days");
			break;
		case 5:
			System.out.println("This month have 31 days");
			break;
		case 6:
			System.out.println("This month have 30 days");
			break;
		case 7:
			System.out.println("This month have 31 days");
			break;
		case 8:
			System.out.println("This month have 31 days");
			break;
		case 9:
			System.out.println("This month have 30 days");
			break;
		case 10:
			System.out.println("This month have 31 days");
			break;
		case 11:
			System.out.println("This month have 30 days");
			break;
		case 12:
			System.out.println("This month have 31 days");
			break;
		
		}
	}
	
	@Test
	private void TC_02() {
		int numA = scanner.nextInt();
		switch (numA) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Fouth");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nice");
			break;
		case 10:
			System.out.println("Ten");
			break;
		}
	}
}
