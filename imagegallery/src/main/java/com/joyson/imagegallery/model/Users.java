package com.joyson.imagegallery.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Image Gallery Users pojo for database table mapping
 * 
 * @author Joyson De Souza
 *
 */
@Entity(name = "Users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_Sequence")
	@SequenceGenerator(name = "users_Sequence", sequenceName = "USERS_SEQ")
	private Long id;

	@Column(name = "username", unique = true)
	private String userName;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "dateofbirth")
	private Date dateOfBirth;

	@Column(name = "email")
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
}
