package com.WPF.dao;

import com.WPF.domain.UserList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserListDao {
	List<UserList> selectAllUser();

	List<UserList> selectUserByUId(@Param("input") String input);

	List<UserList> selectUserByUName(@Param("input") String input);

	List<UserList> selectUserByUGrade();
}
