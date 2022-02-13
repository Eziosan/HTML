package music.is.mylife.dao;

import java.util.ArrayList;

import music.is.mylife.vo.Song;

public interface SongMapper {
	
	public String selectBanner(int song_id);
	public String selectAlbumImg(int album_id);
	public int selectSongLike(String song_name);
	public int plusSongLike(String song_name);
	public int minusSongLike(String song_name);
	
	
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
	public ArrayList<Song> selectLikeSong(Song song);
	
}
