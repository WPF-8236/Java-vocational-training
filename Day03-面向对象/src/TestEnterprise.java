public class TestEnterprise {
	public static void main(String[] args) {
		Enterprise enterprise = new Enterprise();
		ClassRoom classRoom = new ClassRoom("Java", 3);
		Student s1 = new Student("1", "1", "1", "1");
		Student s2 = new Student("2", "2", "2", "2");
		Student s3 = new Student("3", "3", "3", "3");
		Student s4 = new Student("4", "4", "4", "4");
		Student s5 = new Student("5", "5", "5", "5");
		Student[] students = {s1, s2, s3, s4, s5};

		classRoom.getInMore(students);

	}
}
