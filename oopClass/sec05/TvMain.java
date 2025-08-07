package oopClass.sec05;

public class TvMain {
  public static void main(String[] args) {
    // 클래스를 타입처럼 사용할 수 있음
    Tv[] tvArr = new Tv[3]; // 길이가 3인 객체 배열, 아직은 3개 다 null을 참조하고 있는 상태
    for (int i = 0; i < tvArr.length; i++){
      tvArr[i] = new Tv();
      tvArr[i].channel = i+10;
    }

  }
}
