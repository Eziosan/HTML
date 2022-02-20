package music.is.mylife.dao;

import java.util.ArrayList;

import music.is.mylife.vo.Tag;
import music.is.mylife.vo.UserLog;

public interface UserLogMapper {
	//한 유저가 지금까지 별점을 매긴 곡 수
	public double selectAllStarCountByUser(String user_id);
	//한 유저가 지금까지 매긴 별점의 총합
	public double selectAllStarSumByUser(String user_id);
	//한 유저가 가장 많이 준 별점
	public double selectTopStarByUser(String user_id);
	
	//특정 유저의 Top10 태그를 불러옴
	public ArrayList<Tag> selectTop10TagByUser(String user_id);
	
	//특정 유저의 Top3 가수를 불러옴
	public ArrayList<UserLog> selectTop3SingerByUser(String user_id);
	//특정 유저의 Top3 장르를 불러옴
	public ArrayList<UserLog> selectTop3GenreByUser(String user_id);
	//특정 유저의 Top3 국가를 불러옴
	public ArrayList<UserLog> selectTop3CountryByUser(String user_id);
	
	
	
	
}
