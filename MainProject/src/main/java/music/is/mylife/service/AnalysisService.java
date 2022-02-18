package music.is.mylife.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import music.is.mylife.dao.ListDAO;
import music.is.mylife.dao.SongDAO;
import music.is.mylife.dao.UserDAO;
import music.is.mylife.vo.Song;
import music.is.mylife.vo.UserInfo;


@Service
public class AnalysisService {
	//Autowired DAO, 세션(선택)
	@Autowired
	UserService us;
	@Autowired
	ListDAO ld;
	
	//현재 로그인 한 사람의 id를 가지고 유저 정보 불러옴
	public UserInfo selectUser(String user_id) {
		
		return us.selectUser(user_id);
	}
	
	//유저의 평점 수를 구하는 함수
	public HashMap<String, Integer> userGradeInfo(String user_id) {
		
		HashMap<String, Integer> userGradeCount = new HashMap<>();
		
		int listLikeNum = ld.selectListLikesByUser(user_id);
		int listCommentNum = ld.selectListCommentsNumByUser(user_id);
		
		userGradeCount.put("listLikeNum", listLikeNum);
		userGradeCount.put("listCommentNum", listCommentNum);
		
		return userGradeCount;
	}
}
