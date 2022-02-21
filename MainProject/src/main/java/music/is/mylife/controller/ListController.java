package music.is.mylife.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.dao.SongDAO;
import music.is.mylife.service.ListService;
import music.is.mylife.service.SongService;
import music.is.mylife.service.UserService;
import music.is.mylife.vo.ListComment;
import music.is.mylife.vo.Playlist;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.UserInfo;

@RequestMapping("list")
@Controller
public class ListController {
	private static final Logger logger = LoggerFactory.getLogger(ListController.class);
	
	@Autowired
	ListService ls;
	
	@Autowired
	SongService ss;
	
	@Autowired
	UserService us;
	/**
	 * song/mainPage에서 리스트 페이지로 화면이동
	 * @return
	 */
	@RequestMapping(value = "listPage", method = RequestMethod.GET)
	public String listPage(Song song, Model model, int playlist_id) {
		
		ArrayList<Playlist> banner = ls.listBanner(playlist_id);
		ArrayList<Playlist> listSong = ls.listSong(playlist_id);
		Playlist info = ls.listInfo(playlist_id);
		int count = ls.countSong(playlist_id);
		int countComment = ls.countComment(playlist_id);
		
		logger.info("banner:{}",banner);
		logger.info("listSong:{}",listSong);
		logger.info("info:{}", info);
		
				
		//리스트 정보
		model.addAttribute("listInfo", info);
		//배너 사진
		model.addAttribute("banner", banner);
		//곡 정보
		model.addAttribute("listSong", listSong);
		//리스트 곡 개수
		model.addAttribute("countSong", count);
		//리스트 댓글 개수
		model.addAttribute("countComment", countComment);
		
		
		return "list/listpage";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String user_id, String user_pw, Model model, HttpSession session, int playlist_id) {
		UserInfo user_info = us.selectUser(user_id);
		
		if(user_info != null && user_info.getUser_pw().equals(user_pw)) {
			session.setAttribute("user_id", user_id);
		}
		
		logger.debug("playlist_id:{}", playlist_id);
		//해당 리스트 모든 정보 검색
		ArrayList<Playlist> onelist = ls.oneList(playlist_id);
		
		model.addAttribute("onelist", onelist);
		
		return "list/listpage";
	}
	
	/**
	 * 리스트 댓글 입력하기
	 * @param comment
	 * @param model
	 * @param reply
	 * @return
	 */
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	public String comment(String comment, Model model, ListComment reply) {
		int listRelpy = ls.insertCommnet(reply);
		
		return "list/listPage";
	}

}
