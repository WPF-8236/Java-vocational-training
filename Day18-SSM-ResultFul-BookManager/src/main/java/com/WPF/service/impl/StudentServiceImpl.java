package com.WPF.service.impl;

import com.WPF.dao.StudentDao;
import com.WPF.domain.Student;
import com.WPF.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDao studentDao;

	@Override
	public List<Student> getAllStudent() {
		return studentDao.selectAllStudent();
	}
}
