package com.shopping.dao;

import com.shopping.vo.*;
import java.util.*;

public interface UserMapper {
	// �α���
	public int login(HashMap<String, String> loginMap);
	// ���̵� �ߺ� üũ
	public int check_duplicate_id(String id);
	// ȸ������
	public int joinUser(User user);
}
