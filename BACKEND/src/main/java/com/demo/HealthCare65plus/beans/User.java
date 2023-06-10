package com.demo.HealthCare65plus.beans;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Inheritance
@MappedSuperclass
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String contact;
    private String address;
    private Date dateOfBirth;
    private String email;
    private String password;
   
    
   
    public User() {
		super();
	}

	public User(int userId, String name, String contact, String address, Date dateOfBirth, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getRole() {
		String role="patient";
		return role;
	}

}

