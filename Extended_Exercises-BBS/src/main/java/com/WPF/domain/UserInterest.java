package com.WPF.domain;

public class UserInterest {
	private String u_id;
	private String u_interest_id;
	private String u_interest;
	private int u_interest_dislike;

	public UserInterest() {
	}

	public UserInterest(String u_id, String u_interest_id, String u_interest, int u_interest_dislike) {
		this.u_id = u_id;
		this.u_interest_id = u_interest_id;
		this.u_interest = u_interest;
		this.u_interest_dislike = u_interest_dislike;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_interest_id() {
		return u_interest_id;
	}

	public void setU_interest_id(String u_interest_id) {
		this.u_interest_id = u_interest_id;
	}

	public String getU_interest() {
		return u_interest;
	}

	public void setU_interest(String u_interest) {
		this.u_interest = u_interest;
	}

	public int getU_interest_dislike() {
		return u_interest_dislike;
	}

	public void setU_interest_dislike(int u_interest_dislike) {
		this.u_interest_dislike = u_interest_dislike;
	}

	@Override
	public String toString() {
		return "UserInterest{" +
				"u_id='" + u_id + '\'' +
				", u_interest_id='" + u_interest_id + '\'' +
				", u_interest='" + u_interest + '\'' +
				", u_interest_dislike=" + u_interest_dislike +
				'}';
	}
}
