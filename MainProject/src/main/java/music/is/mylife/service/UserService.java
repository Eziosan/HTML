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
	 * 회원가입 처리
	 * @param userinfo
	 * @return
	 */
	public boolean insertUser(UserInfo userinfo) {
		
		//회원가입 처리
		int join = userDao.insertUser(userinfo);
		
		if(join > 0) {
			return true;
		}else {return false;}
//		if(join != 1) {
//			return "redirect:/main";
//		}
//		return "redirect:/main";
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
