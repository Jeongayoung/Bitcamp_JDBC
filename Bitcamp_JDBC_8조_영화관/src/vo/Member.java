package vo;

public class Member {

	private String id;
	private String pw;
	private String name;
	private String sex;
	private int age;
	private String phone;
	private String addr;
	private String mgcode;

	public Member() {

	}

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public Member(String logid) {
		this.id = logid;

	}

	public Member(String id, String pw, String name, String sex, int age, String phone, String addr) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
	}

	public Member(String id, String pw, String name, String sex, int age, String phone, String addr, String mgcode) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
		this.mgcode = mgcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMgcode() {
		return mgcode;
	}

	public void setMgcode(String mgcode) {
		this.mgcode = mgcode;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone="
				+ phone + ", addr=" + addr + ", mgcode=" + mgcode + "]";
	}

}