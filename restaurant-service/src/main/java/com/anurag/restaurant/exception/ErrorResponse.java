package com.anurag.restaurant.exception;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	private int status;
	private List<String> message;
	private Date timeStamp;
	
}
