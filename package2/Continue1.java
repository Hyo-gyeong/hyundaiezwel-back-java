package package2;

public class Continue1 {
  public static void main(String[] args) {
    // 짝수만 출력
    for (int i = 0; i < 10; i++){
      if (i % 2 == 1){
        continue;
      }
      System.err.println(i);
    }
  }
}
