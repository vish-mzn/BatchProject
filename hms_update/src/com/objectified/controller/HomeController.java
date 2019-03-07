package com.objectified.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.objectified.dao.InterestDBUtil;
import com.objectified.dto.Course;

@Controller
public class HomeController 
{
	@RequestMapping("/courseData")
	public ModelAndView showCourse()
	{
		List<Course> list = new ArrayList<Course>();
		InterestDBUtil hiber = new InterestDBUtil();
		try {
			list = hiber.readCoursedata();
		}
		catch (Exception e) {
		}
		finally {
			hiber.closeEntityManagerFactory();
		}
		if(list.isEmpty() || list == null)
		{
			System.out.println("Vishesh1");
		}
		
		return new ModelAndView("Course", "courseList", list);
	}
	
}
