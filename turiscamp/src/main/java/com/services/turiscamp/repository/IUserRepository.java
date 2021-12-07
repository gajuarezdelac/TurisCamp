package com.services.turiscamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.services.turiscamp.domain.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
	
    User findUserByUsername(String username);    

}
