package music.is.mylife.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.is.mylife.dao.SongDAO;
import music.is.mylife.vo.Song;


@Service
public class HomeService {

	@Autowired
	SongDAO songDao;
	
	//곡 아이디로 곡 정보 가져오기
	public Song selectSongsById(int song_id){
		return songDao.selectSongsById(song_id);
	}
	
	/**
	 * 조회수가 높은 순으로 상위 5개의 곡 출력
	 * @param song
	 * @return ArrayList<Song>
	 */
	public ArrayList<Song> selectTopSong(Song song){
		ArrayList<Song> songList = songDao.selectTopSong(song);
		
		return songList;
	}
	
	/**
	 * 좋아요가 높은 순으로 상위 5개 곡 출력
	 * @param song
	 * @return ArrayList<Song>
	 */
	public ArrayList<Song> selectSongByGenre(String genre){
		ArrayList<Song> likeSong = songDao.selectSongByGenre(genre);
		
		return likeSong;
	}
	
	
}
