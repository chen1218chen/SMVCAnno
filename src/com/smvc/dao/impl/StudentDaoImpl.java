package com.smvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.smvc.dao.IStudentDao;
import com.smvc.model.Student;
@Repository
public class StudentDaoImpl extends BaseDaoImpl<Student> implements IStudentDao{
	public StudentDaoImpl() {
		super(Student.class);
	}
}
