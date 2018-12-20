package entity;

public class Feedback {
	private int feedbackno;
	private String comment, fdtime;
	
	public Feedback() {
		super();
	}

	public Feedback(int feedbackno, String comment, String fdtime) {
		super();
		this.feedbackno = feedbackno;
		this.comment = comment;
		this.fdtime = fdtime;
	}

	public int getFeedbackno() {
		return feedbackno;
	}

	public void setFeedbackno(int feedbackno) {
		this.feedbackno = feedbackno;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFdtime() {
		return fdtime;
	}

	public void setFdtime(String fdtime) {
		this.fdtime = fdtime;
	}
	
	

}
