package javaPratice_OOP;

import org.openqa.selenium.WebDriver;

public class Topic_12_Java_Non_AccessModifier {
	public long shortTime = 15;
	protected long longTime = 30;
	private WebDriver driver;
	
	//Static
	static String kindofAnimal = "Cat";
	
	//Non-Static
	String topic = "Animals";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kindofAnimal);
		
		// If you want to call the non-static variable, you must be create a object.
		Topic_12_Java_Non_AccessModifier animal = new Topic_12_Java_Non_AccessModifier();
		System.out.println(animal.topic);
		
		animal.selectAnimal(kindofAnimal);
		choose_animal(kindofAnimal);
	}
	
	//Non-Static functions
	public void selectAnimal(String animal) {
		System.out.println(animal);
	}
	
	//Static functions
	public static void choose_animal(String animal) {
		System.out.println(animal);
	}
}
