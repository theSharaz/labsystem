package entity;

public class Professor {
	
	private int profnum;
	private String name, password, newpassword, address, email, phone;
	
	public Professor() {
		super();

	}
	
	public Professor(int profnum, String name, String password, String address, String email, String phone) {
		super();
		this.profnum = profnum;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public Professor(int profnum, String password) {
		super();
		this.profnum = profnum;
		this.password = password;
	}

	public Professor(int profnum, String name, String password, String address, String email,
			String phone, String newpassword) {
		super();
		this.profnum = profnum;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.newpassword = newpassword;
	}

	public int getProfnum() {
		return profnum;
	}

	public void setProfnum(int profnum) {
		this.profnum = profnum;
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
