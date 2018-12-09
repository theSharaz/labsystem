package entity;

public class StuClass {
	private int id, classno, stunum;

	
	public StuClass() {
		super();
	}

	public StuClass(int id, int classno, int stunum) {
		super();
		this.id = id;
		this.classno = classno;
		this.stunum = stunum;
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
	
	

}
