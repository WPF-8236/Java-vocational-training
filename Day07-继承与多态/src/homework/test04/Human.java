package homework.test04;

public class Human {
	protected String name;
	protected String gender;
	protected Integer age;

	public Human() {
	}

	public Human(String name, String gender, Integer age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human{" +
				"name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				'}';
	}
}
