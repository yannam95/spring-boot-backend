package com.bc.spr;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController



public class UserController {
	@Autowired
	private UserRepository userRepository;

	
	

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

@GetMapping("/user/{id}")
public Optional<User> getUser(@PathVariable Integer id) {
		return userRepository.findById(id);
	}

	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return true;
	}

	@PostMapping("/save")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);	
	}

	@PutMapping("/save/{id}")
	public User upduser(@RequestBody User user,@PathVariable Integer id) {
		return userRepository.save(user);
				}

}
