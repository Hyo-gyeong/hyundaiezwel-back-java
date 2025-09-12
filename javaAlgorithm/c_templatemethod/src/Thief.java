import java.util.Random;

public class Thief extends Character{
    Random random = new Random();

    public Thief(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calcAttackWeight() {
        if (random.nextInt(0,2) == 0){
            System.out.println("[Thief 특성 발동] 공격이 빗나갑니다.");
            return 0;
        }
        return random.nextInt(atk/2, atk*5);
    }

    @Override
    protected int calcDefenseWeight(int damage) {
        return damage - (damage * def/100);
    }
    
}
