package com.WPF.dao;

import com.WPF.domain.UserGrade;
import org.apache.ibatis.annotations.Param;

public interface UserGradeDao {
	UserGrade selectAUserGrade(@Param("u_id") String u_id, @Param("u_password") String u_password);

	int insertAUserGrade(@Param("u_id") String u_id, @Param("u_password") String u_password);
}
