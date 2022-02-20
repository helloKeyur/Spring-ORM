package com.kdvamja.springorm.dao;

import java.util.List;

import com.kdvamja.springorm.entity.Student;

public interface StudentDao {
	
	public int store(Student stu);
	
	public void update(Student stu);
	
	public void delete(int studentId);
	
	public Student getStudentById(int studentId);
	
	public List<Student> getAll();
}
