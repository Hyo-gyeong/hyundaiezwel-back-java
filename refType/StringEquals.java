package refType;

public class StringEquals {
  public static void main(String[] args) {
    // 문자열 객체 생성 1
    String strVar1 = "홍길동";
    String strVar2 = "홍길동";

    if (strVar1 == strVar2){
      System.out.println("strVar1과 strVar2는 참조가 같음");
    } else {
      System.out.println("strVar1과 strVar2는 참조가 다름");
    }
    
    // 참조 객체의 값이 같은지 확인하는 메소드 equals
    if (strVar1.equals(strVar2)){
      System.out.println("strVar1과 strVar2는 저장된 문자열 값이 같음");
    } else {
      System.out.println("strVar1과 strVar2는 저장된 문자열 값이 다름");
    }

    String strVar3 = new String("홍길동");
    String strVar4 = new String("홍길동");

    if (strVar3 == strVar4){
      System.out.println("strVar1과 strVar2는 참조가 같음");
    } else {
      System.out.println("strVar1과 strVar2는 참조가 다름");
    }
    if (strVar3.equals(strVar4)){
      System.out.println("strVar1과 strVar2는 저장된 문자열 값이 같음");
    } else {
      System.out.println("strVar1과 strVar2는 저장된 문자열 값이 다름");
    }

  }
}
