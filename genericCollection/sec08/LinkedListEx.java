package genericCollection.sec08;

import java.text.DecimalFormat;
import java.util.*;

public class LinkedListEx {
  // 빈번히 삽입/삭제가 나타날 때 사용하는것이 좋음
  public static void main(String[] args) {
    // 성능 비교
    // Interface vs List 각각에 대하여 ArrayList vs LinkedList
    List<String> listArrList = new ArrayList<>();
    List<String> listLinkedList = new LinkedList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    LinkedList<String> linkedList = new LinkedList<>();

    DecimalFormat df = new DecimalFormat("#,###");

    // LinkedList가 훨씬 빠름
    // 1. List-ArrayList
    long startTIme = System.nanoTime(); // 이 코드 실행 시점을 얻어옴
    for (int i = 0; i < 10000; i++){
      // 이동 연산이 많도록 구성
      listArrList.add(0, String.valueOf(i));
    }
    long endTime = System.nanoTime(); // 이 코드 실행 시점을 얻어옴
    System.out.println("listArrList 소요시간 : " + df.format(endTime - startTIme) + "ns");
    
    // 2. List-LinkedList
    startTIme = System.nanoTime(); // 이 코드 실행 시점을 얻어옴
    for (int i = 0; i < 10000; i++){
      // 이동 연산이 많도록 구성
      listLinkedList.add(0, String.valueOf(i));
    }
    endTime = System.nanoTime(); // 이 코드 실행 시점을 얻어옴
    System.out.println("listLinkedList 소요시간 : " + df.format(endTime - startTIme) + "ns");
    
    // 인터페이스보다 자체 객체 참조가 조금 더 빠름
    // 3. ArrayList-ArrayList
    startTIme = System.nanoTime(); // 이 코드 실행 시점을 얻어옴
    for (int i = 0; i < 10000; i++){
      // 이동 연산이 많도록 구성
      arrayList.add(0, String.valueOf(i));
    }
    endTime = System.nanoTime(); // 이 코드 실행 시점을 얻어옴
    System.out.println("arrayList 소요시간 : " + df.format(endTime - startTIme) + "ns");
    
    // 4. LinkedList-LinkedList
    startTIme = System.nanoTime(); // 이 코드 실행 시점을 얻어옴
    for (int i = 0; i < 10000; i++){
      // 이동 연산이 많도록 구성
      linkedList.add(0, String.valueOf(i));
    }
    endTime = System.nanoTime(); // 이 코드 실행 시점을 얻어옴
    System.out.println("linkedList 소요시간 : " + df.format(endTime - startTIme) + "ns");
  }
}
