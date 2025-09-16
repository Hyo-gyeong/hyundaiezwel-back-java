package com.mc.e_game.equipEvent.data;

import com.mc.e_game.equipEvent.HPItem;
import com.mc.e_game.equipEvent.Slot;

public enum HPItemData {
    FRUIT("열매", 5, Slot.FRUIT, ""),
    ESSENCE("정수", 17, Slot.ESSENCE, ""),
    POTION("영약", 23, Slot.POTION, ""),
    ELIXIR("마법약", 34, Slot.ELIXIR, "");

    private String name;
	private int hp;
	private Slot slot;
	private String effect;

	private HPItemData(String name, int hp, Slot slot, String effect) {
		this.name = name;
		this.hp = hp;
		this.slot = slot;
		this.effect = effect;
	}

	public HPItem create(){
		return new HPItem(name, hp, slot, effect);
	}
}
