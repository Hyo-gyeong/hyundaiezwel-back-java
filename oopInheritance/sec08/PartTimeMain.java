package oopInheritance.sec08;

public class PartTimeMain {
  public static void main(String[] args) {
    PartTime partTime = new PartTime("123412-1234123", "홍길동", 34, 15000);
    System.out.println(partTime); // toString 자동으로 호출

    Worker worker = partTime; // subclass 객체 참조를 super class 참조 변수에 대입 가능
    // #### 부모 타입에는 모든 자식 객체가 대입됨. 자식 타입은 부모 타입으로 자동 타입 변환됨 #####
    // ex) 부모 - 동물, 자식 - 고양이 => 자식이 부모 타입으로 형변환 가능 = 고양이는 동물이다
    // 단, 형변환 후에는 "참조 변수의 타입"에 따라 접근 가능한 멤버가 결정되며,
      // 실행되는 메서드는 실제 객체(인스턴스)의 클래스에 따라 결정
    //❓ "왜 변수는 부모 기준인데 메서드는 자식 기준인가?"
    // → 변수는 컴파일 시 결정되고(부모값), 메서드는 런타임에 동적 바인딩되기 때문(자식값)
    System.out.println(worker);
  }
}
