package br.com.zanonjonas.pontoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zanonjonas.pontoweb.model.User;
import br.com.zanonjonas.pontoweb.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/user/{id}")
	public User findById(@PathVariable(required = false) Long id) throws Exception {
		return userService.findById(id);
	}

	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User newUser) {
		return userService.createUser(newUser);
	}

	@PatchMapping("/user")
	public User saveUser(@RequestBody User user) throws Exception {
		return userService.saveUser(user);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable(required = true) Long id) throws Exception {
		userService.deleteById(id);
	}

}
