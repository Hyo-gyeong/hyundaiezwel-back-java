import java.util.Random;

// 추상 클래스는 미완성 설계도와 비슷하다
// 추상 클래스만으로는 인스턴스를 생성할 수 없고 자식 클래스에서 상속받아야만 완성시킬 수 있다
public abstract class Character {
    protected String name;
    protected int hp;
    protected int currenthp;
    protected int atk; // 공격력
    protected int def; //방어력

    public Character(String name, int hp, int atk, int def) {
        super();
        this.name = name;
        this.hp = hp;
        this.currenthp = hp;
        this.atk = atk;
        this.def = def;
    }

    public void attack(Character target){
        System.out.println("["+name+"] 공격!");
        Random random = new Random();
        int damage = calcAttackWeight(); random.nextInt(atk/2, atk*2);
        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        damage = calcDefenseWeight(damage); // 방어력을 뺀 만큼 데미지를 받음
        this.currenthp -= damage;
        this.currenthp = Math.max(currenthp, 0); // 현재 hp가 음수가 되지 않도록
    }

    protected abstract int calcAttackWeight();

    protected abstract int calcDefenseWeight(int damage);

    public String getName() {
        return name;
    }

    public int getCurrentHP(){
        return currenthp;
    }
    
    public boolean isDead(){
        return currenthp == 0;
    }
    
}
