package com.smvc.service;

import java.util.List;

import com.smvc.model.City;

public interface ICityService extends IBaseService<City>{
	List<City> queryByName(String name);
}
