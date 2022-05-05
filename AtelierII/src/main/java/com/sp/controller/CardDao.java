package com.sp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sp.model.Card;

@Service
public class CardDao {
	private List<Card> myCardList;
	private Random randomGenerator;

	public CardDao() {
		myCardList=new ArrayList<Card>();
		randomGenerator = new Random();
		createCardList();
	}

	private void createCardList() {
  
		Card p1=new Card("Superman", "The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El,"
				+ " moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass."
				+ " Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.",
				"http://www.superherobroadband.com/app/themes/superhero/assets/img/superhero.gif","DC comics","Justice League",50,100,17,80);
		
		myCardList.add(p1);
	}
	public List<Card> getCardList() {
		return this.myCardList;
	}
	public Card getCardByName(String name){
		for (Card CardBean : myCardList) {
			if(CardBean.getName().equals(name)){
				return CardBean;
			}
		}
		return null;
	}
	public Card getRandomCard(){
		int index=randomGenerator.nextInt(this.myCardList.size());
		return this.myCardList.get(index);
	}

	public Card addCard(String name, String description, String imgUrl, String family, String affinity, Integer hp,
			Integer energy, Integer attack, Integer defence) {
		Card p=new Card( name,  description,  imgUrl,  family,  affinity,  hp, energy,  attack,  defence);
		this.myCardList.add(p);
		return p;
	}
}
