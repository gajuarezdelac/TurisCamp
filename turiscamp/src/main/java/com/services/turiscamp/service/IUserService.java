package com.services.turiscamp.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.services.turiscamp.domain.User;
import com.services.turiscamp.exception.EmailExistException;
import com.services.turiscamp.exception.EmailNotFoundException;
import com.services.turiscamp.exception.NotAnImageFileException;
import com.services.turiscamp.exception.UserNotFoundException;
import com.services.turiscamp.exception.UsernameExistException;

@Component
public interface IUserService {

	User register(String firstName, String lastName, String username) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User addNewUser(String firstName, String lastName, String username,  String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException, MessagingException;

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

    void deleteUser(String username) throws IOException;

    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

    User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;
	
}
