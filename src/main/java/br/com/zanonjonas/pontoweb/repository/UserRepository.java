package br.com.zanonjonas.pontoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zanonjonas.pontoweb.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
