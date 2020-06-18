package com.qinkuai.javaeefinal.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qinkuai.core.util.TimeUtils;
import com.qinkuai.db.dao.CourseSelectionMapper;
import com.qinkuai.db.dao.HomeworkMapper;
import com.qinkuai.db.dao.StudentMapper;
import com.qinkuai.db.dao.TaskMapper;
import com.qinkuai.db.model.CourseSelection;
import com.qinkuai.db.model.Homework;
import com.qinkuai.db.model.Student;
import com.qinkuai.db.model.Task;

@Controller
public class TeacherController {
	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private CourseSelectionMapper courseSelectionDao;
	@Autowired
	private TaskMapper taskDao;
	@Autowired
	private HomeworkMapper homeworkDao;
	
	@GetMapping("course-detail")
	public String courseDetail(HttpServletRequest request, HttpServletResponse response) {
		String courseId = "RJZ001_01";
		
		List<Student> students = studentDao.selectByCourseId(courseId);
		List<Task> tasks = taskDao.selectByCourseId(courseId); 
		
		
		request.setAttribute("courseId", courseId);
		request.setAttribute("tasks", tasks);
		request.setAttribute("students", students);
		
		return "course-detail";
	}
	
	@GetMapping(value = "/add-student-to-course")
	public void addStudentToCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Student student = studentDao.selectByPrimaryKey(request.getParameter("sid"));
		String cid = request.getParameter("cid");
		
		if (student != null && courseSelectionDao.selectByPrimaryKey(student.getId(), cid) == null) {
			courseSelectionDao.insert(new CourseSelection(student.getId(), cid, 0));
		}
		
		request.setAttribute("courseId", cid);
		response.sendRedirect("course-detail");
	}
	
	@GetMapping(value = "/task-detail")
	public String taskDetail(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("cid", "RJZ001_01");
		int taskId = 1;
		Task task = taskDao.selectByPrimaryKey(taskId);
		List<Homework> homeworks = homeworkDao.selectByTaskId(taskId);
		request.setAttribute("task", task);
		request.setAttribute("homeworks", homeworks);
		return "task-detail";
	}
	
	@GetMapping(value = "/add-task")
	public String addTaskPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("courseId", "RJZ001_01");
		return "add-task";
	}
	
	@PostMapping(value = "/add-task")
	public void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf8");
		Task task = new Task();
		task.setCid(request.getParameter("cid"));
		task.setContent(request.getParameter("content"));
		task.setUploadTime(Calendar.getInstance().getTime());
		try {
			task.setStartTime(TimeUtils.stringToDate(request.getParameter("upload_time")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		task.setTimeLast(Integer.valueOf(request.getParameter("time_last")));
		
		taskDao.insert(task);
		
		response.sendRedirect("course-detail");
	}
}
