package com.WPF.domain;

public class Post {
	private String p_id;
	private String p_title;
	private String p_content;
	private int p_comment_count;
	private int p_status;
	private String p_time;
	private String p_u_id;
	private String p_p_id;
	private int p_tag;
	private int p_nice;
	private int p_browse_count;
	private int p_thumbs_count;

	public Post() {
	}

	public Post(String p_id, String p_title, String p_content, int p_comment_count, int p_status, String p_time, String p_u_id, String p_p_id, int p_tag, int p_nice, int p_browse_count, int p_thumbs_count) {
		this.p_id = p_id;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_comment_count = p_comment_count;
		this.p_status = p_status;
		this.p_time = p_time;
		this.p_u_id = p_u_id;
		this.p_p_id = p_p_id;
		this.p_tag = p_tag;
		this.p_nice = p_nice;
		this.p_browse_count = p_browse_count;
		this.p_thumbs_count = p_thumbs_count;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public int getP_comment_count() {
		return p_comment_count;
	}

	public void setP_comment_count(int p_comment_count) {
		this.p_comment_count = p_comment_count;
	}

	public int getP_status() {
		return p_status;
	}

	public void setP_status(int p_status) {
		this.p_status = p_status;
	}

	public String getP_time() {
		return p_time;
	}

	public void setP_time(String p_time) {
		this.p_time = p_time;
	}

	public String getP_u_id() {
		return p_u_id;
	}

	public void setP_u_id(String p_u_id) {
		this.p_u_id = p_u_id;
	}

	public String getP_p_id() {
		return p_p_id;
	}

	public void setP_p_id(String p_p_id) {
		this.p_p_id = p_p_id;
	}

	public int getP_tag() {
		return p_tag;
	}

	public void setP_tag(int p_tag) {
		this.p_tag = p_tag;
	}

	public int getP_nice() {
		return p_nice;
	}

	public void setP_nice(int p_nice) {
		this.p_nice = p_nice;
	}

	public int getP_browse_count() {
		return p_browse_count;
	}

	public void setP_browse_count(int p_browse_count) {
		this.p_browse_count = p_browse_count;
	}

	public int getP_thumbs_count() {
		return p_thumbs_count;
	}

	public void setP_thumbs_count(int p_thumbs_count) {
		this.p_thumbs_count = p_thumbs_count;
	}

	@Override
	public String toString() {
		return "Post{" +
				"p_id='" + p_id + '\'' +
				", p_title='" + p_title + '\'' +
				", p_content='" + p_content + '\'' +
				", p_comment_count=" + p_comment_count +
				", p_status=" + p_status +
				", p_time='" + p_time + '\'' +
				", p_u_id='" + p_u_id + '\'' +
				", p_p_id='" + p_p_id + '\'' +
				", p_tag=" + p_tag +
				", p_nice=" + p_nice +
				", p_browse_count=" + p_browse_count +
				", p_thumbs_count=" + p_thumbs_count +
				'}';
	}
}
