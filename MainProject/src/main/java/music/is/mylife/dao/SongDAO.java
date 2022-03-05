package music.is.mylife.dao;

import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;

@Repository
public class SongDAO {
	
	@Autowired
	private SqlSession session;
	
	
	/**
	 * 조회수가 높은 순으로 상위 10개의 곡 출력(메인)
	 * @param song
	 * @return ArrayList<Song>
	 */
	public ArrayList<Song> selectTopSong(Song song){
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Song> songList = mapper.selectTopSong(song);
		
		return songList;
	}
	
	/**
	 * 선택한 장르의 곡들을 조회수 순으로 출력(메인)
	 * @param song
	 * @return ArrayList<Song>
	 */
	public ArrayList<Song> selectSongByGenre(String genre){
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Song> songList = mapper.selectSongByGenre(genre);
		
		return songList;
	}
	
	//곡id, 가수 id를 입력받아 곡 객체 하나가져오기(곡)
	public Song selectAllSong(Song song) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		Song selectSong = mapper.selectAllSong(song);
		
		
		return selectSong;
	}
	
	// 특정 곡의 평균 별점을 가져옴(곡)
	public double selectStars(int song_id) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		double avg = 0.0;
		int count = mapper.selectIsStars(song_id);
		
		if(count > 0 ) {
			
			avg = mapper.selectStars(song_id);
			
			
		}
		
		return avg;
		
	}
	
	//곡 아이디로 곡 정보 가져오기
	public Song selectSongsById(int song_id){
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		return mapper.selectSongsById(song_id);
		
	}

	
	
	public String selectAlbumImg(int song_id) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		String aimg = mapper.selectAlbumImg(song_id);
		
		return aimg;
	}
	
	
	
	//유저와 리스트이름이 중복되는 리스트가 있는지 확인
	public int listDupleCheck(Playlist pl) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		return mapper.listDupleCheck(pl);
	}
	
	public ArrayList<Playlist> selectList(String user_id){
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Playlist> playlist = mapper.selectList(user_id);
		
		return playlist;
	}
	
	
	
	
	public int insertList(Playlist playlist) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int num = mapper.selectListSeq();
		System.out.println("num = "+num);
		
		
		playlist.setPlaylist_id(num);
		
		
		
		return mapper.insertList(playlist);
		//mapper.insertList_Detail(playlist);
		
	}
	
	
	
	public void insertSong(Playlist playlist) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int playlist_id = playlist.getPlaylist_id();
		
		// 플레이리스트 디테일에 곡 넣기
		mapper.insertList_Detail(playlist);  
		// 플레이리스트에 날짜 업데이트
		mapper.updateList_Date(playlist_id);
		
		
		
	
	}
	
	public int selectSongCount(Playlist playlist) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		
		
		int count = mapper.selectSongCount(playlist);
		
		return count;
	}
	
	
	
	public int selectPlayListId(String list_name) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int playlist_id = mapper.selectPlayListId(list_name);
		
		return playlist_id;
	}
	
	
	
	public ArrayList<Playlist> selectTop4ListBySongId(int song_id){
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Playlist> list = mapper.selectTop4ListBySongId(song_id);
		
		
		return list;
	}
	
	
	
		

		
		
		
		
		
		// 검색 페이지(윤영)
		//곡명으로 검색
		public ArrayList<Song> selectSongsBySongName(String searchText){
			SongMapper mapper = session.getMapper(SongMapper.class);
			ArrayList<Song> searchList1 = mapper.selectSongsBySongName(searchText);
			
			return searchList1;
		}
		//가수명으로 검색
		public ArrayList<Song> selectSongsBySingerName(String searchText){
			SongMapper mapper = session.getMapper(SongMapper.class);
			ArrayList<Song> searchList2 = mapper.selectSongsBySingerName(searchText);
			
			return searchList2;
		}
		
}
