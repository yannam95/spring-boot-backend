package com.bc.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bc.entities.User;
import com.bc.repositories.UserRepository;

@Service
public class UserService implements IUserInterface {
	
	@Autowired
	UserRepository ur;
	
	
	public List<User> getUsers() throws Exception{
		List<User> users = ur.findAll();
		if(users != null && users.size()>0) {
			return users;
		}
		throw new Exception("No users found");
	}
	
	public Optional<User> getUser(String emailAddress) throws Exception{
		Optional<User> users=ur.findById(emailAddress);
		if (users.get().getEmailAddress().equals(emailAddress)) {
			return users;
		}
		else {
			throw new Exception("user not found with "+emailAddress);
					}
	}
	public  void addUser(User user,String emailAddress) throws Exception {
		
		if(user.getEmailAddress().equals(emailAddress)){
		if(!ur.existsById(user.getEmailAddress())){
			 ur.save(user);
		}else {
			throw new Exception("user already exists");
		}
			
	}
		else
			throw new Exception("please check the id entered and the data posted");
	}
	public void deleteUser(String emailAddress) throws Exception{
		boolean x=ur.existsById(emailAddress);
		if(x)
		ur.deleteById(emailAddress);
		else
		throw new  Exception("Please check the user you want to delete"); 	
	}
}