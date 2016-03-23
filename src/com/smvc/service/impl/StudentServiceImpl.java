package com.smvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.smvc.dao.IBaseDao;
import com.smvc.dao.IStudentDao;
import com.smvc.model.Student;
import com.smvc.service.IStudentService;
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements IStudentService{
	@Resource
	private IStudentDao studentDaoImpl;
	@Override
	public String getName() {
		return studentDaoImpl.queryById(1).getName();
	}
	@Override
	public List<Student> queryByName(String name) {
		String []fields={"name"};
		String []values={name};
		//Object []values={name};
		return studentDaoImpl.queryByFieldsStr(fields, values);
	}
	@Override
	public IBaseDao<Student> getDao() {
		// TODO Auto-generated method stub
		return studentDaoImpl;
	}
}
