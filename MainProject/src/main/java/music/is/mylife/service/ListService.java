package music.is.mylife.service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.is.mylife.dao.ListDAO;
import music.is.mylife.vo.ListComment;
import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;

@Service
public class ListService {

	@Autowired
	ListDAO ldao;
	
	/**
	 * 플레이리스트를 가진 유저 아이디
	 * @return ArrayList<string>
	 */
	public ArrayList<Playlist> selectListId(int song_id){
		ArrayList<Playlist> listId = ldao.selectListId(song_id);
		
		return listId;
	}
	
	/**
	 * 리스트 배너 상위 5개 출력
	 * @param song
	 * @return ArrayList<Song>
	 */
	public ArrayList<Playlist> listBanner(int playlist_id){
		ArrayList<Playlist> banner = ldao.selectListBanner(playlist_id);
		
		return banner;
	}
	/**
	 * 리스트 곡 정보 출력
	 * @return ArrayList<Playlist>
	 */
	public ArrayList<Playlist> listSong(int playlist_id){
		ArrayList<Playlist> listSong = ldao.selectListSong(playlist_id);
		
		return listSong;
	}
	
	/**
	 * 리스트 정보 출력
	 * @param listInfo
	 * @return Playlist
	 */
	public Playlist listInfo(int playlist_id) {
		Playlist info = ldao.selectListInfo(playlist_id);
		
		return info;
	}
	
	/**
	 * 해당 리스트 곡 개수
	 * @param playlist_id
	 * @return int
	 */
	public int countSong(int playlist_id) {
		int count = ldao.selectCountSong(playlist_id);
		
		return count;
	}
	
	/**
	 * 리스트 댓글 입력
	 * @param comment
	 * @return int
	 */
	public int insertCommnet(ListComment reply) {
		int listReply = ldao.insertListCommnet(reply);
		
		return listReply;
	}
}
