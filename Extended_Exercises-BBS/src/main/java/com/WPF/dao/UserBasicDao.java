package com.WPF.dao;

import com.WPF.domain.UserBasic;
import org.apache.ibatis.annotations.Param;

public interface UserBasicDao {
	UserBasic selectUserBasicByUId(@Param("u_id") String u_id);

	int updateUserBasic(UserBasic userBasic);

	int insertUserBasic(UserBasic userBasic);

	void updateUserBasicUImg(UserBasic userBasic);

	int updateUserPhone(@Param("u_id") String u_id, @Param("u_phone") String u_phone);

	int updateUserEmail(@Param("u_id") String u_id, @Param("u_email") String u_email);

	int deleteUserByUId(@Param("u_id") String u_id);

	int updateUserName(@Param("u_id") String u_id, @Param("u_name") String u_name);
}
