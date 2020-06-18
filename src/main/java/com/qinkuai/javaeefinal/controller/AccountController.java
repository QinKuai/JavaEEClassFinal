package com.qinkuai.javaeefinal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qinkuai.db.dao.StudentMapper;
import com.qinkuai.db.dao.TeacherMapper;
import com.qinkuai.db.model.Student;
import com.qinkuai.db.model.Teacher;

@Controller
public class AccountController {
	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private TeacherMapper teacherDao;
	
	@GetMapping("login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userType = request.getParameter("type");
		String username = request.getParameter("username");
		if("student".equals(userType)) {
			Student student = studentDao.selectByPrimaryKey(username);
			if(student != null && student.getPassword().equals(request.getParameter("password"))) {
				response.sendRedirect("homework-detail");
				
			}
		}else {
			Teacher teacher = teacherDao.selectByPrimaryKey(username);
			if(teacher != null && teacher.getPassword().equals(request.getParameter("password"))) {
				response.sendRedirect("task-detail");
			}
		}
	}
	
	@GetMapping("register")
	public String getRegister() {
		return "register";
	}
	
	@PostMapping("register")
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String userType = request.getParameter("type");
		if("student".equals(userType)) {
			Student student = new Student();
			student.setId(request.getParameter("username"));
			student.setUsername(request.getParameter("username"));
			student.setPassword(request.getParameter("password"));
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));
			student.setSex(request.getParameter("sex"));
			student.setClassName("1703");
			student.setGrade("U3");
			if(studentDao.selectByPrimaryKey(request.getParameter("username")) == null) {
				studentDao.insert(student);
			}
		}else if("teacher".equals(userType)){
			Teacher teacher = new Teacher();
			teacher.setId(request.getParameter("username"));
			teacher.setUsername(request.getParameter("username"));
			teacher.setPassword(request.getParameter("password"));
			teacher.setFirstName(request.getParameter("firstName"));
			teacher.setLastName(request.getParameter("lastName"));
			teacher.setSex(request.getParameter("sex"));
			if(teacherDao.selectByPrimaryKey(request.getParameter("username")) == null) {
				teacherDao.insert(teacher);
			}
		}
		
		response.sendRedirect("login");
	}
}
