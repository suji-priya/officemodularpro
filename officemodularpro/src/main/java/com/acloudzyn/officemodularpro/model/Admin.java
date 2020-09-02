package com.acloudzyn.officemodularpro.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Admin implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private String firstName;
	private String lastName;
    private String email;
	private String mobNo;
	private String adharCardNo;
	private String city;
	private String pincode;

	public Admin(int id, String designation, String firstName, String lastName, String email, String mobNo,
			String adharCardNo, String city, String pincode) {
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
	}

	public Admin() {

	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", designation=" + designation + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", mobNo=" + mobNo + ", adharCardNo=" + adharCardNo + ", city=" + city
				+ ", pincode=" + pincode + "]";
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
		System.out.println("email called");
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection list=new ArrayList<>(Arrays.asList("write","read"));
		
		return list;
	}

	@Override
	public String getPassword() {
		System.out.println(this.getLastName());
		return this.getLastName();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getFirstName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
