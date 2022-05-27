package com.WPF.domain;

import java.util.List;

public class ClassRoom {
	private int c_id;
	private String class_name;

	private List<Student> students;

	public ClassRoom() {
	}

	public ClassRoom(int c_id, String class_name) {
		this.c_id = c_id;
		this.class_name = class_name;
	}

	public ClassRoom(int c_id, String class_name, List<Student> students) {
		this.c_id = c_id;
		this.class_name = class_name;
		this.students = students;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "ClassRoom{" +
				"class_id='" + c_id + '\'' +
				", class_name='" + class_name + '\'' +
				", students=" + students +
				'}';
	}
}
