import java.io.IOException;

public class TestDateBase {
	public static void main(String[] args) {
		DateBase dateBase = new DateBase(); //初始化数据库
		Menu menu = new Menu(dateBase); //初始化菜单界面

	}

	public String input() {
		byte[] bytes = new byte[50];
		try {
			System.in.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bytes).trim();
	}
}
