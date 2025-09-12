import java.util.Scanner;

public class Run {
    /*
     * 요구사항
     * Player 캐릭터의 공격 가중치는 atk/2 ~ atk*3
     * Monster의 데미지 가중치는 atk ~ atk*2
     * Warrior 캐릭터의 공격 가중치 atk ~ atk*4
     *                  방어 가중치 damage의 30%를 감소시킴
     * Thief 캐릭터의 공격 가중치는 atk/2 ~ atk*5
     * 50% 확률로 적의 공격을 무효화 한다
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Character player = new Thief("지존짱짱맨", 200, 30, 10);
        Character monster = new Monster("슬라임", 200, 30, 10);

        System.out.println("[전투이벤트] "+monster.getName()+" 등장!");
        while (true) {
            if (player.isDead()){
                System.out.println("[LOSE]");
                break;
            }
            if (monster.isDead()){
                System.out.println("[WIN]");
                break;
            }
            System.out.println("\n================================================");
            sc.nextLine();

            player.attack(monster);
            monster.attack(player);
            System.out.println("------------------------------------------");
            System.out.println("["+player.getName()+" HP] : "+ player.getCurrentHP());
            System.out.println("["+monster.getName()+" HP] : "+ monster.getCurrentHP());
        }
    }
}
