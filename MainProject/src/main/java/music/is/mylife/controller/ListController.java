package music.is.mylife.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String listPage(Song song, Model model, int playlist_id, ListComment listReply) {
		
		//리스트에 필요한 정보들 넘겨주기
		ArrayList<Playlist> banner = ls.listBanner(playlist_id);
		ArrayList<Playlist> listSong = ls.listSong(playlist_id);
		Playlist info = ls.listInfo(playlist_id);
		Song selectSong = ss.selectAllSong(song);
		
		//좋아요수, 댓글수, 곡 수 카운팅 정보
		int count = ls.countSong(playlist_id);
		int countComment = ls.countComment(playlist_id);
		Playlist like = ls.listLike(playlist_id); 
		//댓글 전체 출력 검색
		ArrayList<ListComment> list = ls.listComment(playlist_id);
		
			
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
		//리스트 좋아요 수
		model.addAttribute("listLike", like);
		//전체 곡 정보 
		model.addAttribute("allSong", selectSong);
		//리스트 아이디
		model.addAttribute("playlist_id", info.getPlaylist_id());
		//댓글 전체출력
		model.addAttribute("allList", list);
		
		return "list/listpage";
	}
	
	/**
	 * 리스트페이지에서 로그인
	 * @param user_id
	 * @param user_pw
	 * @param model
	 * @param session
	 * @param playlist_id
	 * @param song
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String user_id, String user_pw, Model model, HttpSession session, int playlist_id, Song song) {
		UserInfo user_info = us.selectUser(user_id);
		
		if(user_info != null && user_info.getUser_pw().equals(user_pw)) {
			session.setAttribute("user_id", user_id);
		}
		
		//리스트에 필요한 정보들 넘겨주기
		ArrayList<Playlist> banner = ls.listBanner(playlist_id);
		ArrayList<Playlist> listSong = ls.listSong(playlist_id);
		Playlist info = ls.listInfo(playlist_id);
		Song selectSong = ss.selectAllSong(song);
		
		int count = ls.countSong(playlist_id);
		int countComment = ls.countComment(playlist_id);
		Playlist like = ls.listLike(playlist_id); 
		//댓글 전체 출력 검색
	    ArrayList<ListComment> list = ls.listComment(playlist_id);
		
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
		//리스트 좋아요 수
		model.addAttribute("listLike", like);
		//전체 곡 정보 
		model.addAttribute("allSong", selectSong);
		//리스트 아이디
		model.addAttribute("playlist_id", info.getPlaylist_id());
		//댓글 전체출력
		model.addAttribute("allList", list);
		
		return "list/listpage";
	}
	
	/**
	 * 리스트 페이지에서 로그아웃
	 * @param session
	 * @param song
	 * @param model
	 * @param playlist_id
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Song song, Model model, int playlist_id) {
		session.invalidate();
		
		//리스트에 필요한 정보들 넘겨주기
		ArrayList<Playlist> banner = ls.listBanner(playlist_id);
		ArrayList<Playlist> listSong = ls.listSong(playlist_id);
		Playlist info = ls.listInfo(playlist_id);
		Song selectSong = ss.selectAllSong(song);
		
		int count = ls.countSong(playlist_id);
		int countComment = ls.countComment(playlist_id);
		Playlist like = ls.listLike(playlist_id); 
		//댓글 전체 출력 검색
		ArrayList<ListComment> list = ls.listComment(playlist_id);
				
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
		//리스트 좋아요 수
		model.addAttribute("listLike", like);
		//전체 곡 정보 
		model.addAttribute("allSong", selectSong);
		//리스트 아이디
		model.addAttribute("playlist_id", info.getPlaylist_id());
		//댓글 전체출력
		model.addAttribute("allList", list);
		
		
		return "list/listpage";
	}
	
	/**
	 * 리스트 페이지에서 회원가입
	 * @param userinfo
	 * @param model
	 * @param song
	 * @param playlist_id
	 * @return
	 */
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute("userinfo") UserInfo userinfo ,Model model, Song song, int playlist_id) {
		//리스트에 필요한 정보들 넘겨주기
		ArrayList<Playlist> banner = ls.listBanner(playlist_id);
		ArrayList<Playlist> listSong = ls.listSong(playlist_id);
		Playlist info = ls.listInfo(playlist_id);
		Song selectSong = ss.selectAllSong(song);
						
		int count = ls.countSong(playlist_id);
		int countComment = ls.countComment(playlist_id);
		Playlist like = ls.listLike(playlist_id); 
		//댓글 전체 출력 검색
		ArrayList<ListComment> list = ls.listComment(playlist_id);
						
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
		//리스트 좋아요 수
		model.addAttribute("listLike", like);
		//전체 곡 정보 
		model.addAttribute("allSong", selectSong);
		//리스트 아이디
		model.addAttribute("playlist_id", info.getPlaylist_id());
		//댓글 전체출력
		model.addAttribute("allList", list);
		
		return ss.insertListUser(userinfo);
	}
	
	/**
	 * 리스트 좋아요 올리고 내리기
	 * @param playlist_id
	 * @param model
	 * @param song
	 * @return
	 */
	@RequestMapping(value = "like", method = RequestMethod.POST)
	public String listLike(int playlist_id, Model model, Song song) {
		int plusLike = ls.plusListLike(playlist_id);
		
		//리스트에 필요한 정보들 넘겨주기
		ArrayList<Playlist> banner = ls.listBanner(playlist_id);
		ArrayList<Playlist> listSong = ls.listSong(playlist_id);
		Playlist info = ls.listInfo(playlist_id);
		Song selectSong = ss.selectAllSong(song);
								
		int count = ls.countSong(playlist_id);
		int countComment = ls.countComment(playlist_id);
		Playlist like = ls.listLike(playlist_id); 
		//댓글 전체 출력 검색
		ArrayList<ListComment> list = ls.listComment(playlist_id);
								
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
		//리스트 좋아요 수
		model.addAttribute("listLike", like);
		//전체 곡 정보 
		model.addAttribute("allSong", selectSong);
		//리스트 아이디
		model.addAttribute("playlist_id", info.getPlaylist_id());
		//댓글 전체출력
		model.addAttribute("allList", list);
		
		
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
	public String insetComment(int playlist_id ,String comment, Model model, Song song , ListComment reply, HttpSession session,
			ListComment listReply) {
	
		// 세션에서 로그인한 사용자 아이디 받아 저장
		String loginId = (String)session.getAttribute("user_id");
		reply.setUser_id(loginId);
		
		//댓글 입력
		int listRelpy = ls.insertCommnet(reply);
		
		//리스트에 필요한 정보들 넘겨주기
		ArrayList<Playlist> banner = ls.listBanner(playlist_id);
		ArrayList<Playlist> listSong = ls.listSong(playlist_id);
		Playlist info = ls.listInfo(playlist_id);
		Song selectSong = ss.selectAllSong(song);
										
		int count = ls.countSong(playlist_id);
		int countComment = ls.countComment(playlist_id);
		Playlist like = ls.listLike(playlist_id); 
		//댓글 전체 출력 검색
		ArrayList<ListComment> list = ls.listComment(playlist_id);
		
		
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
		//리스트 좋아요 수
		model.addAttribute("listLike", like);
		//전체 곡 정보 
		model.addAttribute("allSong", selectSong);
		//리스트 아이디
		model.addAttribute("playlist_id", info.getPlaylist_id());		
		//댓글 전체출력
		model.addAttribute("allList", list);
		
		
		
		
		//return "redirect:/list/listpage?playlist_id=" + reply.getPlaylist_id();
		return "list/listpage";
	}
	
	@RequestMapping(value = "delComment", method = RequestMethod.POST)
	public String deleteComment(HttpSession session, ListComment delComment, Song song, int playlist_id, Model model) {
		String loginId = (String)session.getAttribute("user_id");
		delComment.setUser_id(loginId);
		logger.info("delComment:{}",delComment);
		//댓글 삭제
		int commentDel = ls.deleteComment(delComment);
		
		//리스트에 필요한 정보들 넘겨주기
		ArrayList<Playlist> banner = ls.listBanner(playlist_id);
		ArrayList<Playlist> listSong = ls.listSong(playlist_id);
		Playlist info = ls.listInfo(playlist_id);
		Song selectSong = ss.selectAllSong(song);
												
		int count = ls.countSong(playlist_id);
		int countComment = ls.countComment(playlist_id);
		Playlist like = ls.listLike(playlist_id); 
		//댓글 전체 출력 검색
		ArrayList<ListComment> list = ls.listComment(playlist_id);
				
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
		//리스트 좋아요 수
		model.addAttribute("listLike", like);
		//전체 곡 정보 
		model.addAttribute("allSong", selectSong);
		//리스트 아이디
		model.addAttribute("playlist_id", info.getPlaylist_id());		
		//댓글 전체출력
		model.addAttribute("allList", list);
		
		return "list/listpage";
	}

}
