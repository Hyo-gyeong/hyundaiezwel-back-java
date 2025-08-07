package multiThread.sec02;

import java.awt.Toolkit;

public class BeepTask implements Runnable{
  // beep 툴력 담당 쓰레드, 기본 쓰레드

  @Override
  public void run() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    // 비프용 출력
    for (int i = 0; i < 5; i++){
      toolkit.beep();
      try{
        Thread.sleep(500); // 0.5초씩 지연
      }catch (Exception e){
        System.err.println(e);
      }
    }
  }
}
