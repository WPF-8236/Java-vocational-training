package com.WPF.service.impl;

import com.WPF.dao.*;
import com.WPF.domain.Plate;
import com.WPF.domain.UserList;
import com.WPF.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
	@Resource
	private UserListDao userListDao;

	@Resource
	private UserBasicDao userBasicDao;

	@Resource
	private UserSchoolDao userSchoolDao;

	@Resource
	private UserCompanyDao userCompanyDao;

	@Resource
	private UserInterestDao userInterestDao;

	@Resource
	private PlateDao plateDao;

	@Resource
	private UserGradeDao userGradeDao;

	@Override
	public List<UserList> getUserList() {
		return userListDao.selectAllUser();
	}

	@Override
	public int changeUGrade(String u_id, String tag) {
		return userGradeDao.updateUserGrade(u_id, tag);
	}

	@Override
	public int changeUStatus(String u_id, String tag) {
		return userGradeDao.updateUserStatus(u_id, tag);
	}

	@Override
	public int updateAUser(String u_id, String u_name, String u_password) {
		return userGradeDao.updateUserPassword(u_id, u_password) * userBasicDao.updateUserName(u_id, u_name);
	}

	@Override
	public List<UserList> getUserList(String input, String select) {
		if ("1".equals(select))
			return userListDao.selectUserByUId(input);
		else if ("2".equals(select))
			return userListDao.selectUserByUName(input);
		else
			return userListDao.selectAllUser();
	}

	@Override
	public int addAPlate(Plate plate) {
		return plateDao.insertAPlate(plate);
	}

	@Override
	public List<Plate> getPlateList() {
		return plateDao.selectAllPlate();
	}

	@Override
	public List<UserList> getModerator() {
		return userListDao.selectUserByUGrade();
	}

	@Override
	public int changePStatus(String p_id, String tag) {
		return plateDao.updatePlateStatus(p_id, tag);
	}

	@Override
	public int removePlate(String p_id) {
		return plateDao.deletePlateByPId(p_id);
	}

	@Override
	public int updateAPlate(Plate plate) {
		return plateDao.updatePlate(plate);
	}
}
