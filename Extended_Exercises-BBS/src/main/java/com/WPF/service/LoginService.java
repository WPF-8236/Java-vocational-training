package com.WPF.service;

import com.WPF.domain.UserGrade;

public interface LoginService {
	UserGrade login(String u_id, String u_password);
}
