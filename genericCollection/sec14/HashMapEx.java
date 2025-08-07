package genericCollection.sec14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {
  public static void main(String[] args) {
    // HashMap 사용 예제
    // HashMap : key의 중복 불가능, value는 중복 가능
    // (key, value) : 타이븨 데이터를 다루기 위한 콜렉션
    // key를 통해서 data를 구분함 : key의 중복을 허용하지 않기 때문에 중복 체크할 수 있는 String 타입을 주로 key로 사용
    
    // 학생 이름별 점수를 저장
    Map<String, Integer> map = new HashMap<>();

    // 저장 : put(key, value)
    map.put("홍길동", 90);
    map.put("이몽룡", 80);
    map.put("성춘향", 95); 
    map.put("홍길동", 95); // key 중복, 새로 추가되지 않고 value만 update

    System.out.println("총 객체 수 : " + map.size());

    // key에 해당되는 value 반환 : get(key)
    System.out.println(map.get("홍길동"));

    // 전체 객체 순회
    // 1. keySet사용
    // + keySet 변수 저장
    System.out.println("-----------------------------");
    Set<String> keyset = map.keySet(); // 반환하는 타입 Set : 타입을 구체화, 현재 ket는 String이므로 
    for (String k : map.keySet()){
      System.out.println(k + " : " + map.get(k));
    }
    // map.get(key) : map에 해당 키가 존재하지 않으면 반환값은?
    System.out.println(map.get("변학도")); // error발생 x, null값 반환

    // 2. forEach : key, value를 인수로 전달
    System.out.println("-----------------------------");
    map.forEach((key, value) -> {
      System.out.println(key + ":" + value);
    });
    
    // 3. entrySet() 메서드 활용 -> [key=value, ...] 집합인 entry를 Set타입으로 반환
    System.out.println("-----------------------------");
    for (Entry<String, Integer> entry : map.entrySet()){
      String key = entry.getKey();
      int value = entry.getValue();
      System.out.println(key + ":" + value);
    }
    
    System.out.println("map.entrySet() = " + map.entrySet());
    System.out.println("-----------------------------");
  }
}
