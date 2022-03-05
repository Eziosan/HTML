package music.is.mylife.dao;

import java.util.ArrayList;

import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;

public interface SongMapper {
	//곡 아이디로 곡 정보 가져오기
	public Song selectSongsById(int song_id);
	
	//앨범 아이디로 앨범 사진 URL을 가져오는 SQL문 //
	public String selectAlbumImg(int song_id);
	
	//곡 아이디를 받아 곡명, 가수 이름, 국적, 앨범 이름, 앨범 날짜, 장르 가져오는 SQL문//
	public Song selectSongOne(int song_id);
	
	//유저와 리스트이름이 중복되는 리스트가 있는지 확인
	public int listDupleCheck(Playlist pl);
	// 유저 아이디를 받아 유저가 가지고 있는 모든 리스트를 반환함
	public ArrayList<Playlist> selectList(String user_id);
	// 시퀀스 하나 증가시키는 sql문
	public int selectListSeq();
	// 리스트 추가하는 sql문
	public int insertList(Playlist playlist);
	// 리스트 디테일 추가하는 sql문
	public void insertList_Detail(Playlist playlist);
	// 플레이리스트 날짜를 최신날짜로 업데이트하는 sql문
	public int updateList_Date(int playlist_id);
	// 리스트 이름으로 플레이리스트 id를 가져오는 sql문
	public int selectPlayListId(String list_name);
	// playlist_id 로 playlist_detail의 곡 id들을 가져오는 sql문
	public int selectSongCount(Playlist playlist);
	// 특정 곡의 별점을 가져오는 sql문
	public double selectStars(int song_id);
	// 곡에 별점이 있는지 확인하는 sql문
	public int selectIsStars(int song_id);
	// 곡 id로 상위 4개의 리스트를 반환받는 sql문
	public ArrayList<Playlist> selectTop4ListBySongId(int song_id);
	
	
	// 메인 페이지(화원)
	
		/**
		 * 조회수가 높은 순으로 상위 5개의 곡 출력
		 * @param song
		 * @return ArrayList<Song>
		 */
		public ArrayList<Song> selectTopSong(Song song);
		
		/**
		 * 좋아요가 높은 순으로 상위 5개 곡 출력
		 * @param song
		 * @return ArrayList<Song>
		 */
		public ArrayList<Song> selectSongByGenre(String genre);
		
		/**
		 * 전체 곡 검색
		 * @param song
		 * @return song
		 */
		public Song selectAllSong(Song song);
		
		
		// 검색 페이지(윤영)
		public ArrayList<Song> selectSongsBySongName(String searchText);
		public ArrayList<Song> selectSongsBySingerName(String searchText);
		
	
}
