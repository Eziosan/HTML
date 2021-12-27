package com.mini.vo;

public class SongComment {
	private int comment_id;
	private int song_id;
	private String user_id;
	private String user_comment;
	private String comment_date;
	
	public SongComment() {}

	public SongComment(int comment_id, int song_id, String user_id, String user_comment, String comment_date) {
		super();
		this.comment_id = comment_id;
		this.song_id = song_id;
		this.user_id = user_id;
		this.user_comment = user_comment;
		this.comment_date = comment_date;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getSong_id() {
		return song_id;
	}

	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}

	public String getComment_date() {
		return comment_date;
	}

	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}

	@Override
	public String toString() {
		return "SongComment [comment_id=" + comment_id + ", song_id=" + song_id + ", user_id=" + user_id
				+ ", user_comment=" + user_comment + ", comment_date=" + comment_date + "]";
	}

	
	
}
