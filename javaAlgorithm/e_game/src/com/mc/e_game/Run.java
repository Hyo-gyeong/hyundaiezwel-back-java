package com.mc.e_game;
import java.util.Random;
import java.util.Scanner;

import com.mc.e_game.character.Monster;
import com.mc.e_game.character.Player;
import com.mc.e_game.equipEvent.Equipment;
import com.mc.e_game.equipEvent.HPItem;
import com.mc.e_game.equipEvent.data.EquipmentData;
import com.mc.e_game.equipEvent.data.HPItemData;
import com.mc.e_game.presentation.PrintBattle;
import com.mc.e_game.presentation.PrintEffect;



public class Run {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] events = {0,1,2};
        
        int day = 1;
        System.out.print("Player 이름을 입력하세요 : ");
        String userName = sc.nextLine();
        Player player = new Player(userName, 200, 30, 10);
		Monster monster = new Monster("슬라임", 200, 30, 10);
        System.out.println(userName+"님 안녕하세요! 이제부터 모험을 시작합니다~");

        while (day <= 8){
            if(player.isDead()) {
                System.out.println("아쉽지만 모험에 실패했습니다.....:(");
				return;
			}
            if(monster.isDead()) {
				break;
			}

            System.out.println("\n======================================");
            System.out.println("~~~~~~~~~~~~모험 "+day+"일차~~~~~~~~~~~~");
            int event;
            if (day < 8){
                event = events[random.nextInt(0, 3)];
            } else {
                event = 0;
            }
			sc.nextLine();

            if (event == 0){
                System.out.println("전투이벤트가 발생했습니다!\n" + monster.getName() + " 몬스터가 등장했습니다!");
                player.printEquipments();
                int playerDamage = player.attack(monster);
                int monsterDamage = monster.attack(player);
                PrintBattle.printBattle(playerDamage, monsterDamage, player.getCurrentHP(), monster.getCurrentHP());
            }
            else if (event == 1){
                EquipmentData[] datas = EquipmentData.values();
                int index = random.nextInt(1, datas.length);
                Equipment equipment = datas[index].create();
                System.out.println(equipment.getName()+" 발견했습니다.");
                System.out.print("아이템을 장착하시겠습니까? (y/n) ");
                String answer = sc.nextLine();
                if (answer.equals("y")){
                    System.out.println("아이템을 장착하였습니다.");
                    player.equip(equipment);
                    PrintEffect.printItemEffect(equipment.getName(), equipment.getAtk(), equipment.getDef());
                    System.out.println("[" + player.getName() + "님의 현재 공격력, : " + player.getAtk()+", 방어력 : "+player.getDef()+"]");
                } else if (answer.equals("n")){
                    System.out.println("아이템을 장착하지 않습니다.");
                } else {
                    System.out.println("입력이 잘못되었습니다. 아이템은 장착하지 못합니다.");
                }
            } else {
                HPItemData[] hpItems = HPItemData.values();
                int index = random.nextInt(0, hpItems.length);
                HPItem hpItem = hpItems[index].create();
                System.out.println(hpItem.getName()+" 발견했습니다.");
                player.takeHPItem(hpItem);
                PrintEffect.printFoodEffect(hpItem.getName(), hpItem.getHp());
                System.out.println("[" + player.getName() + "님의 현재 HP ] : " + player.getCurrentHP());
            }
            day++;
        }
        // 성공
        if (!monster.isDead() && !player.isDead()){
            System.out.println("축하합니다~! 모험에 성공하였습니다!");
        } else {
            System.out.println("몬스터를 물리쳐서 모험에 성공했습니다!! 축하합니다!!");
        }
        if(player.isDead()) {
            System.out.println("아쉽지만 모험에 실패했습니다.....:(");
        }
        System.out.println("프로그램이 종료됩니다.");
        sc.close();
    }
    
}
