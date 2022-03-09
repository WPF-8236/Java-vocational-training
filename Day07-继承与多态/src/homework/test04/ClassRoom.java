package homework.test04;

import java.util.Arrays;

public class ClassRoom {
	private String name;
	private Student[] students;
	private Teacher teacher;

	public ClassRoom() {

	}

	public ClassRoom(String name, Student[] students, Teacher teacher) {
		this.name = name;
		this.students = students;
		this.teacher = teacher;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "ClassRoom{" +
				"name='" + name + '\'' +
				", students=" + Arrays.toString(students) +
				", teacher=" + teacher +
				'}';
	}
}
