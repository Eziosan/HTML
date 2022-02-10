package music.is.mylife.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.SongService;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.Tag;

@RequestMapping("song")
@Controller
public class SongController {
	
	private static final Logger logger = LoggerFactory.getLogger(SongController.class);
//	@RequestMapping(value="song/main", method=RequestMethod.GET)
//	public void test() {
//		Song song = new Song();
//		
//		
//	}
	
	@Autowired
	SongService ss;
	
	@RequestMapping(value="song2",method=RequestMethod.GET)
	public String mainPage( Model model) {
		
		int a=1;
		
		String banner = ss.selectBanner(9);
		String ai = ss.selectAlbumImg(1);
		int sl = ss.selectSongLike(9);
		ss.plusSongLike(1);
		ss.minusSongLike(2);
		Song song = ss.selectSongOne(9);
		ArrayList<Tag> tag = ss.selectTag(1);
		
		//ss.plusSongTagRecommend(1);
		//ss.minusSongTagRecommend(2);
		
		logger.info("banner : {}", banner);
		logger.info("AlbumImg : {}", ai);
		logger.info("sl : {}", sl);
		logger.info("Song : {}", song);
		logger.info("tag : {}", tag);
		
		model.addAttribute("banner", banner);
		model.addAttribute("ai", ai);
		model.addAttribute("Song",song);
		
		return "song/song2";
	}
}
