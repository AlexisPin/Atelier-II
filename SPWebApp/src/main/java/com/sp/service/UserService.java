package com.sp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.model.Card;
import com.sp.model.UpdateUserDto;
import com.sp.model.User;
import com.sp.repository.UserRepository;
import com.sp.util.CustomErrorType;
import com.sp.util.CustomSuccesType;

@Service
public class UserService {
	@Autowired
	UserRepository uRepository;
	
	@Autowired
	CardService cService;
	
	public void addUser(User u) {
		List<Card> cards = cService.getCards();
		
		if(cards.size() > 4) {
			Collections.shuffle(cards);
			List<Card> userCards = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				Card card = cards.get(j);
				userCards.add(card);
				card.setUser(u);
				
			}
			u.setCardList(userCards);
		}
		User createdUser=uRepository.save(u);
		System.out.println(createdUser);
	}
	
	public User getUser(int id) {
		Optional<User> uOpt = uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}


	public Iterable<User> getUsers() {
		Iterable<User> uOpt =uRepository.findAll();
		return uOpt; 
	}
	

}
