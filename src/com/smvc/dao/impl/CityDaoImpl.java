package com.smvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.smvc.dao.ICityDao;
import com.smvc.model.City;

@Repository
public class CityDaoImpl extends BaseDaoImpl<City> implements ICityDao{
	public CityDaoImpl() {
		super(City.class);
	}
}
