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
		
		return "analysis/analysisPage";
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
	
	// 여기다가 특정 유저의 특정 리스트에 곡 담는거 구현해야함
	// 일단 플레이리스트를 받아와야하는데 그럼 로그인을 할때 로그인 정보, 플레이리스트 정보도 같이 세션이 담아서 보내놓으면 
	// 다른곳에서도 쓸 수 있는게 아닌가? >> 물어보기
	// 유저 id, list name을 받아오면?
	@RequestMapping(value="insertSong",method=RequestMethod.GET)
	public String insertSong(String plist, HttpSession session,Model model  ) {
		
		
		String user_id = (String)session.getAttribute("user_id");
		String playlist_name = plist;
		int Song_id = (int)session.getAttribute("song_id");
		int playlist_id = ss.selectPlayListId(playlist_name);
		
		logger.debug("playlist_id : {}", playlist_id);
		logger.debug("playlist 객체 출력 : {}", playlist_name) ; 
		logger.debug("user_id 출력 : {}", user_id) ;
		logger.debug("song_id : {}", Song_id);
		
		Playlist playlist = new Playlist();
		
		playlist.setUser_id(user_id);
		playlist.setList_name(playlist_name);
		playlist.setPlaylist_id(playlist_id);
		playlist.setSong_id(Song_id);
		
		Song song = ss.selectSongOne(Song_id);
		
		ss.insertSong(playlist);
		
		//model.addAttribute("song_id",Song_id);
		//session.setAttribute("song_id", Song_id);
		model.addAttribute("Song",song);
		//return "redirect:selectList";
		// 모델에 넣어서 보내면 jsp에서 모델에 넣은 객체를 사용할수있음
		
		return "song/mainPage";
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="addPlayList",method=RequestMethod.POST)
	public String addPlayList(Playlist pl, Model model,HttpSession session) {
		
		
		String user_id = (String)session.getAttribute("user_id");
		ArrayList<Playlist> playlist = ss.selectList(user_id);
		Song song = ss.selectSongOne(pl.getSong_id());
		
		//여기서 할 거 > 리스트 생성하기
				String url;
				pl.setUser_id(user_id);
				
				
				Boolean result = ss.insertPlaylist(pl);
				
				if(result) {
					url="redirect:/main";
					
				}else {
					url="song/listPage";
				}
				
				model.addAttribute("Song",song);
				model.addAttribute("playlist",playlist);
				
				
				
		
		
		return "song/mainPage";
	}
	
	
	
	@RequestMapping(value="addSongList",method=RequestMethod.POST)
	public String addSongList(Playlist pl, Model model,HttpSession session) {
		
		
		// user_id를 세션으로부터 가져와서 값 저장
		String user_id = (String)session.getAttribute("user_id");
		
		// 유저가 가지고 있는 모든 리스트를 가져옴
		ArrayList<Playlist> playlist = ss.selectList(user_id);
		
		Song song = ss.selectSongOne(pl.getSong_id());
		// 값 받아옴.
		// 곡 id, playlist_id를 가지고 곡을 넣어야함.
		
		pl.setUser_id(user_id);
		
		
		ss.insertSong(pl);
		
		
		
		model.addAttribute("song_id",pl.getSong_id());
		model.addAttribute("Song",song);
		model.addAttribute("playlist",playlist);
		
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
		
		return ss.insertSongUser(userinfo);
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
