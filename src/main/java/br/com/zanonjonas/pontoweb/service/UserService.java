package br.com.zanonjonas.pontoweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.zanonjonas.pontoweb.exception.EmptyIdHttpException;
import br.com.zanonjonas.pontoweb.exception.NotFoundHttpException;
import br.com.zanonjonas.pontoweb.model.User;
import br.com.zanonjonas.pontoweb.repository.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) throws NotFoundHttpException {
		Optional<User> opt = userRepository.findById(id);
		if (opt.isEmpty()) {
			throw new NotFoundHttpException(String.format("User id %d not found", id));
		}
		return opt.get();
	}

	public User saveUser(User user) throws EmptyIdHttpException {
		if (user.getId() == null) {
			throw new EmptyIdHttpException("Cannot save user with empty id.");
		}
		return userRepository.save(user);
	}

	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}

	public void deleteById(Long id) throws NotFoundHttpException {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundHttpException(String.format("User id %d not found", id));
		}

	}

}
