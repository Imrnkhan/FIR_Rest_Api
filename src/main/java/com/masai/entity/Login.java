package com.masai.entity;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Login {

	@NotNull
	private String username;
	@NotNull(message = "Enter Password")
	private String password;
}
