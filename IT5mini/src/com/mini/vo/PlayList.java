package com.mini.vo;

//playlist테이블은 playlist_detail하고 조인할거라서 클래스를 하나만 만들었어요!!

public class PlayList {
	private int list_id;
	private String list_name;
	private String user_id;
	private String song_id;
	
	public PlayList() {}

	public PlayList(int list_id, String list_name, String user_id, String song_id) {
		super();
		this.list_id = list_id;
		this.list_name = list_name;
		this.user_id = user_id;
		this.song_id = song_id;
	}

	public int getList_id() {
		return list_id;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	public String getList_name() {
		return list_name;
	}

	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSong_id() {
		return song_id;
	}

	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}

	@Override
	public String toString() {
		return "PlayList [list_id=" + list_id + ", list_name=" + list_name + ", user_id=" + user_id + ", song_id="
				+ song_id + "]";
	}
	
	
	
	
}
