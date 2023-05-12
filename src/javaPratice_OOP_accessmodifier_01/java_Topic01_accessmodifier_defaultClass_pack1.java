package javaPratice_OOP_accessmodifier_01;

class java_Topic01_accessmodifier_defaultClass_pack1 extends java_Topic01_accessmodifier_publicClass_pack1{
	
	public void showCarName() {
		setcarName("BWM");
		System.out.println(carName);
	}
	
	public static void main(String[] args) {
		java_Topic01_accessmodifier_publicClass_pack1 publicclass_pack1 = new java_Topic01_accessmodifier_publicClass_pack1();
		
		// Default variable can use in same package
		publicclass_pack1.setmemoryName("SamSung");
		System.out.println(publicclass_pack1.memoryName);	
		
		
	}	
}
