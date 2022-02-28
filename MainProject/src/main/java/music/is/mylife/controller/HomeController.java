package music.is.mylife.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.HomeService;
import music.is.mylife.service.ListService;
import music.is.mylife.service.SongService;
import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.Tag;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	SongService ss;

	@Autowired
	HomeService hs;
	
	@Autowired
	ListService ls;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		
		
		return "redirect:main";
	}
	
	@RequestMapping(value = "backdoor", method = RequestMethod.GET)
	public String backdoor(Song song, Model model) {
		int[] korea = {69,  169, 170, 221, 253, 130,310, 350, 372, 296, 5, 73,  287, 10, 24, 309 , 999, 
				27, 33, 42, 159,  99, 100, 131, 133, 134, 167, 
				 177, 181, 193, 212, 220, 229,408,  256, 429,   341, 344, 346,
				 373,  381, 378, 399, 400, 407  };
		int[] japan = {629, 467,  512, 519, 552, 520, 462, 465, 611, 493, 494,  515 , 521, 527, 536, 542,
				553, 556, 579, 581, 584,  621, 616,459, 622,461 , 642};
		int[] USA = {669, 791,672, 705, 717, 707,  740, 741, 790,676 , 793, 839, 820, 821, 855, 852,
				854, 858, 940, 946, 951,706, 969, 972, 974};
		ArrayList<Song> korean = new ArrayList<Song>();
		ArrayList<Song> japanese = new ArrayList<Song>();
		ArrayList<Song> american = new ArrayList<Song>();
		
		//한국 곡의 song_id를 차례대로 넣어서 가져온 곡들을 arrayList에 차곡차곡 쌓음
		for(int song_id : korea) {
			Song song2 = hs.selectSongsById(song_id);
			korean.add(song2);
			
		}
		//일본 곡의 song_id를 차례대로 넣어서 가져온 곡들을 arrayList에 차곡차곡 쌓음
		for(int song_id : japan) {
			Song song2 = hs.selectSongsById(song_id);
			japanese.add(song2);
		}
		//미국 곡의 song_id를 차례대로 넣어서 가져온 곡들을 arrayList에 차곡차곡 쌓음
		for(int song_id : USA) {
			Song song2 = hs.selectSongsById(song_id);
			american.add(song2);
		}
		
		logger.info("노래:{}", song);
		ArrayList<Song> songList = hs.selectTopSong(song);
		logger.info("SongList:{}", songList);
		
		ArrayList<Song> likeSong = hs.selectSongByGenre("발라드");
		logger.info("SongLike: {}", likeSong);
		
		model.addAttribute("songList", songList);
		model.addAttribute("likeSong", likeSong);
		model.addAttribute("korean", korean);
		model.addAttribute("japanese", japanese);
		model.addAttribute("american", american);
		
		return "testingPage";
		//return "home";
	}

	/**
	 * 1. 조회수 상위 5개의 곡 값을 main.jsp에 넘기기 2. 좋아요 상위 5개의 곡 값을 main.jsp에 넘기기
	 * 
	 * @param song
	 * @param model
	 * @return main.jsp
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String topSong(Song song, Model model) {
		logger.info("노래:{}", song);
		ArrayList<Song> songList = hs.selectTopSong(song);
		logger.info("SongList:{}", songList);

		ArrayList<Song> likeSong = hs.selectSongByGenre("발라드");
		logger.info("SongLike: {}", likeSong);

		model.addAttribute("songList", songList);
		model.addAttribute("likeSong", likeSong);

		return "main";
	}

	/**
	 * 곡 이름누르면 해당 곡 페이지로 이동
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "song/songPage", method = RequestMethod.GET)
	public String songPage(Model model, int singer_id, int song_id, Song song, HttpSession session) {
		String user_id = (String)session.getAttribute("user_id");
		//전체 곡 검색해 해당 곡 띄우기
		Song selectSong = ss.selectAllSong(song);
		//평균 별점
		double avg = ss.selectStars(song_id);
		selectSong.setAvg(avg);
		//해당 유저가 해당 곡에 매긴 별점
		
		
		if(user_id!=null) {
			double starPoint = hs.selectUserStar(song_id, user_id);
			ArrayList<Playlist> playlist = ss.selectList(user_id);
			model.addAttribute("starPoint", starPoint);
			model.addAttribute("playlist", playlist);
			
		}
		
		ArrayList<Tag> tag = ss.selectTag(song_id);
		
		 // 해당 곡 리스트 부르기
		 ArrayList<Playlist> listId = ls.selectListId(song_id);
		 ArrayList<ArrayList<Playlist>> banner = new ArrayList<ArrayList<Playlist>>();
		 
		 model.addAttribute("singer_id", singer_id); 
		 model.addAttribute("song_id", song_id); 
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
		
			//곡 아이디 세션에 담기
			session.setAttribute("song_id", song_id);
		 
		 
		return "song/mainPage";
	}

}
