package com.WPF.dao;

import com.WPF.domain.UserBasic;
import org.apache.ibatis.annotations.Param;

public interface UserBasicDao {
	UserBasic selectUserBasicByUId(@Param("u_id") String u_id);

	int updateUserBasic(UserBasic userBasic);

	int insertUserBasic(UserBasic userBasic);

	void updateUserBasicUImg(UserBasic userBasic);
}
