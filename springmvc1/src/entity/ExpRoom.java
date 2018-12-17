package entity;

public class ExpRoom {
	private int id, state;
	private String room;
	
	public ExpRoom() {
		super();
	}

	public ExpRoom(int id, String room, int state) {
		super();
		this.id = id;
		this.room = room;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	
	
}
