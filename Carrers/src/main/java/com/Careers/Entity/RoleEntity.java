package com.Careers.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROLE")
public class RoleEntity extends BaseEnitity{
	
	
	public static final int ADMIN=1;
	public static final int JOBSEEKER=2;
	public static final int RECRUITER=3;
	@Id
	private String Role_id;
	@Column(name="Name")
	private String name;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
