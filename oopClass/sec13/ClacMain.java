package oopClass.sec13;

public class ClacMain {
  public static void main(String[] args) {
    // Caculator 클래스는 static 멤버로만 이루어진 클래스
    // 객체 인스턴스 멤버가 없으므로 객체 생성이 필요 없음
    double result1 = 10*10*Calculator.pi; // 클래스 통해서 바로 접근해서 사용 가능
    int result2 = Calculator.plus(10, 5);
    int result3 = Calculator.minus(10, 5);
  }
}
