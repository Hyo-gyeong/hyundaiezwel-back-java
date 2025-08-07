package genericCollection.sec10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListPrdMain {
  public static void main(String[] args) {
    Product p1 = new Product(10000, "마우스", 20000);
    Product p2 = new Product(10001, "키보드", 80000);
    Product p3 = new Product(10002, "모니터", 220000);

    //ArrayList : Array의 특징을 포함하고 있음, 크기가 고정되는 Array의 단점을 해결 - 크기가 가변적
    //idx로 운영 가능, 삽입삭제가 빈번한 경우 이동연산으로 인해 성능이 떨어질 수 있음
    //Object type으로 구성되어 어떤 형태의 데이터도 저장 가능(Object로 형변환)
    //타입고정을 위한 제네릭 제공
    //ArrayList<Product> list = new ArrayList<Product>();

    // 삽입 삭제가 비번한 경우에는 LinkedList를 활용하는 것이 효율적
    // 물리적인 구조가 다를 뿐이지 기능은 동일함
    List<Product> list1 = new LinkedList<>(); // 인터페이스가 LinkedList를 참조하는 형태
    LinkedList<Product> list = new LinkedList<>(); // 인터페이스 사용보다 좀 더 빠름
    list.add(p1);
    list.add(p2);
    list.add(p3);
    
    for (Product prd : list){
      System.out.println(prd);
    }
  }
}
