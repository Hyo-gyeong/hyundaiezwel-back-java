import java.util.Random;

public class Warrior extends Character{

    public Warrior(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calcAttackWeight() {
        Random random = new Random();
        return random.nextInt(atk, atk*4);
    }

    @Override
    protected int calcDefenseWeight(int damage) {
        return damage - (damage * def/100);
    }

}