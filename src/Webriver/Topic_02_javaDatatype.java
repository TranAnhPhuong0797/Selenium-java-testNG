package Webriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic_02_javaDatatype {

	public static void main(String[] args) {
		
		//Number integer
			int stt = 110;
		
		//Number double/float
			double salary = 25.5d;
			
		//Logic: boolean
			boolean male = true;
			male = false;
			
		//Character: char
			char key = 'Z';
			
		//Reference
			//Class
				ChromeDriver chrome = new ChromeDriver();
				
			//String
				String familiesMember = "Father";
				
			//Interface
				WebElement email;
				
			//Object
				Object Student;
				
			//Array
				String [] fname = {"Father", "Mother", "Brother"}; 
				
			//Collection: List / Set / Queue
				List<WebElement> radioButton = chrome.findElements(By.cssSelector("")); 
					
			//Map
				Map<String, Integer> student = new HashMap<String, Integer>();
	}

}
