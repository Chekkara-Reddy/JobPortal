package com.Careers.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Application")
public class ApplicationEntity extends BaseEnitity {

	 private String name;
	 private String email;
	 private String mobile;
	 private String skills;
	 private String hobbies;
	 private String personalDetails;
	 private Boolean declaration;
	 @Lob
	 @Column(name="resume",columnDefinition="LONGBLOB")
	 private byte[] resume;
	 @Temporal(TemporalType.DATE)
	 private Date date;
	 private String place;
	 private long userId;
	 private String resumeType;
	 
	
	public ApplicationEntity(String name, String email, String mobile, String skills, String hobbies,
			String personalDetails, Boolean declaration, byte[] resume, Date date, String place, long userId,
			String resumeType) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.skills = skills;
		this.hobbies = hobbies;
		this.personalDetails = personalDetails;
		this.declaration = declaration;
		this.resume = resume;
		this.date = date;
		this.place = place;
		this.userId = userId;
		this.resumeType = resumeType;
	}
    
	public String getResumeType() {
		return resumeType;
	}

	public void setResumeType(String resumeType) {
		this.resumeType = resumeType;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(String personalDetails) {
		this.personalDetails = personalDetails;
	}
	public Boolean getDeclaration() {
		return declaration;
	}
	public void setDeclaration(Boolean declaration) {
		this.declaration = declaration;
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
	 
}
