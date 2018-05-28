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

import com.bc.Service.IUserInterface;
import com.bc.Service.UserService;
import com.bc.entities.User;
import com.bc.exceptions.NoUserFound;
import com.bc.repositories.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@RestController

public class UserController {
	
	
	@Autowired
	private IUserInterface userService;

	
	

	@GetMapping("/users")
	public List<User> getUsers() throws Exception{
		List<User> totuser=userService.getUsers();
		
		if(totuser!=null && totuser.size()>0)
		{
			return totuser;
		}
		else
		throw new NoUserFound("There are no users");
	}

@GetMapping("/user/{id}")	
public Optional<User> getUser(@PathVariable String id) throws Exception {
	Optional<User> u = userService.getUser(id);
	if(u==null) {
		throw new NoUserFound("there's is no id of this type");
	}
	else
  return u; 
}

	@DeleteMapping("/users/user/{id}")
	public boolean deleteUser(@PathVariable String id) throws Exception {
		userService.deleteUser(id);
		return true;
	}

	@PostMapping("/users/user/{id}")
	public void updateUser(@RequestBody User user,@PathVariable String id) throws Exception {
		 userService.addUser(user,id);	
		 
	}

	

}
