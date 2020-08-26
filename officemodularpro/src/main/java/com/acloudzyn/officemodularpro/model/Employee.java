package com.acloudzyn.officemodularpro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	private int id;
	private String designation;
	private String firstName;
	private String lastName;
	private String email;
	private String mobNo;
	private String adharCardNo;
	private String city;
	private String pincode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "managerId")
	private Manager theManager;

	public Employee(int id, String designation, String firstName, String lastName, String email, String mobNo,
			String adharCardNo, String city, String pincode, Manager theManager) {
		super();
		this.id = id;
		this.designation = designation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNo = mobNo;
		this.adharCardNo = adharCardNo;
		this.city = city;
		this.pincode = pincode;
		this.theManager = theManager;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", designation=" + designation + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", mobNo=" + mobNo + ", adharCardNo=" + adharCardNo + ", city=" + city
				+ ", pincode=" + pincode + ", theManager=" + theManager + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getAdharCardNo() {
		return adharCardNo;
	}

	public void setAdharCardNo(String adharCardNo) {
		this.adharCardNo = adharCardNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Manager getTheManager() {
		return theManager;
	}

	public void setTheManager(Manager theManager) {
		this.theManager = theManager;
	}

}
