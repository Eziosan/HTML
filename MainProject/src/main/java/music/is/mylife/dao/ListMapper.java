package music.is.mylife.dao;

import java.util.ArrayList;

import music.is.mylife.vo.ListComment;
import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;

public interface ListMapper {
	//해당 유저의 모든 리스트 좋아요 수 
	public double selectListLikesByUser(String user_id);
	
	//해당 유저의 모든 리스트에 지금까지 달린 모든 댓글 수
	public double selectListCommentsNumByUser(String user_id);
	
	public double selectListCountByUser(String user_id);
	//리스트 페이지_화원
	/**
	 * 플레이리스트를 가진 유저 아이디
	 * @return ArrayList<string>
	 */
	public ArrayList<Playlist> selectListId(int song_id);
	
	/**
	 * 리스트 배너 상위 5개 출력
	 * @return ArrayList<Song>
	 */
	public ArrayList<Playlist> selectListBanner(int playlist_id);
	
	/**
	 * 리스트 곡 정보 출력
	 * @return ArrayList<Song>
	 */
	public ArrayList<Playlist> selectListSong(int playlist_id);
	
	/**
	 * 리스트 정보 출력
	 * @param listInfo
	 * @return Playlist
	 */
	public Playlist selectListInfo(int playlist_id);
	
	/**
	 * 해당 리스트 곡 개수
	 * @param playlist_id
	 * @return int
	 */
	public int selectCountSong(int playlist_id);
	
	/**
	 * 리스트 댓글 개수
	 * @param playlist_id
	 * @return int
	 */
	public int selectCountComment(int playlist_id);
	
	/**
	 * 리스트 검색
	 * @param playlist_id
	 * @return ArrayList<Playlist>
	 */
	public ArrayList<Playlist> selectList(int playlist_id);
	
	/**
	 * 리스트 좋아요 검색
	 * @param playlist_id
	 * @return Playlist
	 */
	public Playlist selectListLike(int playlist_id);
	
	/**
	 * 리스트 전체 출력
	 * @param listReply
	 * @return
	 */
	public ArrayList<ListComment> selectListComment(int playlist_id);
	
	/**
	 * 리스트 댓글 입력
	 * @param comment
	 * @return int
	 */
	public int insertListCommnet(ListComment reply);
	
	/**
	 * 댓글 삭제하기
	 * @param delComment
	 * @return
	 */
	public int deleteComment(ListComment delComment);
	
	/**
	 * 리스트 좋아요수 올리기
	 * @param playlist_id
	 * @return int
	 */
	public int updatePluseLike(int playlist_id);
	
	/**
	 * 리스트 좋아요수 내리기
	 * @param playlist_id
	 * @return int
	 */
	public int updateMinuLike(int playlist_id);
	
}
