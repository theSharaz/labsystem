package entity;

public class ExpState {
	
	private int id, classno, stunum, state;

	public ExpState() {
		super();
	}

	public ExpState(int id, int classno, int stunum, int state) {
		super();
		this.id = id;
		this.classno = classno;
		this.stunum = stunum;
		this.state = state;
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

	public int getStunum() {
		return stunum;
	}

	public void setStunum(int stunum) {
		this.stunum = stunum;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	
}
