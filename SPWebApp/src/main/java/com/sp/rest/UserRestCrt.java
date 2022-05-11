package com.sp.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.UpdateUserDto;
import com.sp.model.User;
import com.sp.service.CardService;
import com.sp.service.UserService;

@RestController
public class UserRestCrt {
    @Autowired
    UserService uService;
    
    @Autowired
    CardService cService;
    
    @RequestMapping(method=RequestMethod.POST,value="/user")
    public void addUser(@RequestBody User card) {
        uService.addUser(card);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    public User getUser(@PathVariable String id) {
        User u=uService.getUser(Integer.valueOf(id));
        return u;
    }
    
    @RequestMapping(method=RequestMethod.PUT,value="user/{userId}")
    public ResponseEntity<?> putUser(@PathVariable Integer userId, @Valid @RequestBody UpdateUserDto userRequest, @RequestParam String transaction) {
    	return uService.updateUser(userId,userRequest, transaction);
    	
    }
}