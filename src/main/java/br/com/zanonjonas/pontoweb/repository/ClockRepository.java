package br.com.zanonjonas.pontoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zanonjonas.pontoweb.model.Clock;

public interface ClockRepository extends JpaRepository<Clock, Long> {

}
