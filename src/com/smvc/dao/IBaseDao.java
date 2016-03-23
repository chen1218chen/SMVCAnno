package com.smvc.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

public interface IBaseDao<T extends Serializable> {
	//增加
	public void insert(T t);
	//更新
	public void update(T t);
	//删除
	public void delete(T t);
	//增加或更新
	public T merge(T t);
	//根据id加载pojo
	public T queryById(int id);
	//根据id懒加载pojo
	public T loadById(int id);
	//获取全部
	public List<T> queryAll();
	//根据某些字段 获取集合
	public List<T> queryByFields(String fields[],Object values[]);
	//通过字段查询
	public List<T> queryByFieldsStr(String[] fields, String[] values);
	//根据id删除
	public void deleteById(int id);
	//根据pojo类获取的基础sql
	public StringBuffer getBaseSQL();
	//根据sql获取Query
	public Query getQuery(String sql);
}