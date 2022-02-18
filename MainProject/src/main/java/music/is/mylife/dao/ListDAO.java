package music.is.mylife.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ListDAO {
	
	@Autowired
	private SqlSession session;
	
	//해당 유저의 모든 리스트 좋아요 수 
	public int selectListLikesByUser(String user_id) {
		ListMapper mapper = session.getMapper(ListMapper.class);
		
		int listLikeNum = mapper.selectListLikesByUser(user_id);
		
		return listLikeNum;
	}
	
	//해당 유저의 모든 리스트에 지금까지 달린 모든 댓글 수
	public int selectListCommentsNumByUser(String user_id) {
		ListMapper mapper = session.getMapper(ListMapper.class);
		
		int listCommentNum = mapper.selectListCommentsNumByUser(user_id);
		
		return listCommentNum;
	}
	
}
