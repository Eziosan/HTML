package music.is.mylife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import music.is.mylife.dao.UserDAO;
import music.is.mylife.vo.UserInfo;


@Service
public class UserService {
	@Autowired
	UserDAO userDao;
	
	/**
	 * 아이디 중복 검사
	 * @param searchId
	 * @return
	 */
	public UserInfo idCheck(String searchId) {

		//검색 결과를 변수 idCheck에 담음
		UserInfo idCheck = userDao.selectUser(searchId);
		
		return idCheck;
	}
	
	/**
	 * 회원가입 처리
	 * @param userinfo
	 * @return
	 */
	public String insertUser(UserInfo userinfo) {
		
		//회원가입 처리
		int join = userDao.insertUser(userinfo);
		
		if(join != 1) {
			return "user/joinPage";
		}
		return "redirect:/";
	}
	
	/**
	 * 로그인 하기
	 * @param user_id
	 * @return
	 */
	public UserInfo selectUser(String user_id) {
		
		UserInfo user_info = userDao.selectUser(user_id);
		
		return user_info;
	}
}
