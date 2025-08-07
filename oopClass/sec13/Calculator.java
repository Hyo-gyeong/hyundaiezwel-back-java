package oopClass.sec13;

public class Calculator {
  static double pi = 3.141592; // 객체 생성 없이 사용 가능한 필드이므로 보통 선언할 때 초기값 설정

  static int plus(int x, int y){
    return x+y;
  }
  
  static int minus(int x, int y){
    return x-y;
  }

}
