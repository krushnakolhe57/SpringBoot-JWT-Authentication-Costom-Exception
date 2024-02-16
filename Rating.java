package com.sb.entity;

import lombok.Data;

@Data
public class Rating {
	
	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer rating;
	private String feedback;

}
