public class TestPC {
	public static void main(String[] args) {
		Hardware[] hardwares = new Hardware[2];
		hardwares[0] = new VideoCard();
		hardwares[1] = new NetCard();
		MainBoard mainBoard = new MainBoard(2, hardwares);
		mainBoard.run();
		mainBoard.stop();
		Hardware newHardware = new WifiCard();
		mainBoard.setNewHardwware(newHardware);
		mainBoard.run();
		mainBoard.stop();
	}
}
