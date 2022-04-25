package com.WPF.service.impl;

import com.WPF.dao.UserBasicDao;
import com.WPF.dao.UserCompanyDao;
import com.WPF.dao.UserInterestDao;
import com.WPF.dao.UserSchoolDao;
import com.WPF.domain.UserBasic;
import com.WPF.domain.UserCompany;
import com.WPF.domain.UserInterest;
import com.WPF.domain.UserSchool;
import com.WPF.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	@Resource
	private UserBasicDao userBasicDao;

	@Resource
	private UserSchoolDao userSchoolDao;

	@Resource
	private UserCompanyDao userCompanyDao;

	@Resource
	private UserInterestDao userInterestDao;

	@Override
	public UserBasic getUserBasicByUId(String u_id) {
		return userBasicDao.selectUserBasicByUId(u_id);
	}

	@Override
	public int updateUserBasic(UserBasic userBasic) {
		if (userBasicDao.selectUserBasicByUId(userBasic.getU_id()) != null)
			return userBasicDao.updateUserBasic(userBasic);
		else
			return userBasicDao.insertUserBasic(userBasic);
	}

	@Override
	public void updateImg(UserBasic userBasic) {
		userBasicDao.updateUserBasicUImg(userBasic);
	}

	@Override
	public UserSchool getUserSchoolByUId(String u_id) {
		return userSchoolDao.selectUserSchoolByUId(u_id);
	}

	@Override
	public int updateUserSchool(UserSchool userSchool) {
		if (userSchoolDao.selectUserSchoolByUId(userSchool.getU_id()) != null)
			return userSchoolDao.updateUserSchool(userSchool);
		else
			return userSchoolDao.insertUserSchool(userSchool);
	}

	@Override
	public UserCompany getUserCompanyByUId(String u_id) {
		return userCompanyDao.selectUserCompanyByUId(u_id);
	}

	@Override
	public int updateUserCompany(UserCompany userCompany) {
		if (userCompanyDao.selectUserCompanyByUId(userCompany.getU_id()) != null)
			return userCompanyDao.updateUserCompany(userCompany);
		else
			return userCompanyDao.insertUserCompany(userCompany);
	}

	@Override
	public List<UserInterest> getUserInterestByUId(String u_id, int u_interest_dislike) {
		if (u_interest_dislike == 0)
			return userInterestDao.selectUserInterestLikeByUId(u_id);
		else
			return userInterestDao.selectUserInterestDislikeByUId(u_id);
	}

	@Override
	public int insertUserInterest(UserInterest userInterest) {
		return userInterestDao.insertUserInterest(userInterest);
	}

	@Override
	public int deleteUserInterestByUInterestId(String u_interest_id) {
		return userInterestDao.deleteUserInterestByUInterestId(u_interest_id);
	}
}
