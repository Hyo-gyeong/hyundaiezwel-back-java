package d_strategy.item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import d_strategy.item.code.EquipmentData;

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
        equipments.put(Slot.WEAPON, EquipmentData.BASIC_WEAPON.create());
    }

    public void equip(Equipment equipment){
        equipments.put(equipment.getSlot(), equipment);
    }

    public void unEquip(Slot slot){
        if (slot.equals(Slot.WEAPON)){
            equipments.put(Slot.WEAPON, EquipmentData.BASIC_WEAPON.create());
            return;
        }

        equipments.remove(slot);
    }

    public Collection<Equipment> findAll(){
        return equipments.values();
    }

    public Optional<Equipment> findBySlot(Slot slot){
        return Optional.of(equipments.get(slot));
    }
}
