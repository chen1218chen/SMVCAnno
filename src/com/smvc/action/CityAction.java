package com.smvc.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smvc.service.ICityService;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.common.GeoTool;
import com.smvc.model.City;
import com.smvc.model.Student;


/**
 * @ClassName: CityAction 
 * @Description: SpringMVC框架测试
 * @author chenchen
 * @date 2015-12-20 上午10:51:26
 */
@Controller
@RequestMapping("/city")
public class CityAction{
	@Resource
	private ICityService cityServiceImpl;
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public City getById(@PathVariable int id)
	{
		City city=cityServiceImpl.queryById(id);
		city.setCoord(city.getGeom().toString());
		return city;
	}
	@RequestMapping(value = "/getByName", method = RequestMethod.GET)
	@ResponseBody
	public List<City> getByName(@RequestParam String name)
	{
		try {
			name= new String(name.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<City> cityList=cityServiceImpl.queryByName(name);
		for(City city:cityList)
		{
			city.setCoord(city.getGeom().toString());
		}
		return cityList;
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<City> getAll()
	{
		List<City> cityList=cityServiceImpl.queryAll();
		for(City city:cityList)
		{
			city.setCoord(city.getGeom().toString());
		}
		return cityList;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@ModelAttribute City city)
	{
		if(city!=null)
		{
			Point pt=GeoTool.createPoint(city.getCoord());
			if(pt!=null)
			{
				city.setGeom(pt);
				cityServiceImpl.insert(city);	
			}
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute City city)
	{
		if(city!=null)
		{
			Point pt=GeoTool.createPoint(city.getCoord());
			if(pt!=null)
			{
				city.setGeom(pt);
				cityServiceImpl.update(city);	
			}
		}
	}
	
	@RequestMapping(value = "/deleteByID/{id}", method = RequestMethod.DELETE)
	public void deleteByID(@PathVariable int id)
	{
		cityServiceImpl.deleteById(id);
	}
}
