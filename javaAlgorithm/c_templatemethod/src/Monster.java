import java.util.Random;

public class Monster extends Character{

    public Monster(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calcAttackWeight() {
        Random random = new Random();
        return random.nextInt(atk, atk*2);
    }

    @Override
    protected int calcDefenseWeight(int damage) {
        return damage - (damage * def/100);
    }
    
}
