package com.smvc.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.smvc.dao.IBaseDao;
import com.smvc.dao.ICityDao;
import com.smvc.model.City;
import com.smvc.service.ICityService;
@Service
public class CityServiceImpl extends BaseServiceImpl<City> implements ICityService{
	@Resource
	private ICityDao cityDaoImpl;
	
	@Override
	public List<City> queryByName(String name) {
		String []fields={"name"};
		String []values={name};
		//Object []values={name};
		return cityDaoImpl.queryByFieldsStr(fields, values);
	}
	@Override
	public IBaseDao<City> getDao() {
		// TODO Auto-generated method stub
		return cityDaoImpl;
	}
}
