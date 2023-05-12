package javaPratice_OOP_accessmodifier_02;

import javaPratice_OOP_accessmodifier_01.java_Topic01_accessmodifier_abstractClass_pack1;
import javaPratice_OOP_accessmodifier_01.java_Topic01_accessmodifier_finalClass_pack1;
import javaPratice_OOP_accessmodifier_01.java_Topic01_accessmodifier_publicClass_pack1;

public class java_Topic01_accessmodifier_defaultClass_pack2 extends java_Topic01_accessmodifier_abstractClass_pack1{
	// Can not call default class to another package
	//java_Topic01_accessmodifier_defaultClass_pack1 defaultpack01 = new java_Topic01_accessmodifier_defaultClass_pack1();
	
	// Can call public class to another package
	java_Topic01_accessmodifier_publicClass_pack1 publicpack1 = new java_Topic01_accessmodifier_publicClass_pack1();
	
	// Can not extend final class
	// But can call the final class to another package
	java_Topic01_accessmodifier_finalClass_pack1 finalpack1 = new java_Topic01_accessmodifier_finalClass_pack1();
	
	// Can not call abstract class to another package
	// But can extends abstract class to another package
	//java_Topic01_accessmodifier_abstractClass_pack1 abstractpack1 = new java_Topic01_accessmodifier_abstractClass_pack1();

	public static void main(String[] args) {
		//Can not use Protected variable if not extend the class
//		java_Topic01_accessmodifier_publicClass_pack1 publicClass = new java_Topic01_accessmodifier_publicClass_pack1();
//		publicClass.setcarName("Honda");
//		System.out.println(publicClass.carName);
	}
}
