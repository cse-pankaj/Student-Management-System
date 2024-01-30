package com.sms.controller;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.sms.dao.StudentDao;
import com.sms.dto.Student;

import oracle.jdbc.driver.Message;

public class StudentController extends MultiActionController {
	
	
	private StudentDao stdDao;
	public void setStdDao(StudentDao stdDao) {
		this.stdDao = stdDao;
	}
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr"); 
		Student sto = new Student();
		sto.setSid(sid);
		sto.setSname(sname);
		sto.setSaddr(saddr);
		
		String status = stdDao.addStudent(sto);
		
		ModelAndView mav = null;
		if(status.equals("success")) {
			mav = new ModelAndView("status", "message", "Student Inserted Successfully");
		}
		if(status.equals("failure")) {
			mav = new ModelAndView("status", "message", "Student Inserted Failure");
		}
		if(status.equals("existed")) {
			mav = new ModelAndView("status", "message", "Student Existed Already");
		}
		return mav;
	}
	
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String sid = request.getParameter("sid");
		Student sto = stdDao.search(sid);
		if(sto == null) {
			mav = new ModelAndView("status", "message", "Student Not Existed");
		}else {
			mav = new ModelAndView("studentdetails","sto",sto);
		}
		return mav;
	}
	
	public ModelAndView editform(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String sid = request.getParameter("sid");
		Student sto = stdDao.search(sid);
		if(sto == null) {
			mav = new ModelAndView("status", "message", "Student Not Existed");
		}else {
			mav = new ModelAndView("editform","sto",sto);
			
		}
		return mav;
	}

	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		Student sto = new Student();
		sto.setSid(sid);
		sto.setSname(sname);
		sto.setSaddr(saddr);
		String status = stdDao.update(sto);
		
		
		if(status.equals("success")) {
			mav = new ModelAndView("status","message","Student Updation Success");			
			
		}else {
			mav = new ModelAndView("status","message","Student Updation Failure");
		}
		return mav;
	}
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String sid = request.getParameter("sid");
		String status = stdDao.delete(sid);
		
		if(status.equals("success")) {
			mav= new ModelAndView("status","message","Student Deletion Success");
		}
		if(status.equals("failure")) {
			mav = new ModelAndView("status", "message","Student Deletion Failure");
		}
		if(status.equals("notexisted")) {
			mav = new ModelAndView("status", "message", "Student Not Existed");
			
		}
		return mav;
	}

}
