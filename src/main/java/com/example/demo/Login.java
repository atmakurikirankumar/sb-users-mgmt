package com.example.demo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Login {
	
	private LocalDateTime timestamp;
	private String message;
	private int status;

}
