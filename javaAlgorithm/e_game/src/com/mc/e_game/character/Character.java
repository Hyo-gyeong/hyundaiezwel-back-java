package com.mc.e_game.character;

public abstract class Character {
	protected String name;
	protected int hp;
	protected int currentHp;
	protected int atk;
	protected int def;
	
	public Character(String name, int hp, int atk, int def) {
		super();
		this.name = name;
		this.hp = hp;
		this.currentHp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	public abstract int attack(Character target); 
	public abstract int takeDamage(int damage);

	public String getName() {
		return name;
	}

	public int getCurrentHP() {
		return currentHp;
	}
	
	public int getAtk() {
		return atk;
	}

	public int getDef() {
		return def;
	}

	public boolean isDead() {
		return currentHp == 0;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setDef(int def) {
		this.def = def;
	}

	
	
}
