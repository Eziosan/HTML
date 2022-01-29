package music.is.mylife.vo;

import lombok.Data;

@Data
public class Album {
	private int album_id;
	private String album_name;
	private String type;
	private String album_date;
	private int album_star;
	private int album_person;
	private int singer_id;
	private String pic;


}
