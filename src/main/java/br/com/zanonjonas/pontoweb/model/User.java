package br.com.zanonjonas.pontoweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.zanonjonas.pontoweb.enums.UserType;

@Entity
@Table(name = "Users")
public class User {
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String login;

	@Column
	@Enumerated(EnumType.STRING)
	private UserType type;

	public User() {

	}

	public User(Long id, String name, String login, UserType type) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Enumerated(EnumType.STRING)
	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [uuid=" + id + ", name=" + name + ", login=" + login + "]";
	}

}
