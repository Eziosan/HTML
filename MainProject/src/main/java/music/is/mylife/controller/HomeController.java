package music.is.mylife.controller;

import java.util.ArrayList;
import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.HomeService;
import music.is.mylife.vo.Song;


@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HomeService hs;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
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
		ArrayList<Song> songList = hs.selectTopSong(song);
		logger.info("Song:{}", songList);
		
		ArrayList<Song> likeSong = hs.selectLikeSong(song);
		logger.info("SongLike: {}", likeSong);
		
		model.addAttribute("songList", songList);
		model.addAttribute("likeSong", likeSong);
		
		return "main";
	}
	
	



	
}
