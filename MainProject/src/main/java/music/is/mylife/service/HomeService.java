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
	public ArrayList<Song> selectLikeSong(Song song){
		ArrayList<Song> likeSong = songDao.selectLikeSong(song);
		
		return likeSong;
	}
}
