package com.kdvamja.springorm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kdvamja.springorm.dao.StudentDao;
import com.kdvamja.springorm.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public int store(Student stu) {
		Integer saveRecord = (Integer) this.template.save(stu);
		return saveRecord;
	}
	
	@Transactional
	public void update(Student stu) {
		this.template.update(stu);
	}

	@Transactional
	public void delete(int studentId) {
		Student stu = this.getStudentById(studentId);
		this.template.delete(stu);
	}

	public Student getStudentById(int studentId) {
		Student stu = this.template.get(Student.class, studentId);
		return stu;
	}

	public List<Student> getAll() {
		List<Student> list = this.template.loadAll(Student.class);
		return list;
	}

}
