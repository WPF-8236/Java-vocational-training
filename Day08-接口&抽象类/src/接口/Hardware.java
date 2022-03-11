package 接口;

public class Hardware implements Pci {
	protected String name = "硬件";

	@Override
	public void run() {
		System.out.println("硬件启动");
	}

	@Override
	public void stop() {
		System.out.println("硬件关闭");
	}
}
