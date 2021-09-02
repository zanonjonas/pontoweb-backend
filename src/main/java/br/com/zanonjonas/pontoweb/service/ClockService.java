package br.com.zanonjonas.pontoweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.zanonjonas.pontoweb.exception.EmptyIdHttpException;
import br.com.zanonjonas.pontoweb.exception.NotFoundHttpException;
import br.com.zanonjonas.pontoweb.model.Clock;
import br.com.zanonjonas.pontoweb.repository.ClockRepository;
import br.com.zanonjonas.pontoweb.repository.UserRepository;

@Component
public class ClockService {

	@Autowired
	private ClockRepository clockRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Clock> findAll() {
		return clockRepository.findAll();
	}

	public Clock findById(Long id) throws NotFoundHttpException {
		Optional<Clock> opt = clockRepository.findById(id);
		if (opt.isEmpty()) {
			throw new NotFoundHttpException(String.format("Clock id %d not found", id));
		}
		return opt.get();
	}

	public Clock saveClock(Clock clock) throws EmptyIdHttpException {
		if (clock.getId() == null) {
			throw new EmptyIdHttpException("Cannot save clock with empty id.");
		}
		return clockRepository.save(clock);
	}

	public Clock createClock(Clock newClock) {
		return clockRepository.save(newClock);
	}

	public void deleteById(Long id) throws NotFoundHttpException {
		try {
			clockRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundHttpException(String.format("User id %d not found", id));
		}

	}

}
