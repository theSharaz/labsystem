package entity;

public class AvailableTime {

	private int availableid, state;
	private String week, day, start, finish, room;
	
	public AvailableTime() {
		super();
	}

	public AvailableTime(int availableid, String week, String day, String start, String finish, String room, int state) {
		super();
		this.availableid = availableid;
		this.week = week;
		this.day = day;
		this.start = start;
		this.finish = finish;
		this.room = room;
		this.state = state;
	}

	public int getAvailableid() {
		return availableid;
	}

	public void setAvailableid(int availableid) {
		this.availableid = availableid;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
	
}
