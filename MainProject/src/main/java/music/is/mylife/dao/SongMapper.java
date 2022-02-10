package music.is.mylife.dao;

import music.is.mylife.vo.Song;

public interface SongMapper {
	
	//곡 아이디로 배너 사진 URL을 가져오는 SQL문//
	public String selectBanner(int song_id);
	//앨범 아이디로 앨범 사진 URL을 가져오는 SQL문 //
	public String selectAlbumImg(int song_id);
	//곡 아이디로 곡 좋아요 수를 가져오는 SQL문//
	public int selectSongLike(int song_id);
	//곡 아이디를 입력받아 좋아요 수를 증가시키는 SQL문//
	public int plusSongLike(int song_id);
	//곡 아이디를 입력받아 좋아요 수를 감소시키는 SQL문//
	public int minusSongLike(int song_id);
	//곡 아이디를 받아 곡명, 가수 이름, 국적, 앨범 이름, 앨범 날짜, 장르 가져오는 SQL문//
	public Song selectSongOne(int song_id);
	
}
