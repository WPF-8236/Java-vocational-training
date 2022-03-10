/*
	接口的使用：一个类去实现一个接口必须实现这个接口的所有抽象方法
 */
public class MainBoard implements Pci {
	public static final String NAME = "主板";
	public static final Integer PCINUM = 10;
	private Hardware[] hardwares = new Hardware[PCINUM];
	private Integer hardwareNum;

	public MainBoard() {
	}

	/**
	 * 初始化主板
	 *
	 * @param hardwareNum 主板上的硬件个数
	 * @param hardwares   主板上的硬件数组
	 */
	public MainBoard(Integer hardwareNum, Hardware[] hardwares) {
		this.hardwareNum = hardwareNum;
		for (int i = 0; i < hardwareNum; i++) {
			this.hardwares[i] = hardwares[i];
		}
	}

	//============ set and get ===========
	public Hardware[] getHardwares() {
		return hardwares;
	}

	public void setHardwares(Hardware[] hardwares) {
		this.hardwares = hardwares;
	}

	public Integer getHardwareNum() {
		return hardwareNum;
	}

	public void setHardwareNum(Integer hardwareNum) {
		this.hardwareNum = hardwareNum;
	}
	//================================================

	/**
	 * 添加新硬件
	 *
	 * @param hardwware 硬件
	 */
	public void setNewHardwware(Hardware hardwware) {
		hardwares[hardwareNum] = hardwware;
		hardwareNum++;
	}


	@Override
	public void run() {
		System.out.println("---- 主板启动 ----");
		for (Hardware hardware : hardwares) {
			if (hardware != null)
				hardware.run();
		}
	}

	@Override
	public void stop() {
		System.out.println("---- 主板关闭 ----");
		for (Hardware hardware : hardwares) {
			if (hardware != null)
				hardware.stop();
		}
	}
}
