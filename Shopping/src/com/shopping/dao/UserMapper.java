package com.shopping.dao;

import com.shopping.vo.*;
import java.util.*;

public interface UserMapper {
	// 로그인
	public int login(HashMap<String, String> loginMap);
	// 아이디 중복 체크
	public int check_duplicate_id(String id);
	// 회원가입
	public int joinUser(User user);
}
