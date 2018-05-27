package com.bc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bc.entities.User;
import com.bc.exceptions.NoUserFound;
import com.bc.repositories.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@RestController

public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;

	
	

	@GetMapping("/users")
	public List<User> getUsers() throws NoUserFound{
		List<User> totuser=userRepository.findAll();
		
		if(totuser!=null && totuser.size()>0)
		{
			return totuser;
		}
		else
		throw new NoUserFound("There are no users");
	}

@GetMapping("/user/{id}")	
public Optional<User> getUser(@PathVariable String id) throws NoUserFound {
	Optional<User> u = userRepository.findById(id);
	if(u==null) {
		throw new NoUserFound("there's is no id of this type");
	}
	else
  return u; 
}

	@DeleteMapping("/users/user/{id}")
	public boolean deleteUser(@PathVariable String id) {
		userRepository.deleteById(id);
		return true;
	}

	@PostMapping("/users/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);	
	}

	@PutMapping("/users/user/{id}")
	public User upduser(@RequestBody User user,@PathVariable String id) {
		return userRepository.save(user);
				}

}
