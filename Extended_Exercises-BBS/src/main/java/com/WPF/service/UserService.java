package com.WPF.service;

import com.WPF.domain.UserBasic;
import com.WPF.domain.UserCompany;
import com.WPF.domain.UserInterest;
import com.WPF.domain.UserSchool;

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
}
