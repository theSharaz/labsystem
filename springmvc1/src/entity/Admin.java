package entity;

public class Admin {
	private String name, password, newpassword;
	int id;

	public Admin() {

	}
	public Admin(String name, String password) {
		super();
		this.id = 0;
		this.name = name;
		this.password = password;
	}
	
	
	
	public Admin(int id, String name, String password, String newpassword) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.newpassword = newpassword;
	}
	
	
	
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	

}
