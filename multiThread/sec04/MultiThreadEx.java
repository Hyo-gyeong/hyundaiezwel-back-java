package multiThread.sec04;

public class MultiThreadEx {
  public static void main(String[] args) {
    //MutiThread
    MultiThread t1 = new MultiThread(1);
    MultiThread t2 = new MultiThread(2);
    MultiThread t3 = new MultiThread(3);

    //3개 쓰레드 실행
    // 순서대로 나올 수도 있고 섞일 수도 있고 돌릴 때마다 다름
    t1.start();
    t2.start();
    t3.start();
  }
}
