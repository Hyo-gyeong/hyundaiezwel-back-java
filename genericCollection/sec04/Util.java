package genericCollection.sec04;

public class Util {
  // 멤버메소드 추가 : 제네릭 타입 메소드 형식 : 접근제한자 static <> 반환값타입 메소드명(매개변수){}
  // <T> : 타입파라미터로 제네릭 타입의 메서드라는 것을 명시하고 호출할 때 타입이 결정돼야함
  public static <T> Box boxing(T t){ // 제네릭 타입 메서드
    Box<T> box = new Box<T>();
    box.set(t);
    return box; // 객체 인스턴스 반환
  }
}
