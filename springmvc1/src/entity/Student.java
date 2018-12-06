package entity;

public class Student {
	
	private int stunum, classno;
	private String name, password, newpassword, address, email, phone;
	
	public Student() {
		super();

	}

	public Student(int stunum, String name, String password, int classno, String address, String email, String phone) {
		super();
		this.stunum = stunum;
		this.name = name;
		this.password = password;
		this.classno = classno;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public Student(int id, int stunum, String name, String password, int classno, String address, String email, String phone,String newpassword) {
		super();
		this.stunum = stunum;
		this.name = name;
		this.password = password;
		this.classno = classno;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.newpassword = newpassword;
	}
	
	public Student(int stunum, String password) {
		super();
		this.stunum = stunum;
		this.password = password;
	}
	

	public int getStuNum() {
		return stunum;
	}

	public void setStuNum(int stunum) {
		this.stunum = stunum;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int deptno) {
		this.classno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}	
}
