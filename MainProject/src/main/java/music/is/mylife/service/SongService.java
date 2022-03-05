package music.is.mylife.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.is.mylife.dao.SongDAO;
import music.is.mylife.dao.TagDAO;
import music.is.mylife.dao.UserDAO;
import music.is.mylife.dao.UserLogDAO;
import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.Tag;
import music.is.mylife.vo.UserInfo;
import music.is.mylife.vo.UserLog;

@Service
public class SongService {
	// Autowired DAO, 세션(선택)

	@Autowired
	SongDAO sdao;
	@Autowired
	TagDAO tdao;
	@Autowired
	UserDAO udao;
	@Autowired
	UserLogDAO uld;
	@Autowired
	TagDAO td;
	
	//곡id, 가수 id를 입력받아 곡 객체 하나가져오기(곡)
	public Song selectAllSong(Song song) {
		Song selectSong = sdao.selectAllSong(song);

		return selectSong;
	}
	
	
	// 특정 곡의 평균 별점을 가져옴(곡)
	public double selectStars(int song_id) {
		
		double avg = sdao.selectStars(song_id);
		
		System.out.println("songservice avg" + avg);
		
		return avg;
	}
	
	//해당 유저가 해당 곡에 매긴 별점을 가져옴(곡)
	public double selectUserStar(int song_id, String user_id) {
		
		UserLog ul = new UserLog();
		ul.setSong_id(song_id);
		ul.setUser_id(user_id);
		
		return uld.selectUserStar(ul);
	}
	
	//해당 곡의 상위 10개 태그 목록 가져오기(곡)
	public ArrayList<Tag> selectTag(int song_id) {

		ArrayList<Tag> tag = tdao.selectTop10TagBySongId(song_id);
		return tag;
	}

	
	
	
	

	public String selectAlbumImg(int song_id) {

		// 앨범 id 값을 리턴해줌.
		return sdao.selectAlbumImg(song_id);
	}



	public ArrayList<Playlist> selectList(String user_id) {

		ArrayList<Playlist> playlist = sdao.selectList(user_id);

		return playlist;
	}

	public Boolean insertPlaylist(Playlist playlist) {

		// 어레이 리스트로 리스트 전체를 받아서 for each문을 돌려 현재 존재하는 리스트의 이름과 새로 받은 리스트의 이름과 비교해서 있으면
		// 종료 없으면 리스트 생성하면서 곡까지 넣어줌.
		//결국에는 유저 id로 해당 유저의 모든 리스트를 가져옴
		ArrayList<Playlist> ps = sdao.selectList(playlist.getUser_id());
		
		if(sdao.listDupleCheck(playlist) > 0) {
			return false;
		}
		
		int result = sdao.insertList(playlist);
		
		System.out.println("새 리스트 추가 결과 : " + result);
		
		return true;

	}

	// 여기서 해야할게 곡아이디를 받아서 특정 유저의 특정 playlist에 곡을 담는걸 구현해야함.
	// ? 굳이 당초에 playlist name을 보여주고 특정 playlist를 클릭해서 곡 담는다고 했는데 여기서 유효성 검사할 필요는
	// 없을거같음(?)
	// 성공적으로 됐으면 redirect 실패면 다른걸로
	public void insertSong(Playlist playlist) {
		
		
		
		
		int count = sdao.selectSongCount(playlist);
		
		
		if(count==0) {
				
				sdao.insertSong(playlist);
			}
		else {
			return;
		}
		}
		

		
		/*
		 * 곡의 id를 받아서 상위 4개 리스트를 반환하는 method
		 * */
		public ArrayList<Playlist> selectTop4ListBySongId(int song_id){
			
			ArrayList<Playlist> list = sdao.selectTop4ListBySongId(song_id);
			
			return list;
			
		}
	
	
	
	
	
	

	public int selectPlayListId(String list_name) {

		int playlist_id = sdao.selectPlayListId(list_name);

		return playlist_id;
	}


	
	


	
	
	
	
	/**
     * 리스트 페이지에서 회원가입 처리
     * @param userinfo
     * @return
     */
    public String insertListUser(UserInfo userinfo) {
        //회원가입 처리
        int join = udao.insertUser(userinfo);

        if(join != 1) {
            return "list/listpage";
        }
        return "list/listpage";
    }
    
	


	
	
	/* 
	 * 2. 별점 매길 시 유저 로그 입력
	 */
	public void recordUserLog(UserLog ul) {
		//중복된 곡이 있을 때
		if(uld.songStarCheck(ul) > 0) {
			//all_star는 신규별점 - 기존 별점 차이만큼, grade_count는 안올라가게
			double star = ul.getStar() - uld.selectSongStarById(ul);
			ul.setAll_star(star);
			
			System.out.println("별점 : " + star);
			System.out.println("ul 별점 : " + ul.getStar());
			System.out.println("기존별점 : " + uld.selectSongStarById(ul));
			
			//user_song_log 업데이트
			uld.updateSongLog(ul);
			
			tagLogInsert(ul);
			singerLogInsert(ul);
			countryLogInsert(ul);
			genreLogInsert(ul);
			
		}else{
			//중복된 곡이 없을 때. 별점 : 새로 추가한 별점, 카운트 : 1 증가
			ul.setAll_star(ul.getStar());
			ul.setGrade_count(1);
			
			//곡 새로 추가
			uld.insertSongLog(ul);
			//tagLog 입력
			tagLogInsert(ul);
			singerLogInsert(ul);
			countryLogInsert(ul);
			genreLogInsert(ul);
		}
		
	}
	
	//태그 로그 처리 : 중복된 태그가 없으면 insert, 있으면 update
	public void tagLogInsert(UserLog ul) {
		//상위 3개 태그
		ArrayList<Tag> tagList = td.selectTop3TagBySongId(ul.getSong_id());
		
		for(Tag t : tagList) {
			//n번째 태그 id를 조건으로 줌 -> 중복검사 위함
			ul.setTag_id(t.getTag_id());
			
			//중복된 태그 있는지 확인. 
			if(uld.tagStarCheck(ul) > 0) {
				//업데이트
				uld.updateTagLog(ul);
			}else {
				//중복된 태그가 없어. insert
				uld.insertTagLog(ul);
			}
		}
	}
	
	//가수 로그 처리 : 중복된 태그가 없으면 insert, 있으면 update
	public void singerLogInsert(UserLog ul) {
		
		//중복된 가수 있는지 확인. 
		if(uld.singerStarCheck(ul) > 0) {
			//중복된 가수가 있다면 업데이트
			uld.updateSingerLog(ul);
		}else {
			//중복된 태그가 없어. insert
			uld.insertSingerLog(ul);
		}
	}
	//국가 로그 처리 : 중복된 태그가 없으면 insert, 있으면 update
	public void countryLogInsert(UserLog ul) {
		
		//중복된 국가 있는지 확인. 
		if(uld.countryStarCheck(ul) > 0) {
			//중복된 국가가 있다면 업데이트
			uld.updateCountryLog(ul);
		}else {
			//중복된 국가가 없어. insert
			uld.insertCountryLog(ul);
		}
	}
	//장르 로그 처리 : 중복된 태그가 없으면 insert, 있으면 update
	public void genreLogInsert(UserLog ul) {
		
		//중복된 장르가 있는지 확인. 
		if(uld.genreStarCheck(ul) > 0) {
			//중복된 장르가 있다면 업데이트
			uld.updateGenreLog(ul);
		}else {
			//중복된 장르가 없어. insert
			uld.insertGenreLog(ul);
		}
	}


}
