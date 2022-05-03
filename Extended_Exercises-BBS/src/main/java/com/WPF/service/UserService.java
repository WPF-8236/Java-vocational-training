package com.WPF.service;

import com.WPF.domain.*;

import java.util.List;

public interface UserService {
	UserBasic getUserBasicByUId(String u_id);

	int updateUserBasic(UserBasic userBasic);

	void updateImg(UserBasic userBasic);

	UserSchool getUserSchoolByUId(String u_id);

	int updateUserSchool(UserSchool userSchool);

	UserCompany getUserCompanyByUId(String u_id);

	int updateUserCompany(UserCompany userCompany);

	List<UserInterest> getUserInterestByUId(String u_id, int u_interest_dislike);

	int insertUserInterest(UserInterest userInterest);

	int deleteUserInterestByUInterestId(String u_interest_id);

	int updateUserPassword(String u_id, String u_password);

	int updateUserPhone(String u_id, String u_phone);

	int updateUserEmail(String u_id, String u_email);

	int deleteUserByUId(String u_id);

	List<Plate> getPlateListByUId(String u_id);

	int addAPlate(Plate plate);
}
