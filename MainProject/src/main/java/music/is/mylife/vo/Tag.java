package music.is.mylife.vo;

import lombok.Data;

@Data
public class Tag {
	private int tag_id;
	private String tag_name;
	private int song_id;
	private int singer_id;
	private int album_id;
	private int recommend;

}
