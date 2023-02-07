package com.Careers.Entity;
import org.hibernate.sql.ast.tree.from.MappedByTableGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class PermanentAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="add_id")
	private Long adressId;
	private String adLine1;
	private String locality;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String adressType;
	
   
	public PermanentAddress() {
		
	}

	public PermanentAddress(Long adressId, String adLine1, String locality, String city, String state, String country,
			String zipcode, String adressType) {
		super();
		this.adressId = adressId;
		this.adLine1 = adLine1;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.adressType = adressType;
	}
	public Long getAdressId() {
		return adressId;
	}
	public void setAdressId(Long adressId) {
		this.adressId = adressId;
	}
	public String getAdLine1() {
		return adLine1;
	}
	public void setAdLine1(String adLine1) {
		this.adLine1 = adLine1;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAdressType() {
		return adressType;
	}
	public void setAdressType(String adressType) {
		this.adressType = adressType;
	}
	

}
