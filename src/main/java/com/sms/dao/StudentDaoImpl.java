package com.sms.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sms.dto.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	String status = "";
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public String addStudent(Student sto) {
		String query1 = "select * from student where SID = '"+ sto.getSid()+"'";
		List<Student> list = jdbcTemplate.query(query1, (rs,i)->{
			Student std_Entity = new Student();
			std_Entity.setSid(rs.getString("SID"));
			std_Entity.setSname(rs.getString("SNAME"));
			std_Entity.setSaddr(rs.getString("SADDR"));
			return std_Entity;
		});
		if(list.isEmpty()) {
			String query2 = "insert into student values('"+sto.getSid() + "','"+ sto.getSname()+"','"+ sto.getSaddr()+"')";
			int rowCount = jdbcTemplate.update(query2);
			if(rowCount ==1) {
				status = "success";
			}else {
				status = "failure";
			}
		}else {
			status = "existed";
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student sto = null;
		String query = "select * from student where SID = '"+ sid + "'";
		List<Student> list = jdbcTemplate.query(query, (rs,i)->{
			Student std_Entity = new Student();
			std_Entity.setSid(rs.getString("SID"));
			std_Entity.setSname(rs.getString("SNAME"));
			std_Entity.setSaddr(rs.getString("SADDR"));
			return std_Entity;
		});
		if(list.isEmpty()) {
			sto = null;
		}else {
			sto = list.get(0);
		}
		return sto;
	}

	@Override
	public String update(Student sto) {
		String query = "update student set SNAME = '"+sto.getSname()+"', SADDR = '"+sto.getSaddr() +"' where SID = '"+sto.getSid()+"'";
		int rowCount = jdbcTemplate.update(query);
		if(rowCount ==1) {
			status="success";
		}else {
			status="failure";
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String query = "select * from student where SID = '"+ sid + "'";
		List<Student> list = jdbcTemplate.query(query, (rs,i)->{
			Student std_Entity = new Student();
			std_Entity.setSid(rs.getString("SID"));
			std_Entity.setSname(rs.getString("SNAME"));
			std_Entity.setSaddr(rs.getString("SADDR"));
			return std_Entity;
		});
		if(list.isEmpty()) {
			status = "notexisted";
		}else {
			String query1 = "delete from where SID = '"+ sid + "'";
			int rowCount = jdbcTemplate.update(query1);
			if(rowCount ==1) {
				status = "success";
			}else {
				status = "failure";
			}
		}
		return null;
	}

}
