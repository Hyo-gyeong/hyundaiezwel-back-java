package genericCollection.sec06;

import java.util.List;
import java.util.Arrays;

public class AsListMain {
  public static void main(String[] args) {
    // Arrays 클래스의 asList메서드 : 초기화된 List 생성
    List<String> list1 = Arrays.asList("홍길동", "이몽룡", "성춘향");
    for (String name : list1){
      System.out.println(name);
    }

    // asList : 고정됨
    List<Integer> list2 = Arrays.asList(1,2,3,4,5,4,3,2,4,5,12,3,1,3);
    for (Integer no : list2){
      System.out.println(no);
    }

    list2.set(1, 5); // 변경 가능
    for (int no : list2){
      System.out.println(no);
    }

    list2.add(10); // error! java.lang.UnsupportedOperationException
    for (int no : list2){
      System.out.println(no);
    }
  }
}
