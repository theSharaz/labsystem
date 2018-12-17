package entity;

public class Application {

	private int appid, classno, stunum, availableid, state;
	private String week, day, start, finish, room;
	
	public Application() {
		super();
	}

	public Application(int appid, int classno, int stunum, String week, String day, String start, String finish,
			String room, int state, int availableid) {
		super();
		this.appid = appid;
		this.classno = classno;
		this.stunum = stunum;
		this.week = week;
		this.day = day;
		this.start = start;
		this.finish = finish;
		this.room = room;
		this.state = state;
		this.availableid = availableid;
	}

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
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

	public int getAvailableid() {
		return availableid;
	}

	public void setAvailableid(int availableid) {
		this.availableid = availableid;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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
