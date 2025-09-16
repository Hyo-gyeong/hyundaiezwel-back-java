package com.mc.e_game.character;

import java.util.Collection;
import java.util.Random;

import com.mc.e_game.equipEvent.Equipment;
import com.mc.e_game.equipEvent.Equipments;
import com.mc.e_game.equipEvent.HPItem;
import com.mc.e_game.equipEvent.data.EquipmentData;


public class Player extends Character{
	
	private Random random = new Random();
    private Equipments equipments = new Equipments();


	public Player(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	@Override
	public int attack(Character target) {
		int damage = random.nextInt(atk, atk * 3);
		for(Equipment e : equipments.findAll()) {
			damage = e.calAttackWeight(damage);
			System.out.println(e.getEffect());
		}
        target.takeDamage(damage);
		return damage;
	}

	@Override
	public int takeDamage(int damage) {
		// 피해량 연산
		for(Equipment e : equipments.findAll()) {
			damage = e.calDefenceWeight(damage);
		}
		this.currentHp -= damage;
		this.currentHp = Math.max(currentHp, 0);
		return damage;
	}

	public void printEquipments() {
		Collection<Equipment> equipmentList = equipments.findAll();
		StringBuilder sb = new StringBuilder();
		System.out.print("현재 장착한 장비 : [");
		for (Equipment equipment : equipmentList){
			sb.append(equipment.getName()).append(",");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]\n");
		System.out.println(sb.toString());
	}

	public void equip(Equipment equipment) {
		this.atk += equipment.getAtk();
		this.def += equipment.getDef();
		equipments.equip(equipment);
	}

	public void takeHPItem(HPItem hpItem){
		this.currentHp += hpItem.getHp();
	}
}
