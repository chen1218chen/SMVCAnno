package com.smvc.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.smvc.dao.IBaseDao;
import com.smvc.model.Student;
import com.smvc.service.IBaseService;

@Transactional
public abstract class BaseServiceImpl<T extends Serializable> implements IBaseService<T>{
	public abstract IBaseDao<T> getDao();
	//id查询
	public T queryById(int id) {
		// TODO Auto-generated method stub
		return getDao().queryById(id);
	}
	//增加
	public void insert(T t)
	{
		getDao().insert(t);
	}
	//更新
	public void update(T t)
	{
		getDao().update(t);
	}
	//删除
	public void delete(T t)
	{
		getDao().delete(t);
	}
	//id删除
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		getDao().deleteById(id);
	}
	public List<T> queryAll() {
		// TODO Auto-generated method stub
		return getDao().queryAll();
	}
}
