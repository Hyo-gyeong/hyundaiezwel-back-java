package randomEx;

import java.util.Random;

public class RandomNum2 {
  public static void main(String[] args) {
    // 난수 발생을 위해서 Random 클래스 사용
    // 참조 객체 생성해서 사용해야 함
    // 객체.nextInt(숫자) 특정 범위에서 생성
    Random rd = new Random();

    for (int i = 0; i < 10; i++){
      int num = rd.nextInt(10); // 0-9사이의 난수
      int num1 = rd.nextInt(10)+1; // 1-10사이의 난수
      System.err.println(num);
      System.err.println(num1);
    }
  }
}
