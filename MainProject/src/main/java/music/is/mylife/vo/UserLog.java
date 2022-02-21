package music.is.mylife.vo;



import lombok.Data;

@Data
public class UserLog {
	private String user_id;
	private int song_id;
	private double star;
	private String star_date;
	private double all_star;
	
	private int singer_id;
	private String genre;
	private String country;
	
	private int grade_count;
	
	private int tag_id;
	
	
	
}
