package music.is.mylife.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLogDAO {
	
	@Autowired
	private SqlSession session;
	
	//한 유저가 지금까지 별점을 매긴 곡 수
	public int selectAllStarCountByUser(String user_id) {
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return 0;
	}
	//한 유저가 지금까지 매긴 별점의 총합
	public double selectAllStarSumByUser(String user_id) {
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return 0;
	}
	//한 유저가 가장 많이 준 별점
	public int selectTopStarByUser(String user_id) {
		UserLogMapper mapper = session.getMapper(UserLogMapper.class);
		
		return 0;
	}
}
