package genericCollection.sec15;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapStudent {
  public static void main(String[] args) {
    // 3명의 학생 점수를 Map에 저장
    // Student 클래스를 key로, 점수를 value로 저장

    // Map<Student, Integer> map = new HashMap<>(); // 입력순서 보장x
    Map<Student, Integer> map = new LinkedHashMap<>(); // 입력순서 보장o

    // map에 entry 저장시 key가 사용자 정의 클래스 인스턴스인 것 제외하고는 동일
    map.put(new Student(1, "홍길동"), 90);
    map.put(new Student(2, "홍길동"), 85);
    map.put(new Student(3, "성춘향"), 95);
    // 학번이 pk라면 수정 불가하도록 해야함
    // 하지만 new로 객체를 따로 생성해서 참조 주소가 달라서 map에 추가됨
    // Student 클래스가 상속받은 hasCode(), equals() 재정의 해서 객체 필드 값이 동일하면 동일한 객체로 처리되게끔 구현
    map.put(new Student(3, "성춘향"), 100);

    // 4명의 학생의 data가 출력 - 순서를 보장하지 않음(순서가 보장되게 하고자 하면 LinkedHashMap 사용)
    for (Student k : map.keySet()){
      System.out.println("obj hascode : " + k.hashCode());
      System.out.println(k.getStdNo() + " " + k.getStdName() + " " + map.get(k));
    }

  }
}
