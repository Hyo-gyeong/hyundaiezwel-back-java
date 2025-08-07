package genericCollection.sec06;

import java.util.ArrayList;
import java.util.List;

public class ListGenMain {
  public static void main(String[] args) {
    // 제네릭 타입으로 사용 -> List Interface 사용
    List<String> list = new ArrayList<String>();
    list.add("java");
    list.add("database");
    list.add("HTML");
    list.add("java"); // 중복저장
    // list.add(100); // error!
    
    System.out.println("총 개수 : " + list.size());
    for (int i = 0; i < list.size(); i++){
      System.out.println(list.get(i));
    }

    System.out.println();
    list.remove(1);

    for (String value : list){
      System.out.println(value);
    }

    list.add("MultiMedia");
    for (int i = 0; i < list.size(); i++){
      System.out.println(list.get(i) + ":" + list.get(i).length()); // list.get(i)가 반환하는 문자열의 메서드 length()사용
    }

    System.out.println();
    for (String value : list){
      System.out.println(value.length());
    }
  }
}
