public class Human {
	public String id;
	protected String name;
	Integer age;
	private String gender;

	public Human() {
	}

	public Human(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Human(String id, String name, Integer age, String gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	public void sleep() {
		System.out.println("睡觉");
	}


	public void eating() {
		System.out.println("吃饭");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Human{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Human) {
			Human human = (Human) obj;
			if (this.name.equals(human.name) && this.age == human.age)
				return true;
		}
		return false;
	}
}
