package music.is.mylife.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import music.is.mylife.vo.Tag;
import music.is.mylife.vo.UserLog;

@Repository
public class UserLogDAO {
	
	@Autowired
	private SqlSession session;
	
	//한 유저가 지금까지 별점을 매긴 곡 수
	public double selectAllStarCountByUser(String user_id) {
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return mapper.selectAllStarCountByUser(user_id);
		
	}
	//한 유저가 지금까지 매긴 별점의 총합
	public double selectAllStarSumByUser(String user_id) {
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return mapper.selectAllStarSumByUser(user_id);
	}
	//한 유저가 가장 많이 준 별점
	public double selectTopStarByUser(String user_id) {
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return mapper.selectTopStarByUser(user_id);
	}
	
	//특정 유저의 Top3 태그 3개를 불러옴
	public ArrayList<Tag> selectTop10TagByUser(String user_id){
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return mapper.selectTop10TagByUser(user_id);
	}
	//특정 유저의 Top3 가수를 불러옴
	public ArrayList<UserLog> selectTop3SingerByUser(String user_id){
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return mapper.selectTop3SingerByUser(user_id);
	}
	//특정 유저의 Top3 장르를 불러옴
	public ArrayList<UserLog> selectTop3GenreByUser(String user_id){
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return mapper.selectTop3GenreByUser(user_id);
	}
	//특정 유저의 Top3 국가를 불러옴
	public ArrayList<UserLog> selectTop3CountryByUser(String user_id){
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return mapper.selectTop3CountryByUser(user_id);
	}
	
}
