package br.com.zanonjonas.pontoweb.dto;

import br.com.zanonjonas.pontoweb.enums.UserType;
import lombok.Data;

@Data
public class User {
	private Long id;

	private String name;

	private String login;

	private UserType type;
}
