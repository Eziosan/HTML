package music.is.mylife.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.HomeService;
import music.is.mylife.service.SearchService;
import music.is.mylife.service.UserService;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.UserInfo;

@RequestMapping("search")
@Controller
public class SearchController {

	@Autowired
	SearchService sServ;
	@Autowired
	HomeService hs;
	@Autowired
	UserService us;


	@RequestMapping(value = "searchResult", method = RequestMethod.GET)
	public String search(String searchText, Model model) {
		ArrayList<Song> searchResult1 = sServ.searchSongsBySongName(searchText);
		ArrayList<Song> searchResult2 = sServ.searchSongsBySingerName(searchText);
		
		model.addAttribute("searchText", searchText);
		// 곡명으로 검색 검색 결과
		model.addAttribute("searchResult1", searchResult1);
		// 가수명으로 검색
		model.addAttribute("searchResult2", searchResult2);

		System.out.println(searchText);
		for (Song s : searchResult1) {
			System.out.println(s);
		}
		System.out.println("======================");

		for (Song s : searchResult2) {
			System.out.println(s);
		}

		return "search/searchResult";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String user_id, String user_pw, String searchText, Model model, HttpSession session) {
		
		UserInfo user_info = us.selectUser(user_id);
		
		if (user_info != null && user_info.getUser_pw().equals(user_pw)) {
			session.setAttribute("user_id", user_id);
		}
		
		

		return "redirect:searchResult?searchText=" + searchText;
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Model model, String searchText, UserInfo ui) {
		
		if(us.insertUser(ui)) {
			System.out.println("회원가입 성공!!");
		}else {
			System.out.println("회원가입 실패!");
		}
		
		return "redirect:searchResult?searchText=" + searchText;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model, String searchText) {
		session.invalidate();
		

		return "redirect:searchResult?searchText=" + searchText;
	}

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String search() {
		//정보를 넘겨주기만 하면 됨

		return "search/searchResult";
	}

}
