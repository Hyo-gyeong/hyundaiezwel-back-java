package oopInheritance.pack2;

import oopInheritance.pack1.B;
//import oopInheritance.pack1.A; // 다른 패키지의 default class이므로 import불가능
// 클래스 접근제한 디폴트 : 동일 패키지만
public class C {
  B b; // 패키지가 달라도 import했고 public class이므로 접근 가능
  //A a; // import도 안되고 사용도 안됨. default class이므로 다른 패키지에서는 접근 불가
}
