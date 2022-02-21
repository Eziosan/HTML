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
	public String home() {
		
		return "home";
	}
	
	/**
	 * 1. 조회수 상위 5개의 곡 값을 main.jsp에 넘기기
	 * 2. 좋아요 상위 5개의 곡 값을 main.jsp에 넘기기
	 * @param song
	 * @param model
	 * @return main.jsp
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String topSong(Song song, Model model) {
		logger.info("노래:{}", song);
		ArrayList<Song> songList = hs.selectTopSong(song);
		logger.info("SongList:{}", songList);
		
		ArrayList<Song> likeSong = hs.selectLikeSong(song);
		logger.info("SongLike: {}", likeSong);
		
		model.addAttribute("songList", songList);
		model.addAttribute("likeSong", likeSong);
		
		return "main";
	}
	
	/**
	 * 곡 이름누르면 해당 곡 페이지로 이동
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "song/songPage", method = RequestMethod.GET)
	public String songPage(Model model, int singer_id, int song_id, Song song) {
		
		Song selectSong = ss.selectAllSong(song);
		//플레이 리스트 아이디
		ArrayList<Playlist> listId = ls.selectListId(song_id);
		logger.info("리스트 아이디:{}", listId);
		
		logger.info("Song:{}", selectSong);
		
		
		model.addAttribute("singer_id", singer_id);
		model.addAttribute("song_id", song_id);
		model.addAttribute("Song", selectSong);
		
		//플레이리스트아이디
		model.addAttribute("listId", listId);
		
		return "song/mainPage";
	}



	
}
