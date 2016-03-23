package com.smvc.service;

import java.io.Serializable;
import java.util.List;
public interface IBaseService<T extends Serializable> {
	//id查询
	public T queryById(int id);
	//增加
	public void insert(T t);
	//更新
	public void update(T t);
	//删除
	public void delete(T t);
	//id删除
	public void deleteById(int id);
	//获取全部
	public List<T> queryAll();
}
