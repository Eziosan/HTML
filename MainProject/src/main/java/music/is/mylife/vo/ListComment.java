package music.is.mylife.vo;



import lombok.Data;

@Data
public class ListComment {
	private int list_comment_id;
	private String user_id;
	private int playlist_id;
	private String user_comment;
	private int comment_like;
	private String comment_date;
	
}
