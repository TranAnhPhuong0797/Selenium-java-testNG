package java_OOP_Overriding;

public class Employee extends Person implements iLearn{
	//Child Class can override the function of parent class
	public void drink() {
		System.out.println("Can drink beer");
	}
	
	@Override
	public void sleep() {
		System.out.println("Sleeping 7/day");
	}
	
	@Override
	public void learningTime() {
		System.out.println("Learning 5h/day");
	}
}
