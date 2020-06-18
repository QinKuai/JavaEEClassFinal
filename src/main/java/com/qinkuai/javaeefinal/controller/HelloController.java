package com.qinkuai.javaeefinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.qinkuai.db.dao.StudentMapper;
import com.qinkuai.db.dao.TeacherMapper;
import com.qinkuai.db.model.Teacher;

@RestController
public class HelloController {
	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private TeacherMapper teacherDao;
	
	@RequestMapping("/hello")
	public String hello() {
		return "welcome to my system demo!";
	}
	
	@RequestMapping("/data")
	public String data() {
		return JSON.toJSONString(studentDao.selectAll());
	}
	
	@RequestMapping("/teacher")
	public String teacher() {
		for (Teacher teacher : teacherDao.selectAll()) {
			System.out.println(teacher);
		}
		return JSON.toJSONString(teacherDao.selectAll());
	}
}
