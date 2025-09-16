package com.mc.e_game.presentation;
public class PrintBattle {
    static final int maxhp = 200;

    public static void printBattle(int playerDamage, int monsterDamage, int playerHP, int monsterHP) throws InterruptedException{
        String[] soldier = {
            "   O  ",
            "  /|\\ ",
            "  / \\ "
        };

        String[] monster = {
            "  (\\_._/) ",
            "  ( •ㅅ• )",
            "  / >🍖  "
        };

        System.out.println("=== 전투 시작! ===");
        Thread.sleep(800);

        for (int turn = 0; turn < 1; turn++) {
            // 병사 공격
            for (int i = 0; i < soldier.length; i++) {
                System.out.println(soldier[i] + "\t--->\t" + monster[i]);
            }
            System.out.println("내가 "+playerDamage+"만큼 공격했다!");
            Thread.sleep(1000);
            System.out.println();
            
            // 몬스터 반격
            for (int i = 0; i < soldier.length; i++) {
                System.out.println(soldier[i] + "\t<---\t" + monster[i]);
            }
            System.out.println("몬스터가 "+monsterDamage+"만큼 반격했다!");
            System.out.print("\n나의 HP  ");
            printHpBar(maxhp, playerHP);
            System.out.print("몬스터의 HP ");
            printHpBar(maxhp, monsterHP);
            Thread.sleep(1000);
            System.out.println();
        }
    }

    public static void printHpBar(int maxhp, int currenthp) {
        int barLength = 20; // 게이지 칸 수
        int filled = (int) ((double) currenthp / maxhp * barLength);

        StringBuilder bar = new StringBuilder();
        bar.append("[");

        for (int i = 0; i < barLength; i++) {
            if (i < filled) {
                bar.append("■"); // 꽉 찬 칸
            } else {
                bar.append(" "); // 빈 칸
            }
        }
        if (currenthp > maxhp) {
        	filled = (int) ((double) (currenthp - maxhp) / barLength);
        	for (int i = 0; i < filled; i++) {
                bar.append("□"); // 최대 hp보다 많은 hp표현
            }
        }
        bar.append("] ");

        // 체력 수치도 같이 출력
        bar.append(currenthp).append("/").append(maxhp);

        System.out.println(bar);
    }
}
