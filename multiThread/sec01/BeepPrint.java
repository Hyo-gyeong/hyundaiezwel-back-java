package multiThread.sec01;

import java.awt.Toolkit;

public class BeepPrint {
  public static void main(String[] args) {
    // main thread
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    // 비프용 출력
    for (int i = 0; i < 5; i++){
      toolkit.beep();
      try{
        Thread.sleep(500);
      }catch (Exception e){
        System.err.println(e);
      }
    }

    for (int i = 0; i < 5; i++){
      System.out.println("땡");
      try {
        Thread.sleep(500);
      } catch (Exception e){
        System.out.println(e);
      }
    }
  }
}
