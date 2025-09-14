package d_strategy;

import java.util.Random;
import java.util.Scanner;

import d_strategy.character.Monster;
import d_strategy.character.Player;
import d_strategy.item.Equipment;
import d_strategy.item.Slot;
import d_strategy.item.code.EquipmentData;

// Strategy 패턴 : interface이용
// Interface, 합성을 활용해 코드를 재사용하고 기능을 동적으로 확장
// 실행 시점에 변겨욀 로직을 결정할 수 있다. lazy binding, dynamic binding

// TemplateMethod 패턴 : 상속을 이용
// 다형성을 사용한 설계를 위해 인터페이스(public method)를 재사용하는 경우
// 컴파일 시점에 변경되는 로직이 결정됨 : early binding, static binding

public class Run {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Random random = new Random();
		
		Player player = new Player("지존짱짱맨", 200, 30, 10);
		Monster monster = new Monster("슬라임", 200, 30, 10);
		
		System.out.println("[전투이벤트] " + monster.getName() + " 등장!");
		boolean eventFlg = true;
		while(true) {
			
			if(player.isDead()) {
				System.out.println("\n======================================");
				System.out.println("[결과] LOSE");
				break;
			}
			
			if(monster.isDead()) {
				System.out.println("\n======================================");
				System.out.println("[결과] WIN");
				break;
			}
			
			System.out.println("\n======================================");
			sc.nextLine();
			
			if(player.getCurrentHp() < 150) {
                // System.out.println(EquipmentData.valueOf("BASIC_WEAPON")); // 해당 이름의 값 가져옴
                EquipmentData[] datas = EquipmentData.values(); // enum 내부에 static final로 선언한 객체 배열 반환
				int index = random.nextInt(0, datas.length);

				if(eventFlg) {
                    // 전략을 생성
                        // Equipment equipment = new Equipment("목검", 10, 1, Slot.WEAPON, "목검을 휘두릅니다.");
					// 전략을 주입, Dependency Injection, Inversion of Control(IOC)
                    Equipment equipment = datas[index].create();
                    System.out.println(equipment.getName()+" 발견했습니다.");
                    player.equip(equipment); // 동적으로 가져다가 사용
					eventFlg = false;
				}
			}
			
			player.attack(monster);
			monster.attack(player);
			System.out.println("------------------------------------");
			System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
			System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
		}
	}

}
