package com.WPF.dao;

import com.WPF.domain.UserCompany;
import org.apache.ibatis.annotations.Param;

public interface UserCompanyDao {
	UserCompany selectUserCompanyByUId(@Param("u_id") String u_id);

	int updateUserCompany(UserCompany userCompany);

	int insertUserCompany(UserCompany userCompany);
}
