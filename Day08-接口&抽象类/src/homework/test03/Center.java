package homework.test03;

public class Center implements Introduce {
	private String name = "教学大楼";

	private Printer[] printers = new Printer[]{new BaWPrinter(), new ColorPrinter()};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Printer[] getPrinters() {
		return printers;
	}

	public void setPrinters(Printer[] printers) {
		this.printers = printers;
	}

	public void print(Introduce introduce, Printer printer) {
		if (printer instanceof BaWPrinter)
			printers[0].print(introduce);
		else
			printers[1].print(introduce);
	}

	@Override
	public String detail() {
		return "我是教学大楼";
	}
}
