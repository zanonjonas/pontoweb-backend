package br.com.zanonjonas.pontoweb.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.zanonjonas.pontoweb.enums.UserType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data

@Entity
@Table(name = "Users")
public class User {
	@Column
	@Getter(AccessLevel.NONE)
	private Long id;

	@Column
	private String name;

	@Column
	private String login;

	@Column
	@Enumerated(EnumType.STRING)
	@Getter(AccessLevel.NONE)
	private UserType type;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Clock> clock;

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

	@Enumerated(EnumType.STRING)
	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
}
