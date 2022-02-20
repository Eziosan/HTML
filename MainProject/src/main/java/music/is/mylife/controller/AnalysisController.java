package music.is.mylife.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.AnalysisService;
import music.is.mylife.service.HomeService;
import music.is.mylife.service.SongService;
import music.is.mylife.vo.Singer;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.Tag;
import music.is.mylife.vo.UserInfo;
import music.is.mylife.vo.UserLog;

@RequestMapping("analysis")
@Controller
public class AnalysisController {

	private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);
	
	@Autowired
	AnalysisService as;

	/*
	 * 모델로 넘길 정보
	 * 1. 유저
	 * 2. 리스트
	 * 3. 유저 로그 정보
	 */
	@RequestMapping(value = "analysisPage", method = RequestMethod.GET)
	public String analysisPage(Model model, HttpSession session) {
		System.out.println("별점 입력 했습니다!!");
		String user_id = (String)session.getAttribute("user_id");
		int song_id;
		double star; 
		String genre;
		String singer_id;
		String country;
		
		
		return "analysis/analysisPage";
	}
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(Song song, Model model, HttpSession session) {
		
		String user_id = (String)session.getAttribute("user_id");
		//로그인이 안됨
		System.out.println("user id : " + user_id);
		
		//유저 id가 aaaa인 유저를 가져옴
		UserInfo u_info = as.selectUser("aaaa");
		
		HashMap<String, Integer> userGradeList = as.userGradeInfo(user_id);
		HashMap<String, Double> userStarCount = as.userStarInfo(user_id);
		ArrayList<String> tagNameList = as.selectTop10TagByUser(user_id);
		ArrayList<Singer> singerList = as.selectTop3SingerByUser(user_id);
		ArrayList<UserLog> genreLogList = as.selectTop3GenreByUser(user_id);
		ArrayList<UserLog> countryLogList = as.selectTop3CountryByUser(user_id);
		

		model.addAttribute("u_info", u_info);
		model.addAttribute("userGradeList", userGradeList);
		model.addAttribute("userStarCount", userStarCount);
		model.addAttribute("tagNameList", tagNameList);
		model.addAttribute("singerList", singerList);
		model.addAttribute("genreLogList", genreLogList);
		model.addAttribute("countryLogList", countryLogList);
		
		return "analysis/main";
	}
	
	



	
}
