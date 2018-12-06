package entity;

public class ProfClass {
	private int id, classno, profnum;

	public ProfClass(int id, int classno, int profnum) {
		super();
		this.id = id;
		this.classno = classno;
		this.profnum = profnum;
	}

	public ProfClass() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public int getProfnum() {
		return profnum;
	}

	public void setProfnum(int profnum) {
		this.profnum = profnum;
	}
	
	

}
