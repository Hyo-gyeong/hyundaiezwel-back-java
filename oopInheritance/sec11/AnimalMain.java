package oopInheritance.sec11;

public class AnimalMain {
  public static void main(String[] args) {
    Animal ani1;
    ani1 = new Animal(); // 자신 타입의 객체 참조
    ani1.show();
    ani1.sound();

    // 여러 객체를 만들 필요 없이 ani1 하나로 여러 객체로 바꿔가면서 참조할 수 있음
    // 자동 타입변환
    ani1 = new Cat(); /* Cat타입의 객체를 Animal타입 변수에 대입하면 타입 불일치가 일어나는게 맞지만
                      Animal을 상속받았기 때문에 super클래스로 자동 타입 변환됨 */
    ani1.show(); // 오버라이딩 되었으므로 Cat의 메소드가 호출됨
    ani1.sound();

    ani1 = new Dog();
    ani1.show();
    ani1.sound();
  }
}
