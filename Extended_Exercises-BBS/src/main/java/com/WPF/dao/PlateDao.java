package com.WPF.dao;

import com.WPF.domain.Comment;
import com.WPF.domain.Plate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlateDao {
	int insertAPlate(Plate plate);

	List<Plate> selectAllPlate();

	int updatePlateStatus(@Param("p_id") String p_id, @Param("tag") String tag);

	int deletePlateByPId(@Param("p_id") String p_id);

	int updatePlate(Plate plate);

	List<Plate> getPlateListByUId(@Param("u_id") String u_id);

	int updatePlatePPCount(@Param("p_p_id") String p_p_id);

	int updatePlatePCommentCount(Comment comment);
}
