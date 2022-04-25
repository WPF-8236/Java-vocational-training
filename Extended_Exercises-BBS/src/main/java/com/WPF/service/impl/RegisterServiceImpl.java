package com.WPF.service.impl;

import com.WPF.dao.UserGradeDao;
import com.WPF.domain.UserGrade;
import com.WPF.service.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class RegisterServiceImpl implements RegisterService {
	@Resource
	private UserGradeDao userGradeDao;

	@Override
	public int register(String u_id, String u_password) {
		return userGradeDao.insertAUserGrade(u_id, u_password);
	}

	@Override
	public UserGrade checkUserGrade(String u_id, String u_password) {
		return userGradeDao.selectAUserGrade(u_id, u_password);
	}

	@Override
	public int registerUser(String user_id, String password) {
		return userGradeDao.insertAUserGrade(user_id, password);
	}

}
