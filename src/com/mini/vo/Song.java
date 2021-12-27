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
	
	public Song() {}
	
	public Song(String song_name, String release_date, String writer, String composer, String lyrics) {
		this.song_name = song_name;
		this.release_date = release_date;
		this.writer = writer;
		this.composer = composer;
		this.lyrics = lyrics;
	}
	

	public Song(int song_id, String song_name, int main_sid, String sub_sid, String release_date, String writer,
			String composer, int counting_star, int star_counter, String lyrics, int hits) {
		super();
		this.song_id = song_id;
		this.song_name = song_name;
		this.main_sid = main_sid;
		this.sub_sid = sub_sid;
		this.release_date = release_date;
		this.writer = writer;
		this.composer = composer;
		this.counting_star = counting_star;
		this.star_counter = star_counter;
		this.lyrics = lyrics;
		this.hits = hits;
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

	@Override
	public String toString() {
		return "제목 : " + song_name + "\t" + "조회수 : " + hits + "\n" + "발매일 : " + release_date + "\n" + "작사 : " + writer + "\n" +"작곡 : " + composer
				+ "\n" +"별점 : " + counting_star + "\n" +"별점 (?) : " + star_counter + "\n\n" +
				
				"=======================================================" + "\n\n"+
				"가사 " +"\n\n"  + 
				lyrics + "\n" +
				"======================================================="
				;
	}
	
	
	
}
