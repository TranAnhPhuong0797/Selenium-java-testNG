package javaPratice;

import static org.testng.Assert.fail;

public class Topic_02_pratice_Execise {
	public static void main(String[] args) {
		calculator();
		RectangularArea();
		printString();
	}
	private static void calculator() {
		int a,b;
		int sum,difference,product,quotient;
		
		a = 6;
		b = 2;
		
		sum = a+b;
		difference = a-b;
		product = a*b;
		quotient = a/b;
		
		System.out.println("Sum is: " + sum);
		System.out.println("Difference is: " + difference);
		System.out.println("Product is: " + product);
		System.out.println("Quotient is: " + quotient);
	}

	private static void RectangularArea() {
		double Length, Width, Area;
		Length = 7.5;
		Width = 3.8;
		
		Area = Length*Width;
		
		System.out.println("Area is: " + Area);
		
	}
	
	private static void printString() {
		String name = "Automation Testing";
		System.out.println(name);
	}
}
