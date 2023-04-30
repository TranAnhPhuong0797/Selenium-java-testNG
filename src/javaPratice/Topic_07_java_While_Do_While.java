package javaPratice;

import java.util.Scanner;

public class Topic_07_java_While_Do_While {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// exesice_1();
		// exesice_2();
		// exesice_3();
		// exesice_4();
		// exesice_5();
		// exesice_6();
		// exesice_7();
		// exesice_8();
		// exesice_9();
		exesice_10();
	}

	public static void exesice_1() {
		int n = scanner.nextInt();

		while (n < 100) {
			if (n % 2 == 0) {
				System.out.println(n);
			}
			n++;
		}
	}

	public static void exesice_2() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		while (a < b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.println(a);
			}
			a++;
		}
	}

	public static void exesice_3() {
		int n = scanner.nextInt();
		int i = 0;
		while (n > 0) {
			if (n % 2 != 0) {
				System.out.println(n);
				i += n;
			}
			n--;
		}
		System.out.println(i);
	}

	public static void exesice_4() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		while (a < b) {
			if (a % 3 == 0) {
				System.out.println(a);
			}
			a++;
		}
	}

	public static void exesice_5() {
		int num[] = { 19, 2, 25, 1, 22, 19 };
		int x = 0;
		for (int i = 0; i < num.length; i++) {
			if (x < num[i]) {
				x = num[i];
			}
		}
		System.out.println("MaxNum: " + x);
	}
	
	public static void exesice_6() {
		int num[] = { 19, 2, 25, 1, 22, 19 };
		int x = num[0] + num[num.length -1];
		System.out.println("X = " + x);
	}
	
	public static void exesice_7() {
		int num[] = { 19, 2, 25, 1, 22, 19 };
		for (int i = 0; i < num.length; i++) {		
			if (num[i] % 2 == 0) {
				System.out.println("Even number: " + num[i]);
			}
		}
	}

	public static void exesice_8() {
		int num[] = { 19, 2, 25, 1, 22, 19 };
		int x = 0;
		for (int i = 0; i < num.length; i++) {        
            if (num[i] % 2 != 0) {
               x += num[i];
            }
        }
		System.out.println("Total: " + x);
	}
	
	public static void exesice_9() {
		int num[] = {3,-7,2,9,-11,13,14};
		for (int i = 0; i<num.length; i++) {
			if (num[i] >= 0 && num[i] <=10) {
				System.out.println("number in (0<=num<=10): " + num[i]);
			}
		}
	}
	
	public static void exesice_10() {
		int num[] = { 19, 2, 25, 1, 22, 19 };
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
		System.out.println("Sum: " + sum);
		float average = sum / num.length;
		System.out.println("Average: " + average);
	}
}
