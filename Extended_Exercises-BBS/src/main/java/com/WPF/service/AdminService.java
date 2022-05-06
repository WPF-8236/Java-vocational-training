package com.WPF.service;

import com.WPF.domain.Plate;
import com.WPF.domain.UserList;

import java.util.List;

public interface AdminService {
	List<UserList> getUserList();

	int changeUGrade(String u_id, String tag);

	int changeUStatus(String u_id, String tag);

	int updateAUser(String u_id, String u_name, String u_password);

	List<UserList> getUserList(String input, String select);

	int addAPlate(Plate plate);

	List<Plate> getPlateList();

	List<UserList> getModerator();

	int changePStatus(String p_id, String tag);

	int removePlate(String p_id);

	int updateAPlate(Plate plate);

	int removePost(String p_id);

	int changePostStatus(String p_id, String tag);
}
