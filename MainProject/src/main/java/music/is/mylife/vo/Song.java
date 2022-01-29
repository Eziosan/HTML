package music.is.mylife.vo;

import lombok.Data;

@Data
public class Song {
	private int song_id;
	private String song_name;
	private int album_id;
	private String genre;
	private int song_like;
	private int hit;
	private String lyrics;
	
	private int singer_id;
	private String pic;
	private String video;

}
