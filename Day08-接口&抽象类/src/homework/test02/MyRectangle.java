package homework.test02;

public class MyRectangle implements Area {
	private double height;
	private double width;

	public MyRectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double calculateArea() {
		return width * height;
	}
}
