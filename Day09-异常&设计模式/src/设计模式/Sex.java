package 设计模式;

//枚举是抽象类
public enum Sex {
	//属性默认是公共的静态的本类的对象的常量
	MALE("男"), FEMALE("女");
	//枚举类的构造方法默认是私有的
	Sex() {
	}

	private String value;

	Sex(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

//	@Override
//	public String toString() {
//		return "Sex{" +
//				"value='" + value +
//				"} ";
//	}
}
