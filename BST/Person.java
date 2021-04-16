
public class Person {
	private String firstName;
	private String familyName;
	private int age;

	public Person(String firstName, String familyName, int age) {
		this.firstName = firstName;
		this.familyName = familyName;
		this.age = age;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public int getAge() {
		return this.age;
	}

	public String toString() {
		return firstName + " " + familyName + ": " + age;
	}
}