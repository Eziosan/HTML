package com.mini.vo;

public class Song {
	private int song_id;
	private String song_name;
	//나중에 변경
	private int main_sid;
	private String sub_sid;
	private String release_date;
	private String writer;
	private String composer;
	private int counting_star;
	private int star_counter;
	private String lyrics;
	private int hits;
	
	//singer_name 변수 추가(12/30)
	private String singer_name;
	
	public Song() {}

	
	public Song(String song_name, int main_sid, String release_date, String writer,
			String composer, String lyrics) {
		super();
		this.song_name = song_name;
		this.main_sid = main_sid;
		this.release_date = release_date;
		this.writer = writer;
		this.composer = composer;
		this.lyrics = lyrics;
	}

	public int getSong_id() {
		return song_id;
	}

	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public int getMain_sid() {
		return main_sid;
	}

	public void setMain_sid(int main_sid) {
		this.main_sid = main_sid;
	}

	public String getSub_sid() {
		return sub_sid;
	}

	public void setSub_sid(String sub_sid) {
		this.sub_sid = sub_sid;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getCounting_star() {
		return counting_star;
	}

	public void setCounting_star(int counting_star) {
		this.counting_star = counting_star;
	}

	public int getStar_counter() {
		return star_counter;
	}

	public void setStar_counter(int star_counter) {
		this.star_counter = star_counter;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getSinger_name() {
		return singer_name;
	}

	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}


	@Override
	public String toString() {
		return "노래 : " + song_name + "\n가수 : " + singer_name;
	}
	
	
	
	
}
