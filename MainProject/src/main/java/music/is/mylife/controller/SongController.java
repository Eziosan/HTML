package music.is.mylife.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.AnalysisService;
import music.is.mylife.service.ListService;
import music.is.mylife.service.SongService;
import music.is.mylife.service.UserService;
import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.Tag;
import music.is.mylife.vo.UserInfo;
import music.is.mylife.vo.UserLog;

@RequestMapping("song")
@Controller
public class SongController {
	
	private static final Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	SongService ss;
	
	@Autowired
	UserService us;
	
	@Autowired
	ListService ls;
	
	@Autowired
	AnalysisService as;
	
	// 별점 입력시 처리
	/*
	 * 모델로 넘길 정보
	 * 1. 유저
	 * 2. 리스트
	 * 3. 유저 로그 정보
	 */
	@RequestMapping(value = "starLog", method = RequestMethod.POST)
	public String analysisPage(UserLog ul, Model model, HttpSession session) {
		System.out.println("별점 입력 했습니다!!");
		String user_id = (String)session.getAttribute("user_id");
		
		//
		ul.setUser_id(user_id);
		
		System.out.println("유저로그 :" + ul);
		
		ss.recordUserLog(ul);
		
		
		
		
		Song song = new Song();
		song.setSinger_id(ul.getSinger_id());
		song.setSong_id(ul.getSong_id());
		
		//전체 곡 검색해 해당 곡 띄우기
		Song selectSong = ss.selectAllSong(song);

		double avg = ss.selectStars(song.getSong_id());
		
		selectSong.setAvg(avg);
		
		
		if(user_id!=null) {
			ArrayList<Playlist> playlist = ss.selectList(user_id);
			model.addAttribute("playlist", playlist);
			
		}
		
		ArrayList<Tag> tag = ss.selectTag(song.getSong_id());
		
		 // 해당 곡 리스트 부르기
		 ArrayList<Playlist> listId = ls.selectListId(song.getSong_id());
		 ArrayList<ArrayList<Playlist>> banner = new ArrayList<ArrayList<Playlist>>();
		 
		 model.addAttribute("singer_id", song.getSinger_id()); 
		 model.addAttribute("song_id", song.getSong_id()); 
		 model.addAttribute("Song", selectSong);
		 model.addAttribute("Tag", tag);
		 
		 // 플레이리스트아이디, 배너 사진들
		 for(Playlist info : listId) {
			 info.getPlaylist_id();
			banner.add(ls.listBanner(info.getPlaylist_id()));
		 }
		 	//리스트 아이디
		 	model.addAttribute("listId", listId);
		 
			//배너 사진
			model.addAttribute("banner", banner);
			
			//별점 담기
			model.addAttribute("starPoint", ul.getStar());
		
			//곡 아이디 세션에 담기
			session.setAttribute("song_id", song.getSong_id());
		
		return "song/mainPage";
	}

	
	
	@RequestMapping(value="plusStar",method=RequestMethod.GET)
	public String plusStar(int song_id) {
		logger.debug("플러스 스타 실행");
		ss.plusSongLike(song_id);
	
		return "redirect:/song/mainPage";
	
		
	}
	
	
	@RequestMapping(value="minusStar",method=RequestMethod.GET)
	public String minusStar(int song_id) {
		
		logger.debug("마이너스 스타 실행");
		ss.minusSongLike(song_id);
		
		return "redirect:/song/mainPage";
	
		
	}
	
	@RequestMapping(value="selectList", method=RequestMethod.GET)
	public String selectList(Model model,HttpSession session) {
		
		String user_id;
		
		
		
		user_id = (String)session.getAttribute("user_id");
		
		
		ArrayList<Playlist> playlist = ss.selectList(user_id);
		
		
		
		
		model.addAttribute("playlist", playlist);
	
		
		return "song/listPage";
	}
	

	
	
