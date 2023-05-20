package javaPratice_OOP;

public class Topic_14_Java_getter_setter {
	private String personName;
	private int personAge;
	private int personPhone;
	private int personBankAccount;
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		if (personName != null || personName.isEmpty() || personName.isBlank()) {
			throw new IllegalArgumentException("personName cannot be null");
			
		}else {
			this.personName = personName;
		}
	}
	
	
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		if (personAge >= 15 || personAge <= 150) {
			this.personAge = personAge;
		}else {
			throw new IllegalArgumentException("personAge intput invalid");
		}
	}
	
	
	public int getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("personPhone must start with: 09 - 03 - 012 - 016 - 018 - 019");
		}else if (personPhone > 11 || personPhone < 10) {
			throw new IllegalArgumentException("personPhone must be from 10-11 number");
		}else {
			this.personPhone = personPhone;
		}		
	}
	
	
	public int getPersonBankAccount() {
		return personBankAccount;
	}
	public void setPersonBankAccount(int personBankAccount) {
		
		this.personBankAccount = personBankAccount;
	}


}
