package com.sp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sp.model.AuthUserDto;
import com.sp.model.User;
import com.sp.util.CustomErrorType;
import com.sp.util.CustomSuccesType;

@Service
public class AuthService {
	
	
	@Autowired
	UserService uService;
	
	public ResponseEntity<?> authUser(AuthUserDto u) {
		 Iterable<User> users = uService.getUsers();
		
		for(User user : users) {

	
			if(u.getLogin().equals(user.getLogin()) && u.getPwd().equals(user.getPwd()) ) {
				return new ResponseEntity<>(new CustomSuccesType(user).getUser(),
		                HttpStatus.OK);
			}
		 }
		return new ResponseEntity<>(new CustomErrorType("Wrong credentials"),
                HttpStatus.NOT_FOUND);
	}
}
