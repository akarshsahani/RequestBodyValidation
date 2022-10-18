package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class UserRequest {

	@NotNull(message = "name cannto be null")
	@NotEmpty(message ="name cannto be empty")
	private String name;
	
//	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
//	@Pattern(regexp="(^$|[0-9]{10})", message = "Invalid mobile number")
	@Range(min = 10, max= 10, message = "phone_no should be exact 10 characters." )
	private long mobileNumber;
	
	@Min(18)
	@Max(65)
//	@NotBlank(message = "field cannot be blank")
	private int age;
	
	@NotNull(message = "email cannto be null")
	@Email(message = "invalid email address")
	@NotEmpty(message ="email cannto be empty")
	private String email;
	
	@NotNull(message = "password cannto be null")
	@NotEmpty(message ="password cannto be empty")
	private String password;

	private String gender;

	private String bio;

//	private String height;

	public UserRequest() {
		super();
	}

	public UserRequest(String name, int age, String email, String password, String gender, String bio, long mobileNumber) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.bio = bio;
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
}
