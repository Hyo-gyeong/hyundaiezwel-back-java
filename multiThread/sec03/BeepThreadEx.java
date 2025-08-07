package multiThread.sec03;

public class BeepThreadEx {
  public static void main(String[] args) {
    // 사용자 정의 thread 클래스
    Thread thread = new BeepThread();
    thread.start(); // 작업 1
    // thread.start(); // error! 한 개의 thread는 한 번만 실행 가능
    
    // 작업 2
    for (int i = 0; i < 5; i++){
      System.out.println("띵");
      try {
        Thread.sleep(500);
      }catch(Exception e){}
    }
    
    Thread thread2 = new BeepThread();
    thread2.start(); // 작업 3

  }
}
