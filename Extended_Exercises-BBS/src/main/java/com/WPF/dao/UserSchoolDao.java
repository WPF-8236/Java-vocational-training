package com.WPF.dao;

import com.WPF.domain.UserBasic;
import com.WPF.domain.UserSchool;
import org.apache.ibatis.annotations.Param;

public interface UserSchoolDao {
	UserSchool selectUserSchoolByUId(@Param("u_id") String u_id);

	int updateUserSchool(UserSchool userSchool);

	int insertUserSchool(UserSchool userSchool);

	int deleteUserByUId(@Param("u_id") String u_id);

}
