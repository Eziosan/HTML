package music.is.mylife.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.SongService;
import music.is.mylife.vo.Song;

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
	
	@RequestMapping(value="mainPage",method=RequestMethod.GET)
	public String mainPage( Model model) {
		
		int a=1;
		
		String banner = ss.selectBanner(1);
		
		logger.info("Banner : {}", banner);
		
		model.addAttribute("banner", banner);
		
		return "song/mainPage";
	}
}
