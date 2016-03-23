package com.smvc.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smvc.service.IStudentService;
import com.smvc.model.Student;


/**
 * @ClassName: StudentAction 
 * @Description: SpringMVC框架测试
 * @author chenchen
 * @date 2015-10-26 下午9:56:26
 */
@Controller
@RequestMapping("/student")
public class StudentAction{
	@Resource
	private IStudentService studentServiceImpl;
	
	@RequestMapping(value = "/demoAction")
	public String demoAction(){
		System.out.println(studentServiceImpl.getName());
		return "redirect:/success.jsp";
	}
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Student getById(@PathVariable int id)
	{
		Student student=studentServiceImpl.queryById(id);
		return student;
	}
	
	@RequestMapping(value = "/getByName", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getByName(@RequestParam String name)
	{
		List<Student> stdList=studentServiceImpl.queryByName(name);
		return stdList;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getAll()
	{
		List<Student> stdList=studentServiceImpl.queryAll();
		return stdList;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@ModelAttribute Student stu)
	{
		if(stu!=null)
		{
			System.out.println("...............");
			System.out.println(stu.getId());
			studentServiceImpl.insert(stu);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute Student stu)
	{
		if(stu!=null)
		{
			studentServiceImpl.update(stu);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@ModelAttribute Student stu)
	{
		studentServiceImpl.delete(stu);
	}
	
	@RequestMapping(value = "/deleteByID/{id}", method = RequestMethod.DELETE)
	public void deleteByID(@PathVariable int id)
	{
		studentServiceImpl.deleteById(id);
	}
}
