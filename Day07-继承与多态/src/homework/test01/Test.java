package homework.test01;

public class Test {
	public static void main(String[] args) {
		Television television = new Television("电视");
		Cellphone cellphone = new Cellphone("电话");

		television.discharge();
		television.putOnAMovie();

		cellphone.call();
		cellphone.discharge();
		cellphone.play();
	}
}
