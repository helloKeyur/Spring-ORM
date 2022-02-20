package com.kdvamja.springorm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="students")
@Entity
public class Student {
	@Id
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name")
	private String sutdentName;
	
	@Column(name="aca_year")
	private String acaYear;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getSutdentName() {
		return sutdentName;
	}
	public void setSutdentName(String sutdentName) {
		this.sutdentName = sutdentName;
	}
	public String getAcaYear() {
		return acaYear;
	}
	public void setAcaYear(String acaYear) {
		this.acaYear = acaYear;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Student() {
		super();
	}
	public Student(String sutdentName, String acaYear, Date createdAt) {
		super();
		this.sutdentName = sutdentName;
		this.acaYear = acaYear;
		this.createdAt = createdAt;
	}
	public Student(int studentId, String sutdentName, String acaYear, Date updatedAt) {
		super();
		this.studentId = studentId;
		this.sutdentName = sutdentName;
		this.acaYear = acaYear;
		this.updatedAt = updatedAt;
	}
	public Student(int studentId, String sutdentName, String acaYear, Date createdAt, Date updatedAt) {
		super();
		this.studentId = studentId;
		this.sutdentName = sutdentName;
		this.acaYear = acaYear;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", sutdentName=" + sutdentName + ", acaYear=" + acaYear
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
