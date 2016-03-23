package com.smvc.service;

import java.util.List;

import com.smvc.model.Student;

public interface IStudentService extends IBaseService<Student>{
	public String getName();
	public List<Student> queryByName(String name);
}
