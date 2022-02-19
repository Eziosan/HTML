package music.is.mylife.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.is.mylife.dao.SongDAO;
import music.is.mylife.dao.TagDAO;
import music.is.mylife.dao.UserDAO;
import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.Tag;
import music.is.mylife.vo.UserInfo;

@Service
public class SongService {
	// Autowired DAO, 세션(선택)

	@Autowired
	SongDAO sdao;
	@Autowired
	TagDAO tdao;
	@Autowired
	UserDAO udao;

	// 해당 곡의 배너를 가져오는 메소드
	public String selectBanner(int song_id) {

		return sdao.selectBanner(song_id);
	}

	public String selectAlbumImg(int song_id) {

		// 앨범 id 값을 리턴해줌.
		return sdao.selectAlbumImg(song_id);
	}

	public Integer selectSongLike(int song_id) {

		return sdao.selectSongLike(song_id);

	}

	public void plusSongLike(int song_id) {

		sdao.plusSongLike(song_id);

	}

	public void minusSongLike(int song_id) {

		sdao.minusSongLike(song_id);

	}

	public Song selectSongOne(int song_id) {

		return sdao.selectSongOne(song_id);

	}

	public ArrayList<Playlist> selectList(String user_id) {

		ArrayList<Playlist> playlist = sdao.selectList(user_id);

		return playlist;
	}

	public Boolean insertPlaylist(Playlist playlist) {

		// 어레이 리스트로 리스트 전체를 받아서 for each문을 돌려 현재 존재하는 리스트의 이름과 새로 받은 리스트의 이름과 비교해서 있으면
		// 종료 없으면 리스트 생성하면서 곡까지 넣어줌.
		ArrayList<Playlist> ps = sdao.selectList(playlist.getUser_id());

		Boolean result = false;

		for (Playlist p : ps) {
			if (p.getList_name().equals(playlist.getList_name())) {

				System.out.println(p.getList_name());
				System.out.println(playlist.getList_name());

				result = false;
				break;
			}

			else {
				result = true;
			}

		}
		if (result) {
			sdao.insertList(playlist);

		}
		return result;

	}

	// 여기서 해야할게 곡아이디를 받아서 특정 유저의 특정 playlist에 곡을 담는걸 구현해야함.
	// ? 굳이 당초에 playlist name을 보여주고 특정 playlist를 클릭해서 곡 담는다고 했는데 여기서 유효성 검사할 필요는
	// 없을거같음(?)
	// 성공적으로 됐으면 redirect 실패면 다른걸로
	public void insertSong(Playlist playlist) {
		
		String user_id = playlist.getUser_id();
		
		ArrayList<Playlist> pl = sdao.selectList(user_id);
		ArrayList<Playlist> songs = sdao.selectPlayList_Song_id(playlist);
		
		
		Boolean flag = true;
		
		for(Playlist p : pl) {
			// playlist 이름과 같은 list를 찾아서 sysdate 업데이트 
			if(p.getList_name().equals(playlist.getList_name())) {
				// 리스트 이름이 있으면
			
				for(Playlist p2 : songs) {
					if(p2.getSong_id() == playlist.getSong_id()) {
						// 곡 아이디가 중복이면
						flag = false;
					
				}
			}
		}
		
		if(flag) {
			sdao.insertSong(playlist);
			// 곡을 추가함. 그러면 작업 끝 -> return 해야지
			
		}
		
	}
		 //추가 못했을 때 근데 추가 못할일이없는데 굳이 이걸 써야하나?
	}
	
	
	
	
	

	public int selectPlayListId(String list_name) {

		int playlist_id = sdao.selectPlayListId(list_name);

		return playlist_id;
	}

	public ArrayList<Tag> selectTag(int song_id) {

		ArrayList<Tag> tag = tdao.selectTag(song_id);
		return tag;
	}

	public void plusSongTagRecommend(Tag tag) {

		tdao.plusSongTagRecommend(tag);

	}

	public void minusSongTagRecommend(Tag tag) {

		tdao.minusSongTagRecommend(tag);
	}

	
	/**
	 * 곡페이지에서 회원가입하기
	 * @param userinfo
	 * @return
	 */
	public String insertUser(UserInfo userinfo) {
		
		//회원가입 처리
		int join = udao.insertUser(userinfo);
		
		if(join != 1) {
			return "song/mainPage";
		}
		return "song/mainPage";
	}
	

	/**
	 * [메인페이지] 전체 곡 검색해서 해당 곡 하나 들고오기
	 * 
	 * @param song
	 * @return song
	 */
	public Song selectAllSong(Song song) {
		Song selectSong = sdao.selectAllSong(song);

		return selectSong;
	}

}
