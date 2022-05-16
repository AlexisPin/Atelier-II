package com.sp.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.UpdateUserDto;
import com.sp.model.User;
import com.sp.model.UserDto;
import com.sp.service.CardService;
import com.sp.service.UserService;
import com.sp.util.CustomSuccesType;

@CrossOrigin
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
    public UserDto getUser(@PathVariable String id) {
		User user = uService.getUser(Integer.valueOf(id));
		UserDto uOptDto = new UserDto(user.getId(),user.getLogin(),user.getAccount(),user.getCardList());
		return uOptDto;
    }
    	
    
    @RequestMapping(method=RequestMethod.GET,value="/users")
    public List<UserDto> getUsers() {
        Iterable<User> users=uService.getUsers();
        List<UserDto> uOptDto = new ArrayList<UserDto>();
		for (User user : users) {
			uOptDto.add(new UserDto(user.getId(),user.getLogin(),user.getAccount(),user.getCardList()));
		}
        return uOptDto;

    }
    
    @RequestMapping(method=RequestMethod.PUT,value="user/{userId}")
    public ResponseEntity<?> putUser(@PathVariable Integer userId, @Valid @RequestBody UpdateUserDto userRequest, @RequestParam String transaction) {
    	return uService.updateUser(userId,userRequest, transaction);
    	
    }
}