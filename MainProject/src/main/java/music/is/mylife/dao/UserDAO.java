package music.is.mylife.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import music.is.mylife.vo.UserInfo;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession session;

	/* 아이디 중복확인 하기
 	이름: selectIdCheck
 	파라미터 타입: String
 	변수 이름: user_id
 	리턴 타입: UserInfo
	 */
	public UserInfo selectUser(String user_id) {
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//user_info 검색 결과를 변수 idCheck에 담음
		UserInfo idCheck = mapper.selectUser(user_id);
		
		return idCheck;
	}
	
	
	/* 회원가입 하기
	 	이름: insertUser
	 	파라미터 타입: UserInfo
	 	변수 이름: userinfo
	 	리턴 타임: int
	 */
	public int insertUser(UserInfo userinfo) {
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//회원가입 데이터 변수 user에 담음
		int user = mapper.insertUser(userinfo);
		
		return user;
	}
}
