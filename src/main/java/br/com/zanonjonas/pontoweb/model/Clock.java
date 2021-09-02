package br.com.zanonjonas.pontoweb.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Clock {
	@Column
	private Long id;

	@Column
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private User user;

	@Column
	private LocalDateTime clockIn;

	@Column
	private LocalDateTime clockOut;

	public Clock() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
