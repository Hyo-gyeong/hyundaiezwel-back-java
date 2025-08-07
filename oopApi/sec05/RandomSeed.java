package oopApi.sec05;

import java.util.Random;

public class RandomSeed {
  public static void main(String[] args) {
    // Random 클래스 객체 생성 시 seed전달
    // Random r = new Random();
    Random r = new Random(3); // 난수를 생성하는 알고리즘에서 사용하는 값 : seed
                                    // seed가 동일하면 프로그램 실행 시 동일한 난수 발생
    for (int i = 0; i < 5; i++){
      int x = r.nextInt(10)+1; //
      System.out.println(x);
    }
  }
}
