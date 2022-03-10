public class VideoCard extends Hardware {
	public static final String NAME = "VideoCard";

	@Override
	public void run() {
		System.out.println(NAME + "启动");
	}

	@Override
	public void stop() {
		System.out.println(NAME + "关闭");
	}
}
