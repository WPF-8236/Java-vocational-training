package com.WPF.service;

import com.WPF.domain.UserGrade;

public interface RegisterService {
	int register(String u_id, String u_password);

	UserGrade checkUserGrade(String u_id, String u_password);

	int registerUser(String user_id, String password);
}
