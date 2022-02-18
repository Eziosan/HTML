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
import music.is.mylife.service.SongService;
import music.is.mylife.vo.Song;

@RequestMapping("analysis")
@Controller
public class AnalysisController {

	private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);
	
	@Autowired
	SongService ss;
	

	
	/**
	 * 1. 조회수 상위 5개의 곡 값을 main.jsp에 넘기기
	 * 2. 좋아요 상위 5개의 곡 값을 main.jsp에 넘기기
	 * @param song
	 * @param model
	 * @return main.jsp
	 */
	@RequestMapping(value = "analysisPage", method = RequestMethod.GET)
	public String analysisPage(Song song, Model model) {
		
		return "analysis/analysisPage";
	}
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(Song song, Model model) {
		
		return "analysis/analysisPage";
	}
	
	



	
}
