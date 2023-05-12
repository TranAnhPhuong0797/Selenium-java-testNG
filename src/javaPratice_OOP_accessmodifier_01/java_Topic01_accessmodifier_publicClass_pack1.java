package javaPratice_OOP_accessmodifier_01;

public class java_Topic01_accessmodifier_publicClass_pack1 {
	// Can call default class in the same package
	java_Topic01_accessmodifier_defaultClass_pack1 defaultpack01 = new java_Topic01_accessmodifier_defaultClass_pack1();
	
	//Property
	private String studentName;
	String memoryName;
	protected String carName;
	
	//Method
	private String setStudentName(String studentName) {
        return this.studentName = studentName;
    }
	
	void setmemoryName(String memoryName) {
		this.memoryName = memoryName;
	}
	
	protected String setcarName(String carName) {
		return this.carName = carName;
	}
	
	public static void main(String[] args) {
		java_Topic01_accessmodifier_publicClass_pack1 publicClass = new java_Topic01_accessmodifier_publicClass_pack1();
		publicClass.studentName = "Le Van Thanh";
		System.out.println(publicClass.studentName);
		
		publicClass.setmemoryName("KingStone");
		System.out.println(publicClass.memoryName);
		
		publicClass.setcarName("Honda");
		System.out.println(publicClass.carName);
	}
}
