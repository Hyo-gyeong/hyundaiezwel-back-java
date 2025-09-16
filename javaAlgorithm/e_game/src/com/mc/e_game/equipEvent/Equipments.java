package com.mc.e_game.equipEvent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mc.e_game.equipEvent.data.EquipmentData;



// 1급 컬랙션
// 1. 컬랙션에 직접 접근하는 것을 차단, 컬랙션의 불변성을 보장
// 2. 비지니스 로직을 캡슐화
//    Map을 직접 사용할 경우 CRUD가 모두 노출됨
//    1급 컬랙션을 사용해 원하는 작업만 가능하도록 숨길 수 있음(캡슐화)
// 3. 이름이 명확해진다.
public class Equipments {
    private final Map<Slot, Equipment> equipments;

    public Equipments(){
        equipments = new HashMap<Slot, Equipment>();
        // 기본 무기 장착
        equipments.put(Slot.WEAPON, EquipmentData.BASIC_WEAPON.create());
    }

    public void equip(Equipment equipment){
        equipments.put(equipment.getSlot(), equipment);
    }

    public Collection<Equipment> findAll(){
        return equipments.values();
    }

    public Optional<Equipment> findBySlot(Slot slot){
        return Optional.of(equipments.get(slot));
    }

    public Equipment getBySlot(Slot slot){
        return equipments.get(slot);
    }

    public boolean hasEquipment(Equipment equipment){
        if (equipments.get(equipment.getSlot()) == null){
            return false;
        }
        return true;
    }
}
