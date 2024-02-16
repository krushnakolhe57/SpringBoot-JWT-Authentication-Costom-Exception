package com.sb.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "company1")
@Data
public class Company {
	
	@Id
	private Integer companyId;
	private String companyName;
	private Double companyValue;
	
	@OneToMany (mappedBy = "company")
	@JsonBackReference
	private List<User> user;
	
}
