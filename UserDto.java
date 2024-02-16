package com.sb.entity;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {
	
	private Integer id;
	private String name;
	private String company;
	private String city;
	private byte[] image;
	private List<Rating> rating;
	
	
}
