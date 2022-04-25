package com.WPF.dao;

import com.WPF.domain.UserInterest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInterestDao {
	List<UserInterest> selectUserInterestLikeByUId(@Param("u_id") String u_id);

	List<UserInterest> selectUserInterestDislikeByUId(@Param("u_id") String u_id);

	int deleteUserInterestByUInterestId(@Param("u_interest_id") String u_interest_id);

	int insertUserInterest(UserInterest userInterest);
}
