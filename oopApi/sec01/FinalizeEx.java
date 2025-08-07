package oopApi.sec01;

public class FinalizeEx {
  public static void main(String[] args) {
    // System.gc() 활용해서 GC를 실행하고 finalize() 메서드 호출하는 예제
    Count count = null;
    for (int i = 1; i < 50; i++){
      count = new Count(i); // 생성된 객체가
      count = null; // 여기에서 객체 참조를 잃어버림 -> garbage가 되는 시점
      System.gc(); // GC를 명시적으로 JVM에게 요청 (메모리가 모자라거나 CPU가 여유가 '있으면' GC는 CPU에 의해 자동 호출)
    }
    // gc()는 GC를 수행하기 바로 전에 소멸자 호출
  }
}
