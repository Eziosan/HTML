package music.is.mylife.vo;

import lombok.Data;

@Data
public class Singer {
	private int singer_id;
	private String singer_name;
	private String country;
	private int singer_like;
	
	private String singer_img;
	private String video;
	private int recommend;

}
