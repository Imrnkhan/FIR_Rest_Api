package com.masai.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer id;
	private LocalDateTime ldt;
	private String uuid;
}
