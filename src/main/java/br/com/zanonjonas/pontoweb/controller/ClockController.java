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

import br.com.zanonjonas.pontoweb.model.Clock;
import br.com.zanonjonas.pontoweb.service.ClockService;

@RestController
public class ClockController {

	@Autowired
	private ClockService clockService;

	@GetMapping("/user/clock")
	public List<Clock> findAll() {
		return clockService.findAll();
	}

	@GetMapping("/user/clock/{id}")
	public Clock findById(@PathVariable(required = false) Long id) throws Exception {
		return clockService.findById(id);
	}

	@PostMapping("/user/clock")
	@ResponseStatus(HttpStatus.CREATED)
	public Clock createClock(@RequestBody Clock newClock) {
		return clockService.createClock(newClock);
	}

	@PatchMapping("/user/{userid}/clock")
	public Clock saveClock(@RequestBody Clock clock) throws Exception {
		return clockService.saveClock(clock);
	}

	@DeleteMapping("/user/{userid}/clock/{id}")
	public void deleteClock(@PathVariable(required = true) Long id) throws Exception {
		clockService.deleteById(id);
	}

}
