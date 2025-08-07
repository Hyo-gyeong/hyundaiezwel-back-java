package oopClass.sec07;

public class Constructor {
  private int x;
  private int y;

  // 생성자 : 클래스 이름과 동일한 메소드, 반환타입 없음
  // 객체 생성될 때 한 번만 호출 가능
  // 생성자 역할 : 멤버변수 값 초기화
  // 명시적 생성자가 구현되어있으므로 컴파일러가 만드는 default생성자는 구현되지 않음
  public Constructor(){
    int x; // 생성자 내부 지역변수
    // 메소드 바이 영역이므로 x는 지역변수 지칭
    x = 200; // 지역변수
    this.x = 100;
  }

  public Constructor(int x){
    this.x = x;
  }

  public Constructor(int x, int y){
    // 멤버 변수 x 지칭시에는 class영역을 지칭하는 this 레퍼런스
    // this 레퍼런스 현재 클래스를 참조하는 예약어
    this.x = x;
    this.y = y;
  }

  public void show(){
    System.out.println("x : " + this.x);
    System.out.println("y : " + this.y);
  }
}
