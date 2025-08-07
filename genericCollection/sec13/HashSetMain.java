package genericCollection.sec13;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
  public static void main(String[] args) {
    // Member class 인스턴스 HashSet에 저장
    Set<Member> set = new HashSet<Member>();

    // 동일값이 필드에 저장되지만 객체의 참조 주소가 다르기 때문에 각각 다른 객체로 봄
    set.add(new Member("홍길동", 30));
    set.add(new Member("홍길동", 30));

    System.out.println("총 객체수 : " + set.size());

    // Member2 클래스 객체는 필드값이 완전히 동일하면 동일한 객체로 보고 중복저장 되지 않도록 구현
    Set<Member2> set2 = new HashSet<Member2>();

    set2.add(new Member2("홍길동", 30));
    set2.add(new Member2("홍길동", 30));

    System.out.println("총 객체수 : " + set2.size());
  }
}