	@RequestMapping(value="insertList", method=RequestMethod.POST)
	public String insertList(Model model, Playlist playlist) {
		
		//여기서 할 거 > 리스트 생성하기
		String url;
		
		Boolean result = ss.insertPlaylist(playlist);
		
		if(result) {
			url="redirect:/main";
			
		}else {
			url="song/listPage";
		}
		
		// 트루면 메인으로
		// 펄스면 listpage로 감
		
		logger.debug("Result : {}", result);
		// 추가 됐으면 true 안됐으면 false.
		// listPage에서 true냐, false냐에 따라 리스트 추가됐는지 안됐는지 코드짜면 될거같음.
		
		return url;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	// 새로운 플레이리스트 생성
	@RequestMapping(value="addPlayList",method=RequestMethod.POST)
	public String addPlayList(Playlist pl, Model model,HttpSession session) {
		
		System.out.println("리스트 추가 실행");
		String user_id = (String)session.getAttribute("user_id");
		Song song = ss.selectSongOne(pl.getSong_id());
		
		//여기서 할 거 > 리스트 생성하기
		String url;
		pl.setUser_id(user_id);
				
		ss.insertPlaylist(pl);
				
		
		/////////////
		

		double avg = ss.selectStars(pl.getSong_id());
		song.setAvg(avg);
		
		
		if(user_id!=null) {
			ArrayList<Playlist> playlist = ss.selectList(user_id);
			model.addAttribute("playlist", playlist);
			
		}
		
		ArrayList<Tag> tag = ss.selectTag(pl.getSong_id());
		
		 // 해당 곡 리스트 부르기
		 ArrayList<Playlist> listId = ls.selectListId(pl.getSong_id());
		 ArrayList<ArrayList<Playlist>> banner = new ArrayList<ArrayList<Playlist>>();
		 
		 model.addAttribute("singer_id", pl.getSinger_id()); 
		 model.addAttribute("song_id", pl.getSong_id()); 
		 model.addAttribute("Song", song);
		 model.addAttribute("Tag", tag);
		 model.addAttribute("Song",song);
		 
		 // 플레이리스트아이디, 배너 사진들
		 for(Playlist info : listId) {
			 info.getPlaylist_id();
			banner.add(ls.listBanner(info.getPlaylist_id()));
		 }
		 	//리스트 아이디
		 	model.addAttribute("listId", listId);
		 
			//배너 사진
			model.addAttribute("banner", banner);
		
			//곡 아이디 세션에 담기
				
				
				
		
		
		return "song/mainPage";
	}
	
	
	
	// 곡을 리스트에 추가하는 method
	@RequestMapping(value="addSongList",method=RequestMethod.POST)
	public String addSongList(Playlist pl, Model model,HttpSession session) {
		
		
		// user_id를 세션으로부터 가져와서 값 저장
		String user_id = (String)session.getAttribute("user_id");
		
		
		Song song = ss.selectSongOne(pl.getSong_id());
		// 값 받아옴.
		// 곡 id, playlist_id를 가지고 곡을 넣어야함.
		
		pl.setUser_id(user_id);
		
		
		ss.insertSong(pl);
		
		
		///////////
		
		//전체 곡 검색해 해당 곡 띄우기
		Song selectSong = ss.selectAllSong(song);

		//평균 별점
		double avg = ss.selectStars(song.getSong_id());
		
		selectSong.setAvg(avg);
		
		
		if(user_id!=null) {
			//유저의 모든 리스트를 가져옴
			ArrayList<Playlist> playlist = ss.selectList(user_id);
			model.addAttribute("playlist", playlist);
			
		}
		
		ArrayList<Tag> tag = ss.selectTag(song.getSong_id());
		
		 // 해당 곡 리스트 부르기
		 ArrayList<Playlist> listId = ls.selectListId(song.getSong_id());
		 ArrayList<ArrayList<Playlist>> banner = new ArrayList<ArrayList<Playlist>>();
		 
		 model.addAttribute("Song", selectSong);
		 model.addAttribute("Tag", tag);
		 
		 // 플레이리스트아이디, 배너 사진들
		 for(Playlist info : listId) {
			 info.getPlaylist_id();
			banner.add(ls.listBanner(info.getPlaylist_id()));
		 }
		 	//리스트 아이디
		 	model.addAttribute("listId", listId);
		 
		 	model.addAttribute("singer_id", song.getSinger_id()); 
			//배너 사진
			model.addAttribute("banner", banner);
		
			//곡 아이디 세션에 담기
			session.setAttribute("song_id", song.getSong_id());
		
			model.addAttribute("song_id",pl.getSong_id());
			model.addAttribute("Song",song);
		
		return "song/mainPage";
	}
	
	
	
	
	/**
	 * 곡페이지에서 로그인하기
	 * @param user_id
	 * @param user_pw
	 * @param model
	 * @param session
	 * @return song/songPage
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String user_id, String user_pw, Model model, HttpSession session, Song song) {
		
		UserInfo user_info = us.selectUser(user_id);
		
		
	
		  if(user_info != null && user_info.getUser_pw().equals(user_pw)) {
			  session.setAttribute("user_id", user_id);
		  } 
		  //여기서 user_id에 값을 넣어줬기 때문에 밑에서 확인가능.
		  
		 
		
		 Song selectSong = ss.selectAllSong(song);
		
		
		
		ArrayList<Playlist> listId = ls.selectListId(song.getSong_id());
		ArrayList<Tag> tag = ss.selectTag(song.getSong_id());
		ArrayList<Playlist> playlist = ss.selectList(user_id);
		
		
		
		
		
		
		  model.addAttribute("singer_id", song.getSinger_id());
		  model.addAttribute("song_id", song.getSong_id()); 
		  model.addAttribute("Song",  selectSong);
		  model.addAttribute("listId", listId);
		  model.addAttribute("Tag", tag);
		  model.addAttribute("playlist",playlist);
	
		
		
		
		
		return "song/mainPage";
	}
	
	
	
	
	/**
	 * 곡페이지에서 회원가입 처리
	 * @param userinfo
	 * @param model
	 * @return ss.insertUser(userinfo)
	 */
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute("userinfo") UserInfo userinfo ,Model model, Song song) {
		
		Song selectSong = ss.selectAllSong(song);
		
		model.addAttribute("singer_id", selectSong.getSinger_id());
		model.addAttribute("song_id", selectSong.getSong_id());
		model.addAttribute("Song", selectSong);
		
		ArrayList<Playlist> listId = ls.selectListId(song.getSong_id());
		model.addAttribute("listId", listId);
		
		if(us.insertUser(userinfo)) {
			System.out.println("회원가입 성공!!!!");
			
		}else {
			System.out.println("회원가입 실패!!!!");
			
		}
		
		
		return "song/mainPage";
	}
	
	
	
	/**
	 * 곡페이지에서 로그아웃하기
	 * @param session
	 * @param song
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String lougout(HttpSession session, Song song, Model model) {
		
		session.invalidate();
		
		Song selectSong = ss.selectAllSong(song);
		ArrayList<Playlist> listId = ls.selectListId(song.getSong_id());
		ArrayList<Tag> tag = ss.selectTag(song.getSong_id());
		
		
		model.addAttribute("singer_id", song.getSinger_id());
		model.addAttribute("song_id", song.getSong_id());
		model.addAttribute("Song", selectSong);
		model.addAttribute("listId", listId);
		
		
		
		model.addAttribute("Tag", tag);
		
		
		
	
		
		return "song/mainPage";
	}
	
	
	
	
	
	
}
