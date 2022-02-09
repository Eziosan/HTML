package music.is.mylife.vo;

import lombok.Data;

@Data
public class AlbumComment {
	private int comment_id;
	private int album_id;
	private int user_id;
	private String user_comment;
	private String comment_date;
	private int comment_like;

}
