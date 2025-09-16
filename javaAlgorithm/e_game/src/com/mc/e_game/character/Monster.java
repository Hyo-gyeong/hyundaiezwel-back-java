package com.mc.e_game.character;

import java.util.Random;

public class Monster extends Character{
	
	private Random random = new Random();

	public Monster(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	@Override
	public int attack(Character target) {
		int damage = random.nextInt(atk, atk*2);
		target.takeDamage(damage);
		return damage;
	}

	@Override
	public int takeDamage(int damage) {
		damage = damage - (damage * def/100);
		this.currentHp -= damage;
		this.currentHp = Math.max(currentHp, 0);
		return damage;
	}
	
	

}
