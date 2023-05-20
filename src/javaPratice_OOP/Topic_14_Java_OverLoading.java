package javaPratice_OOP;

public class Topic_14_Java_OverLoading {
	
	// 1 function can set same name but different parameters
	// 1 constructor can set same name but different parameters
	
	// Overloading only use in the scope (In class)
	private int first_Number;
	private int second_Number;
	
	public void sumNumber() {
		System.out.println(first_Number + second_Number);
	}
	
	public void sumNumber(int number) {
		System.out.println(number + (number * 100)/10);
	}
	
	public void sumNumber(int first_Number, int second_Number) {
		System.out.println(first_Number + second_Number);
	}
	
	public void sumNumber(float first_Number, float second_Number) {
		System.out.println(first_Number + second_Number);
	}
	
	public void sumNumber(int first_Number, float second_Number) {
		System.out.println(first_Number + second_Number);
	}
	
	public static void main(String[] args) {
		Topic_14_Java_OverLoading overLoading = new Topic_14_Java_OverLoading();
		overLoading.sumNumber(5);
	}
}
