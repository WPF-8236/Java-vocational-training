package com.WPF.service.impl;

import com.WPF.dao.UserGradeDao;
import com.WPF.domain.UserGrade;
import com.WPF.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {
	@Resource
	private UserGradeDao userGradeDao;

	@Override
	public UserGrade login(String u_id, String u_password) {
		return userGradeDao.selectAUserGrade(u_id, u_password);
	}
}
