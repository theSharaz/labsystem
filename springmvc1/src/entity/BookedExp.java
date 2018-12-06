package entity;

public class BookedExp {
	
	private int id, classno;
	private String week,day,start,finish,room;
	
	
	
	public BookedExp() {
		super();
	}



	public BookedExp(int id, int classno, String week, String day, String start, String finish, String room) {
		super();
		this.id = id;
		this.classno = classno;
		this.week = week;
		this.day = day;
		this.start = start;
		this.finish = finish;
		this.room = room;
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



	public String getWeek() {
		return week;
	}



	public void setWeek(String week) {
		this.week = week;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getStart() {
		return start;
	}



	public void setStart(String start) {
		this.start = start;
	}



	public String getFinish() {
		return finish;
	}



	public void setFinish(String finish) {
		this.finish = finish;
	}



	public String getRoom() {
		return room;
	}



	public void setRoom(String room) {
		this.room = room;
	}
	
	
	
	

}
