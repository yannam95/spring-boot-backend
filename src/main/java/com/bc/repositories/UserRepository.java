package com.bc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bc.entities.User;


@Repository
public interface UserRepository  extends JpaRepository<User, String>{

}
