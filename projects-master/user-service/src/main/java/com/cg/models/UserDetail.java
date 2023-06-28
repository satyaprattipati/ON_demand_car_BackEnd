package com.cg.models;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "signup")
public class UserDetail {

	@Id
	private int id;
	@NotNull(message = "Name must not be empty")
	private String name;
	@NotNull(message = "userName must not be empty")
	private String username;
	@NotNull(message = "Password Must not be empty")
	 @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password Should contain:\n1)a digit must occur at least once\n 2)a lower case letter must occur at least once\n\r\n 3)an upper case letter must occur at least once\n4)a special character must occur at least once\n\r\n5)no whitespace allowed in the entire string\n6)at least 8 characters")
	private String password;
	
	@Pattern(regexp = "\\d{10}", message = "Invalid contact details")
	private String contactno;
	@NotNull(message = "Email should not be empty")
	@Email(message = "Invalid E-mail Id")
	private String email;

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	public UserDetail() {
		super();
	}



	public int getId() {
		return id;
	}

	public UserDetail(int id, @NotNull(message = "Name must not be empty") String name,
		@NotNull(message = "userName must not be empty") String username,
		@NotNull(message = "Password Must not be empty") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password Should contain:\n1)a digit must occur at least once\n 2)a lower case letter must occur at least once\n\r\n 3)an upper case letter must occur at least once\n4)a special character must occur at least once\n\r\n5)no whitespace allowed in the entire string\n6)at least 8 characters") String password,
		@Pattern(regexp = "\\d{10}", message = "Invalid contact details") String contactno,
		@NotNull(message = "Email should not be empty") @Email(message = "Invalid E-mail Id") String email) {
	super();
	this.id = id;
	this.name = name;
	this.username = username;
	this.password = password;
	this.contactno = contactno;
	this.email = email;
}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "Signup [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", contactno=" + contactno + ", email=" + email + "]";
	}

	
}
