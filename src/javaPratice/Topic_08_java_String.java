package javaPratice;

import java.util.Scanner;

public class Topic_08_java_String {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Execise_01();
		Execise_02();
	}
	
	public static void Execise_01() {
		String inputString = scanner.nextLine();
		char valueInput[] = inputString.toCharArray();
		int countUp = 0;
		int countdown = 0;
		for (char string : valueInput) {
			if (string < 'Z' && string > 'A') {
				countUp ++;
			}else if (string > 'a' && string < 'z') {
				countdown ++;
			}
		}
		
		System.out.println("Number uppercase = " + countUp);
		System.out.println("Number lowercase = " + countdown);
	}
	
	public static void Execise_02() {
		String value = "Automation Testing 345 Tutorials Online 789";
		char valueInput[] = value.toCharArray();
		int count = 0;
		for (char charactor : valueInput) {
			if (charactor == 'a') {
				count ++;
			}
			
//			if (charactor == 'T') {
//				System.out.println(charactor);
//			}
		}
		
		if (value.contains("Testing")) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		if (value.startsWith("Automation")) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		if (value.endsWith("Online")) {
			System.out.println(false);
		}else {
			System.out.println(true);
		}
		
		
		System.out.println("Number charactor 'A' = " + count);
		
		System.out.println(value.replace("Online", "Offline"));
		
		System.out.println(value.length());
	}
}
