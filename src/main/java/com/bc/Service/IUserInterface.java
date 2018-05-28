package com.bc.Service;

import java.util.List;
import java.util.Optional;

import com.bc.entities.User;

public interface IUserInterface {

	
	
	public List<User> getUsers() throws Exception ;
	
	
	public Optional<User> getUser(String emailAddress)throws Exception;
	
	
	public  void addUser(User user,String emailAddress)throws Exception;
	
	
	public void deleteUser(String emailAddress) throws Exception;
}
