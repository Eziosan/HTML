package music.is.mylife.dao;

public interface UserLogMapper {
	//한 유저가 지금까지 별점을 매긴 곡 수
	public int selectAllStarCountByUser(String user_id);
	//한 유저가 지금까지 매긴 별점의 총합
	public double selectAllStarSumByUser(String user_id);
	//한 유저가 가장 많이 준 별점
	public int selectTopStarByUser(String user_id);
}
