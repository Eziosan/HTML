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
	@Autowired
	SongService ss;

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
		int song_id = 4;
		double star = 3.5; 
		String genre = "댄스";
		int singer_id = 3;
		String country ="대한민국";
		
		//
		UserLog ul = new UserLog();
		ul.setUser_id(user_id);
		ul.setSong_id(song_id);
		ul.setStar(star);
		ul.setGenre(genre);
		ul.setSinger_id(singer_id);
		ul.setCountry(country);
		
		ss.recordUserLog(ul);
		
		return "analysis/analysisPage";
	}
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(Song song, Model model, HttpSession session) {
		
		//String user_id = (String)session.getAttribute("user_id");
		//로그인이 안됨
		//System.out.println("user id : " + user_id);
		
		//유저 id가 aaaa인 유저를 가져옴
		UserInfo u_info = as.selectUser("aaaa");
		
		HashMap<String, Double> userGradeList = as.userGradeInfo("aaaa");
		ArrayList<String> tagNameList = as.selectTop10TagByUser("aaaa");
		ArrayList<Singer> singerList = as.selectTop3SingerByUser("aaaa");
		ArrayList<UserLog> genreLogList = as.selectTop3GenreByUser("aaaa");
		ArrayList<UserLog> countryLogList = as.selectTop3CountryByUser("aaaa");
		

		model.addAttribute("u_info", u_info);
		model.addAttribute("userGradeList", userGradeList);
		model.addAttribute("tagNameList", tagNameList);
		model.addAttribute("singerList", singerList);
		model.addAttribute("genreLogList", genreLogList);
		model.addAttribute("countryLogList", countryLogList);
		
		return "analysis/main";
	}
	
	



	
}
