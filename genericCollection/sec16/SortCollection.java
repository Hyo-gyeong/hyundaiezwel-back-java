package genericCollection.sec16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SortCollection {
  static void printList(ArrayList<String> arr){
    Iterator<String> iterator = arr.iterator();
    while (iterator.hasNext()){
      String ele = iterator.next();
      String sep;
      if (iterator.hasNext()){
        sep = "->";
      } else {
        sep = "\n";
      }
      System.out.print(ele + sep);
    }
  }
  public static void main(String[] args) {
    // 콜렉션 객체에 사용 가능한 sort, reverse 메소드
    ArrayList<String> myList = new ArrayList<>();
    myList.add("트렌스포머");
    myList.add("스타워즈");
    myList.add("매트릭스");
    myList.add("터미네이터");
    myList.add("아바타");

    System.out.print("리스트 순서 : ");
    for (String m : myList){
      System.out.print(m+"|");
    }
    System.out.println();

    System.out.print("\n오름차순 정렬 : ");
    // Collection 객체에 대한 정렬 static 메서드 sort(컬렉션)
    Collections.sort(myList);
    printList(myList);
    
    System.out.print("\n내림차순 정렬 : ");
    // Collection 객체에 대한 정렬 static 메서드 sort(컬렉션)
    Collections.reverse(myList); // 실제 Collection객체의 원소 재배치(원본 변경됨)
    printList(myList);

    System.out.println(myList.get(0));
  }
}
