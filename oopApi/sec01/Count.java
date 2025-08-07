package oopApi.sec01;

public class Count {
  private int no;

  public Count(int no){
    this.no = no;
  }

  // 객체가 Garbage Collection에 의해 수거되면서 GC에 의해서 호출되는 메서드
  @Override
  protected void finalize() throws Throwable{ // Exception보다 상위 클래스
    System.out.println(no+"번 객체의 finalize()가 실행됨");
  }
  
}
