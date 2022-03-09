package homework.test05;

public class DataBase {
	public static final int MAX_NUM = 101;  //数据库最大数量
	private static User[] users;            //数据库用户
	private static Animal[] animals;        //数据库动物
	private int userNum;                    //数据库用户数量
	private int animalNum;                  //数据库动物数量

	/**
	 * 空参构造,初始化数据库
	 */
	public DataBase() {
		userNum = 5;
		animalNum = 5;
		initializeData();
	}

	/**
	 * 初始化数据库,代码填充数据
	 */
	private void initializeData() {
		users = new User[MAX_NUM];
		users[0] = new User("admin", "admin", "admin", 0, "admin", 0.0);
		users[1] = new DiamondMember("1", "1", "1", 10, "男", 125.8);
		users[2] = new GoldMember("2", "2", "2", 20, "男", 1120.0);
		users[3] = new SilverMember("3", "3", "3", 30, "女", 10.0);
		users[4] = new OrdinaryMember("4", "4", "4", 40, "女", 0.0);
		users[5] = new OrdinaryMember("5", "5", "5", 50, "男", 1000.0);
		animals = new Animal[MAX_NUM];
		animals[0] = new Animal();
		animals[1] = new Cat("笑话", 10, "红色", "公", 1500.0);
		animals[2] = new Dog("露露", 10, "黄色", "母", 1500.0);
		animals[3] = new Hamster("信息", 10, "蓝色", "公", 1500.0);
		animals[4] = new Cat("阿达", 10, "绿色", "母", 1500.0);
		animals[5] = new Dog("规定", 10, "彩色", "公", 15000.0);
	}

	//=========== set And get ==============
	public static User[] getUsers() {
		return users;
	}

	public static void setUsers(User[] users) {
		DataBase.users = users;
	}

	public static Animal[] getAnimals() {
		return animals;
	}

	public static void setAnimals(Animal[] animals) {
		DataBase.animals = animals;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getAnimalNum() {
		return animalNum;
	}

	public void setAnimalNum(int animalNum) {
		this.animalNum = animalNum;
	}
}
