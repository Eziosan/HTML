package com.shopping.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shopping.vo.User;
import java.util.*;

public class UserDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public boolean login(String user_id, String passwd) {
		boolean result = false;
		
		try (SqlSession session = factory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			HashMap<String, String> loginMap = new HashMap<>();
			loginMap.put("user_id", user_id);
			loginMap.put("passwd", passwd);
			
			int cnt = mapper.login(loginMap);
			
			if (cnt > 0) {
				result = true;
			} 
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return result;
	}
	
	public boolean check_duplicate_id(String id) {
		boolean result = false;
		
		try (SqlSession session = factory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			if (mapper.check_duplicate_id(id) < 1) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean joinUser(User user) {
		boolean result = false;
		
		try (SqlSession session = factory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			if (mapper.joinUser(user) > 0) {
				result = true;
			}
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
