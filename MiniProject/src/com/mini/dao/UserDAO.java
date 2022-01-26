package com.mini.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mini.vo.UserInfo;

public class UserDAO {
	
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//로그인 처리
	public boolean login(String id, String password) {
		//1. 아이디 비번 입력
		/*
		 * DB에 아이디 비번 조건으로 줘서 해당 아이디와 비밀번호가 맞는지 확인
		 * 맞다 로그인 성공 : 현재 로그인 id 저장 및 
		 */
		try (SqlSession session = factory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			//매개변수를 여러 개(id, 비번)넣어줘야 돼서 map 이용
			HashMap<String, String> ui = new HashMap<String, String>();
			ui.put("user_id", id);
			ui.put("password", password);
			
			//입력된 id, 비밀번호가 DB의 정보와 일치하면 return true
			if(mapper.login(ui) >0) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	//회원가입 처리
	public boolean signUp(UserInfo ui) {
		
		try (SqlSession session = factory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			//ID 중복검사. id가 같은 사람이 있다면 false리턴
			if(mapper.dupulicate_check(ui.getUser_id()) > 0) {
				System.out.println("중복된 아이디가 있습니다!!!");
				return false;
			}
			
			//회원정보를 DB에 넣음
			int result = mapper.signUp(ui);
			session.commit();
			
			//결과가 0이상(insert에 성공)이면 true리턴
			if(result > 0) return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	
}
