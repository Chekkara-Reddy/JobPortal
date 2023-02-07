package com.Careers.Entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Application")
public class ApplicationEntity extends BaseEnitity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long application_id;
	 private String Username;
	 private String email;
	 private String mobile;
	 private String skills;
	 private String hobbies;
	 private Boolean declaration;
	 @Lob
	 @Column(name="resume",columnDefinition="LONGBLOB")
	 private byte[] resume;
	 @Temporal(TemporalType.DATE)
	 private Date date;
	 private String place;
	 private long userId;
	 private String resumeType;
	 @OneToOne(cascade=CascadeType.ALL)
	 private PermanentAddress add;
	 
	 
	public PermanentAddress getAdd() {
		return add;
	}
	public void setAdd(PermanentAddress add) {
		this.add = add;
	}
	public ApplicationEntity() {}
	public long getApplication_id() {
		return application_id;
	}
	public void setApplication_id(long application_id) {
		this.application_id = application_id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public Boolean getDeclaration() {
		return declaration;
	}
	public void setDeclaration(Boolean declaration) {
		this.declaration = declaration;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getResumeType() {
		return resumeType;
	}
	public void setResumeType(String resumeType) {
		this.resumeType = resumeType;
	}

    
	}
