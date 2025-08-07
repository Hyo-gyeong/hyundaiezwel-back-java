package genericCollection.sec06;

import java.util.ArrayList;

public class ArrayListMain {

  // @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    // ArrayList Collection : 제네릭이 아닌 경우
    ArrayList list = new ArrayList();

    // 전부 Object타입으로 형변환 되어 들어가는 상태 
    list.add(100);
    list.add("홍길동");
    list.add(7.7);
    list.add("자바");
    list.add("자바"); // 중복 가능

    // 순서 보장
    for (int i = 0; i < list.size(); i++){
      System.out.println(list.get(i));
    }

    System.out.println("---------------------------");
    list.add(0, "변경");
    // 해당 위치에 추가하고 기존 값들은 밀림
    // 변경이 자주 일어나는 경우에는 성능 저하 발생 가능
    for (int i = 0; i < list.size(); i++){
      System.out.println(list.get(i));
    }

    System.out.println("---------------------------");
    // 한 칸씩 앞으로 밀림 - 성능 저하
    list.remove(0);
    for (int i = 0; i < list.size(); i++){
      System.out.println(list.get(i));
    }
    
    System.out.println("---------------------------");
    System.out.println(list.contains("홍길동")); // return boolean
    
    System.out.println("사용 예시)");
    if (list.contains("이몽룡")){
      list.add("이몽룡");
      for (int i = 0; i < list.size(); i++){
        System.out.println(list.get(i));
      }
    }

    System.out.println("---------------------------");
  }
}