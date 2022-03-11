package homework.test03;

public class Teacher implements Introduce {
	private String name;

	public Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String detail() {
		return "我是" + name + "老师";
	}
}
