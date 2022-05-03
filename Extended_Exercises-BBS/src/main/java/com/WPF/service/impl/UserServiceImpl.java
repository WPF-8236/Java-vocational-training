package com.WPF.service.impl;

import com.WPF.dao.*;
import com.WPF.domain.*;
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

	@Resource
	private UserGradeDao userGradeDao;

	@Resource
	private PlateDao plateDao;

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

	@Override
	public int updateUserPassword(String u_id, String u_password) {
		return userGradeDao.updateUserPassword(u_id, u_password);
	}

	@Override
	public int updateUserPhone(String u_id, String u_phone) {
		return userBasicDao.updateUserPhone(u_id, u_phone);
	}

	public int updateUserEmail(String u_id, String u_email) {
		return userBasicDao.updateUserEmail(u_id, u_email);
	}

	@Override
	public int deleteUserByUId(String u_id) {
		return userBasicDao.deleteUserByUId(u_id) * userGradeDao.deleteUserByUId(u_id) * userInterestDao.deleteUserByUId(u_id) * userCompanyDao.deleteUserByUId(u_id) * userSchoolDao.deleteUserByUId(u_id);
	}

	@Override
	public List<Plate> getPlateListByUId(String u_id) {
		return plateDao.getPlateListByUId(u_id);
	}

	@Override
	public int addAPlate(Plate plate) {
		return plateDao.insertAPlate(plate);
	}
}
