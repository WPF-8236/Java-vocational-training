package com.WPF.domain;

public class Student {
	private int student_id;
	private int class_id;
	private String student_name;
	private ClassRoom classRoom;

	public Student() {
	}

	public Student(int student_id, int class_id, String student_name) {
		this.student_id = student_id;
		this.class_id = class_id;
		this.student_name = student_name;
	}

	public Student(int student_id, int class_id, String student_name, ClassRoom classRoom) {
		this.student_id = student_id;
		this.class_id = class_id;
		this.student_name = student_name;
		this.classRoom = classRoom;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return "Student{" +
				"student_id=" + student_id +
				", class_id=" + class_id +
				", student_name='" + student_name + '\'' +
				", classRoom=" + classRoom +
				'}';
	}
}
