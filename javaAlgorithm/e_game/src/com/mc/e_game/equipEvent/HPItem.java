package com.mc.e_game.equipEvent;

// 1급 컬랙션
// 1. 컬랙션에 직접 접근하는 것을 차단, 컬랙션의 불변성을 보장
// 2. 비지니스 로직을 캡슐화
//    Map을 직접 사용할 경우 CRUD가 모두 노출됨
//    1급 컬랙션을 사용해 원하는 작업만 가능하도록 숨길 수 있음(캡슐화)
// 3. 이름이 명확해진다.
public class HPItem {
    private String name;
	private int hp;
	private Slot slot;
	private String effect;

    public HPItem(String name, int hp, Slot slot, String effect) {
        this.name = name;
        this.hp = hp;
        this.slot = slot;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public Slot getSlot() {
        return slot;
    }

    public String getEffect() {
        return effect;
    }
    
}
