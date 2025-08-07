package oopApi.sec02;

public class SystemExitMain {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++){
      System.out.println(i);
      if (i == 5) {
        System.exit(0); // 이 시점에 프로그램 완전 종료
        // status : 0(정상 종료)과 1 또는 -1(비정상 종료)
        break;
      }
    }
    System.out.println("종료"); // 출력 안됨
  }
}
