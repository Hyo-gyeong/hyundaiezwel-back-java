package multiThread.sec02;

public class BeepPrintEx {
  public static void main(String[] args) {
    // 출력담당 쓰레드, 기본 쓰레드
    Runnable beepTask = new BeepTask(); // 쓰레드가 진행할 작업 객체
    // 두 번째 쓰레드 구성 - 작업 task전달
    Thread thread = new Thread(beepTask); // 작업객체를 포함한 스레드 생성

    thread.start(); // 멀티쓰레드 (main, beepTask)가 병렬로 동작, 비프음 출력 작업 1

    // 비프용 출력 작업 2
    for (int i = 0; i < 5; i++){
      System.out.println("띵");
      try{
        Thread.sleep(500);
      }catch (Exception e){
        System.err.println(e);
      }
    }
  }
}
