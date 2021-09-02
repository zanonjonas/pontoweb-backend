package br.com.zanonjonas.pontoweb.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class Clock {
	private Long id;

	private User theUser;

	private LocalDateTime clockIn;

	private LocalDateTime clockOut;

	public User getUser() {
		return theUser;
	}

}
