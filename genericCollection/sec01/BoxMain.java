package genericCollection.sec01;

public class BoxMain {
  public static void main(String[] args) {
    // Box 클래스 활용
    // 강제 타입 변환 발생하는데 성능 저하에 영향을 많이 미침 (자동 형변환보다 안좋음)
    // -> 제네릭으로 해결! : 클래스(인터페이스)나 메소드를 타입 파라미터를 이용해서 선언하는 기법
                        // 특정 타입에 종속되지 않게 유연하게 코드 작성하려고
                        // 컴파일 시 타입 결정, 오버라이드 메소드는 실행시 메소드 결정 (동적 다형성 이용)
    Box box = new Box();

    // subclass가 superclass Object로 대입이 되면서
    // 자동 타입변환 발생 String -> Object
    box.set("홍길동");
    // Box에 정의된 object필드는 Object타입이고 문자열이 저장되어있는 상태
    String name = (String) box.get(); // get으로 가져올때는 Object타입이니까 타입을 강제로 맞춰 줘야 함
    System.out.println(name);
    
    // 자동 타입변환 발생 int -> Object
    box.set(1123123);
    int num = (int) box.get(); // 강제 형변환
    System.out.println(num);
  }
}
