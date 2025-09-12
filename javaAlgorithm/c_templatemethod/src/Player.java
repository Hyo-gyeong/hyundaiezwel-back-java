import java.util.Random;

public class Player extends Character{

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calcAttackWeight() {
        Random random = new Random();
        return random.nextInt(atk/2, atk*3);
    }

    @Override
    protected int calcDefenseWeight(int damage) {
        return damage - (damage * def/100); 
    }

    
    
}
