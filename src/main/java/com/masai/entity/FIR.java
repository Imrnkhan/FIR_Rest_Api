package com.masai.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FIR {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer firId;
	private String crimeDetail;
	private LocalDateTime ldt;
	private String policeStation;
	
	private String username;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Accused> AccusedUsername = new ArrayList<>();
}
