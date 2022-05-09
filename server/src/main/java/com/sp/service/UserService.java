package com.sp.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.UpdateUserDto;
import com.sp.model.User;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uRepository;
	CardRepository cRepository;
	public void addUser(User u) {
		User createdUser=uRepository.save(u);
		System.out.println(createdUser);
	}
	
	public User getUser(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}

	public void updateUser(Integer userId, @Valid UpdateUserDto userRequest) {
		User user = this.getUser(userId);
			cardId = card.getId();
			cRepository.findById(cardId).map(card -> {
	            card.setUser(user);
	            return cRepository.save(card);
		});
			
		uRepository.findById(userId).map(user -> {
			user.setAccount(userRequest.getAccount());
			user.setCardList(userRequest.getCardList());
            return uRepository.save(user);
            });
		Integer cardId;
		for(Card cards : userRequest.getCardList()) {
			cardId = cards.getId();
			cRepository.findById(cardId).map(card -> {
	            card.setUser(user);
	            return cRepository.save(card);
		});
	}
	}
}
