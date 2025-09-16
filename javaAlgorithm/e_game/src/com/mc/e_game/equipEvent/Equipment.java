package com.mc.e_game.equipEvent;

import java.util.Random;

public class Equipment implements DamageCalculator{
	
	private String name;
	private int atk;
	private int def;
	private Slot slot;
	private String effect;
	private Random random = new Random();

	public Equipment(String name, int atk, int def, Slot slot, String effect) {
		super();
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.slot = slot;
		this.effect = effect;
	}

	@Override
	public int calAttackWeight(int damage) {
		return random.nextInt(damage + atk, damage + atk * 2);
	}

	@Override
	public int calDefenceWeight(int damage) {
		return damage - (damage * def/100);
	}

	public Slot getSlot() {
		return this.slot;
	}

	public String getEffect() {
		return this.effect;
	}

	public String getName() {
		return this.name;
	}

	public int getAtk() {
		return this.atk;
	}

	public int getDef() {
		return def;
	}

}
