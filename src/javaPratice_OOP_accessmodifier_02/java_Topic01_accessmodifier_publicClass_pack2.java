package javaPratice_OOP_accessmodifier_02;

import javaPratice_OOP_accessmodifier_01.java_Topic01_accessmodifier_publicClass_pack1;

public class java_Topic01_accessmodifier_publicClass_pack2 extends java_Topic01_accessmodifier_publicClass_pack1{
	
	public void showStudentName() {
		//Can not use private variable although extend the class
		//System.out.println(studentName);
	}

	
	public static void main(String[] args) {
		// Default variable can NOT be used if different package
//		java_Topic01_accessmodifier_publicClass_pack1 publicclass_pack1 = new java_Topic01_accessmodifier_publicClass_pack1();				
//		publicclass_pack1.setmemoryName("SamSung");
//		System.out.println(publicclass_pack1.memoryName);	
	}
}
