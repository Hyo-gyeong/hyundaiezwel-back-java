package genericCollection.sec07;

import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeMain {
  public static void main(String[] args) {
    // 사용자 정의 클래스 타입 사용

    ArrayList<Employee> list = new ArrayList<>();

    Employee e1 = new Employee(100, "김사원", 3000);
    Employee e2 = new Employee(101, "이대리", 5000);

    list.add(e1);
    list.add(e2);
    list.add(new Employee(102, "박과장", 7000)); // 직접 넣을 수 있음

    for (int i = 0; i < list.size(); i++){
      Employee emp = list.get(i);
      System.out.println(emp.toString());
    }

    for (Employee e : list){
      System.out.println(e.toString());
    }

    System.out.println();
    // Iterator 사용해서 출력
    // 맨 처음엔 list의 시작점을 가리킴(0번 인덱스 값이 아닌 첫 번째 요소 바로 "앞"을 가리킴)
    Iterator<Employee> it = list.iterator();
    while(it.hasNext()){ // 현 시작점 요소가 있는지 확인
      System.out.println(it.next()); // 포인터 옮기고 그 위치의 요소 get
    }
    
  }
}
