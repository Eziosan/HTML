package music.is.mylife.vo;

import lombok.Data;

@Data
public class Song {
	private int song_id;
	private int singer_id;
	private String song_name;
	private String genre;
	private int song_like;
	private int hit;
	private String lyrics;
	private String song_banner;
	private String album_name;
	private String album_img;
	private String album_date;
	private String writer;
	private String composer;
	
	private String country;
	private String singer_name;
	
	
}
