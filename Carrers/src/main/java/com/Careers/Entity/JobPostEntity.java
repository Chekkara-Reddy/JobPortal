package com.Careers.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="JobPostings")
public class JobPostEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long job_id;
	private long user_id;
	private long salary;
	@Temporal(TemporalType.DATE)
	private Date last_date;
	private String designation;
	private String location;
	private String companyName;
	private String skillsrequired;
	public JobPostEntity() {}
	public JobPostEntity(long job_id, long user_id, long salary, Date last_date, String designation, String location,
			String companyName, String skillsrequired) {
		super();
		this.job_id = job_id;
		this.user_id = user_id;
		this.salary = salary;
		this.last_date = last_date;
		this.designation = designation;
		this.location = location;
		this.companyName = companyName;
		this.skillsrequired = skillsrequired;
	}
	public long getJob_id() {
		return job_id;
	}
	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSkillsrequired() {
		return skillsrequired;
	}
	public void setSkillsrequired(String skillsrequired) {
		this.skillsrequired = skillsrequired;
	}
	
}
