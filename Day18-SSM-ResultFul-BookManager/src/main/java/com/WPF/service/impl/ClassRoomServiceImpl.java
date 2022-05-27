package com.WPF.service.impl;

import com.WPF.dao.ClassRoomDao;
import com.WPF.domain.ClassRoom;
import com.WPF.service.ClassRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
	@Resource
	private ClassRoomDao classRoomDao;

	@Override
	public List<ClassRoom> getAllClassRoom() {
		return classRoomDao.selectAllClassRoom();
	}
}
