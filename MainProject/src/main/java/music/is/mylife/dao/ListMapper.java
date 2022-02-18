package music.is.mylife.dao;

public interface ListMapper {
	//해당 유저의 모든 리스트 좋아요 수 
	public int selectListLikesByUser(String user_id);
	
	//해당 유저의 모든 리스트에 지금까지 달린 모든 댓글 수
	public int selectListCommentsNumByUser(String user_id);
}
