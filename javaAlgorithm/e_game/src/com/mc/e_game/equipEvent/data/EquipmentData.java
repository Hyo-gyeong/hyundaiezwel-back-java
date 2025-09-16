package com.mc.e_game.equipEvent.data;

import com.mc.e_game.equipEvent.Equipment;
import com.mc.e_game.equipEvent.Slot;

public enum EquipmentData {
    BASIC_WEAPON("주먹", 1, 1, Slot.BASIC_WEAPON, "퍽퍽!"),
    WOOD_SWORD("목검", 10, 2, Slot.WEAPON, "휙휙!"),
    WOOD_AXE("나무도끼", 15, 4, Slot.WEAPON, "슉슉!"),
    KATANA("카타나", 20, 6, Slot.WEAPON, "쉭쉭!"),

	BASIC_ITEM("장갑", 1, 10, Slot.GLOVES, "-장갑으로 손을 보호합니다-"),
    WOOD_ARMOR("나무갑옷", 1, 15, Slot.ARMOR,"-나무갑옷으로 몸을 보호합니다-"),
    WOOD_BOOTS("나무부츠", 1, 15, Slot.BOOTS,"-나무부츠로 발을 보호합니다-"),
    IRON_BOOTS("쇠부츠", 3, 15, Slot.BOOTS,"-쇠부츠로 발을 보호합니다-"),
    STONE_ARMOR("돌갑옷", 1, 20, Slot.ARMOR,"-돌갑옷으로 몸을 보호합니다-"),
	HELMET("헬멧", 1, 5, Slot.HELMET,"-헬멧으로 머리를 보호합니다-"),
	IRON_HELMET("쇠헬멧", 3, 10, Slot.HELMET,"-쇠헬멧으로 머리를 보호합니다-");


    private String name;
	private int atk;
	private int def;
	private Slot slot;
	private String effect;

	private EquipmentData(String name, int atk, int def, Slot slot, String effect) {
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.slot = slot;
		this.effect = effect;
	}

    public Equipment create(){
        return new Equipment(name, atk, def, slot, effect);
    }
    
    public String getEffect() {
    	return this.effect;
    }
}
