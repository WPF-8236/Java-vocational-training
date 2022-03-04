/**
 * @author 王潘锋201805020527 jiou_
 * @create 22/3/2 09:11
 * @filepath Enterprise.java
 * @desc
 **/
public class Enterprise {
	private String e_id;        //公司编号
	private String e_name;      //公司名称
	private String e_phone;     //公司电话
	private String e_email;     //公司邮箱
	private String e_address;   //公司地址

	/**
	 * 空参构造方法
	 */
	public Enterprise() {
		System.out.println("空参构造");
	}

	/**
	 * 有参构造方法
	 *
	 * @param e_id      公司编号
	 * @param e_name    公司名称
	 * @param e_phone   公司电话
	 * @param e_email   公司邮箱
	 * @param e_address 公司地址
	 */
	public Enterprise(String e_id, String e_name, String e_phone, String e_email, String e_address) {
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_phone = e_phone;
		this.e_email = e_email;
		this.e_address = e_address;
		System.out.println("有参构造");
	}

	/**
	 * 公司发放工作方法
	 */
	public void setJob() {
		System.out.println("--发放工作--");
	}

	/**
	 * 公司招募员工方法
	 */
	public void getEmployee() {
		System.out.println("--招收员工--");
	}

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_phone() {
		return e_phone;
	}

	public void setE_phone(String e_phone) {
		this.e_phone = e_phone;
	}

	public String getE_email() {
		return e_email;
	}

	public void setE_email(String e_email) {
		this.e_email = e_email;
	}

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
	}

}