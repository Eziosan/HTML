package music.is.mylife.dao;

import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SongDAO {
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	SqlSession sqlSession;
	
	// 가장 추천수가 높은 배너를 가져오는 메소드
	public String selectBanner(int song_id){
		SongMapper mapper = sqlSession.getMapper(SongMapper.class);
		
		
		String banner = mapper.selectBanner(song_id);
		
		return banner;
	}
}
