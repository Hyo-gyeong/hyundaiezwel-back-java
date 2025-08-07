package genericCollection.sec12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetStringEx {
  public static void main(String[] args) {
    // HashSet의 중복 객체 저장 불가 확인
    // String 객체를 통해 확인
    Set<String> set = new HashSet<>(); // generic

    // Set은 get()이나 idx 사용하는 메소드 없음, 순서 보장x
    // String 클래스는 문자열 값이 같은 경우 동등객체가 될 수 있도록 hashCode()/equals() 메소드가 재정의 되어 있음
    // 따라서 obj 객체가 아닌 문자열 객체를 만들면 동일한 문자열인 경우 동등 객체로 봄
    set.add("Java");
    set.add("JDBC");
    set.add("Servlet/JSP");
    set.add("Java"); // 동일 데이터는 한 번만 추가됨
    set.add("MyBatis");

    int size = set.size();
    System.out.println("총 객체수 : " + size);

    // set은 idx가 없으므로 반복 순회 위해서 iterator()통해서 반복자 얻을 수 있음
    Iterator<String> iterator = set.iterator();
    while(iterator.hasNext()){
      String ele = iterator.next();
      System.out.println("\t  "+ele);
    }

    set.remove("JDBC"); // 객체를 전달해서 삭제
    set.remove("MyBatis");

    size = set.size();
    System.out.println("총 객체수 : " + size);
    // iterator 없이 순회
    for(String ele : set){
      System.out.println("\t  "+ele);
    }

    set.clear(); // 모든 객체 제거하고 비움
    if (set.isEmpty()){
      System.out.println("비어있음");
    }
  }
}
