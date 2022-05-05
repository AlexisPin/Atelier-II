package com.sp.model;
public class Card  {
	
	private String name;
	private String description;
	private String imgUrl;
	private String family;
	private String affinity;
	private Integer hp;
	private Integer energy;
	private Integer attack;
	private Integer defence;


	public Card() {
		this.name = "";
		this.description = "";
		this.imgUrl = "";
		this.family = "";
		this.affinity = "";
		this.hp = 0;
		this.energy = 0;
		this.attack = 0;
		this.defence = 0;
	}

	public Card(String name, String description, String imgUrl, String family, String affinity, Integer hp,
			Integer energy, Integer attack, Integer defence) {
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getAffinity() {
		return affinity;
	}

	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefence() {
		return defence;
	}

	public void setDefence(Integer defence) {
		this.defence = defence;
	}



}
