package music.is.mylife.controller;

import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import music.is.mylife.service.UserService;
import music.is.mylife.vo.UserInfo;

@SessionAttributes("userinfo")
@RequestMapping("user")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService us;

	/**
	 * 회원가입 창 보기
	 * @param model
	 * @return joinPopup.jsp
	 */
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join(Model model) {
		
		//세션에 담을 빈 UserInfo 객체
		UserInfo userinfo = new UserInfo();
		
		model.addAttribute("userinfo", userinfo);
		
		return "user/joinPage";
	}
	
	/**
	 * 아이디 중복확인 창 띄우기
	 * @return idCheck.jsp
	 */
	@RequestMapping(value = "idCheck", method = RequestMethod.GET)
	public String idCheck() {
		return "user/idCheck";
	}
	
	/**
	 * 아이디 중복검사 하기
	 * @param searchId
	 * @param model
	 * @return idCheck.jsp
	 */
	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	public String idCheck(String searchId, Model model) {
		logger.debug("searchId : {}", searchId);
		//검색 결과를 변수 idCheck에 담음
		UserInfo idCheck = us.idCheck(searchId);
			
		model.addAttribute("searchId", searchId);
		model.addAttribute("searchResult", idCheck);
		model.addAttribute("search", true);
		
		return "user/idCheck";
	}
	
	/**
	 * 회원가입 처리
	 * @param userinfo
	 * @param model
	 * @return redirect:/
	 */
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute("userinfo") UserInfo userinfo ,Model model) {
		logger.debug("userinfo : {}", userinfo);
		
		//회원가입 처리
		return us.insertUser(userinfo);
	}
	
	/**
	 * 로그인 창 띄우기
	 * @return loginPage
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "user/loginPage";
	}
	
	/**
	 * 로그인 하기
	 * @param user_id
	 * @param user_pw
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String user_id, String user_pw, Model model, HttpSession session) {
		logger.debug("user_id:{}", user_id);
		logger.debug("user_pw:{}", user_pw);
		
		UserInfo user_info = us.selectUser(user_id);
		
		//아이디와 패스워드가 존재할 때 user_id를 넘긴다.
		if(user_info != null && user_info.getUser_pw().equals(user_pw)) {
			session.setAttribute("user_id", user_id);
			return "redirect:/main";
		} else {
			model.addAttribute("errorMsg", "아이디 혹은 비밀번호가 잘못되었습니다.");
			return "user/loginPage";
		}
	}
	
	/**
	 * 로그아웃 하기
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/main";
	}
}
