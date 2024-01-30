package com.sms.dao;

import com.sms.dto.Student;

public interface StudentDao {
	public String addStudent(Student sto);
	public Student search(String sid);
	public String update(Student sto);
	public String delete(String sid);
}
