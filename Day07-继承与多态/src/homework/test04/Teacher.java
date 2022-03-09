package homework.test04;

public class Teacher extends Human {
	private String posts;

	public Teacher() {
	}

	public Teacher(String name, String gender, Integer age, String posts) {
		super(name, gender, age);
		this.posts = posts;
	}

	public String getPosts() {
		return posts;
	}

	public void setPosts(String posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"posts='" + posts + '\'' +
				"} " + super.toString();
	}
}
