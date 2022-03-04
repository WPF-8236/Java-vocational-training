public class ClassRoom {
	private String c_name;  //教室名字
	private int c_num;      //教室容纳数量
	private Student[] students; //学生列表

	public ClassRoom() {
	}

	public ClassRoom(String c_name, int c_num) {
		this.c_name = c_name;
		this.c_num = c_num;
		students = new Student[c_num];
	}

	public void getIn(Student student) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				break;
			}
		}
	}

	/**
	 *
	 * @param studentList
	 */
	public void getInMore(Student... studentList) {
		int flag = 0;
		for (Student student : studentList) {
			for (int i = 0; i < students.length; i++) {
				if (students[i] == null) {
					students[i] = student;
					break;
				}
			}
			flag++;
			if (flag > students.length)
				System.out.println(student);
		}
	}


	public void showInfo() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}
}
