package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbctemplates;

	
	public int insert(Student student) {
		//insertion
		String query="insert into student(studentId,studentName,studentCity) values(?,?,?)";
		int r=this.jdbctemplates.update(query,student.getStudentId(),student.getStudentName(),student.getStudentCity());
		return r;
	}

	public int change(Student student) {
		//updation
		String query="update student set studentName=?,studentCity=? where studentId=?";
		int r=this.jdbctemplates.update(query,student.getStudentName(),student.getStudentCity(),student.getStudentId());
		return r;
	}
	public int delete(int studentId) {
		//deletion
		String query="delete from student where studentId=?";
		int r=this.jdbctemplates.update(query,studentId);
		return r;
	}
	public Student getStudent(int sudentId) {
		//selecting single student data
		String query="select * from student where studentId=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbctemplates.queryForObject(query,rowMapper,sudentId);
		return student;
	}
	public List<Student> getAllStudents() {
		// selecting all student details
		String query="select * from student";
		List<Student> students=this.jdbctemplates.query(query,new RowMapperImpl());
		return students;
	}



	
	public JdbcTemplate getJdbctemplates() {
		return jdbctemplates;
	}

	public void setJdbctemplates(JdbcTemplate jdbctemplates) {
		this.jdbctemplates = jdbctemplates;
	}

}
