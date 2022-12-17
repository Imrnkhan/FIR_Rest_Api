package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
//	@Column(unique = true)
//	@NotNull
	private String username;
//	@Pattern(regexp = "[a-zA-Z]{3,12}", message = "First Name must not contains numbers or special characters")
	private String firstName ;
//	@Pattern(regexp = "[a-zA-Z]{3,12}", message = "First Name must not contains numbers or special characters")
	private String	lastName ;
//	@Column(name = "mobile_number", nullable = false)
//	@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Mobile number must have 10 digits")
	private String	mobileNumber;
	private String	address;
	private Integer	age;
	private String gender;
//	@Pattern(regexp = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must have 8 Chracter or digits")
    private String password;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
    private List<FIR> firList = new ArrayList<>();
}
