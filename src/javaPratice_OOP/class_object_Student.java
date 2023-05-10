package javaPratice_OOP;

public class class_object_Student {
	private int student_id;
	private String student_name;
	private float point_Practice, point_Knowlegde;

	private int getStudent_id() {
		return student_id;
	}

	private void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	private String getStudent_name() {
		return student_name;
	}

	private void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	private float getPoint_Practice() {
		return point_Practice;
	}

	private void setPoint_Practice(float point_Practice) {
		this.point_Practice = point_Practice;
	}

	private float getPoint_Knowlegde() {
		return point_Knowlegde;
	}

	private void setPoint_Knowlegde(float point_Knowlegde) {
		this.point_Knowlegde = point_Knowlegde;
	}

	private Float getAdvenPoint() {
		return (this.point_Knowlegde + this.point_Practice * 2) / 3;
	}

	private void showStudentInfor() {
		System.out.println("*************************************");
		System.out.println("Student Id: " + getStudent_id());
		System.out.println("Student Name: " + getStudent_name());
		System.out.println("Student Knowlegde Point: " + getPoint_Knowlegde());
		System.out.println("Student Practice Point: " + getPoint_Practice());
		System.out.println("Student Adverage Point: " + getAdvenPoint());
		System.out.println("*************************************");
	}

	public static void main(String[] args) {
		class_object_Student first_Student = new class_object_Student();
		first_Student.setStudent_id(00233);
		first_Student.setStudent_name("Aladin");
		first_Student.setPoint_Practice(7.6f);
		first_Student.setPoint_Knowlegde(8.2f);
		first_Student.showStudentInfor();
		
		
		class_object_Student second_Student = new class_object_Student();
		second_Student.setStudent_id(00234);
		second_Student.setStudent_name("Muzan");
		second_Student.setPoint_Practice(5.6f);
		second_Student.setPoint_Knowlegde(2.2f);
		second_Student.showStudentInfor();
	}

}
