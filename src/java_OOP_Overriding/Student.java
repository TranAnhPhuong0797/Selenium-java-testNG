package java_OOP_Overriding;

public class Student extends Person implements iLearn{
	//Child Class can override the function of parent class
	public void drink() {
		System.out.println("Can NOT drink beer");
	}
	
	@Override
	public void sleep() {
		System.out.println("Sleeping 8h/day");
	}
	
	@Override
	public void learningTime() {
		System.out.println("Learning 10h/day");
	}
}
