package package2;

public class Operators {
  public static void main(String[] args) {
    // 자바 연산자 정리
    short a = 100;
    short b = -100;

    // short result = -a; // short type 변수 a에 부호연산자 -를 적용하면 반환 타입은 int
                        // 이걸 short에 넣으라는거니까 type mismatch 발생

    // 증감 연산자 ++ -- : 변수의 값 1증가 또는 감소
    // 연산식에 증감연산만 있는 경우
    int x = 10;
    x++; // 11
    // System.out.println(x);
    ++x; // 12
    // System.out.println(x);
    
    // 연산식에 증감연산과 다른 연산이 같이 있는 경우
    int x1 = 10;
    int y1 = 0;
    y1 = x1++; // 나중에 증가됨
    // System.out.println(y1);
    y1 = ++x1; // 먼저 증가되고 대입됨
    // System.out.println(y1);

    x = 1;
    int y = 1;
    // System.out.println(++x + 10); // 12
    // System.out.println(y++); // 1
    // System.out.println(y); // 2

    // 이항 연산자 : + - * / %
    // 주의 할 점 : 연산에서 오버플로우 발생 가능 (결과값이 너무 커서 대입이 제대로 일어나지 않음)

    int x2 = 1000000;
    int y2 = 1000000;

    int z2 = x2 * y2; // 조단위
    // System.out.println(z2); // 오버플로우가 일어나면서 음수값이 출력됨
    // 피연산자 단위가 크면 결과 저장할 변수의 타입을 크게 잡아야 함
    // long z3 = x2 * y2; // int * int는 int로 계산됨 -> 연산 자체에서 이미 오버플로우가 발생한 상태로 z3에 대입됨
    long z3 = (long)x2 * y2; // 형변환이 먼저 되어야 함. 아니면 x2, y2를 long으로 잡거나
    // System.out.println(z3); 

    // 연산 또는 %연산일 경우
    // 정수 0 또는 실수 0으로 나누는 경우 - 예외 발생하거나 Infinity 출력됨
    // System.out.println(3/0); // Exception in thread "main" java.lang.ArithmeticException: / by zero
    // System.out.println(3/0.0); // Infinity
    // System.out.println(3%0); // Exception in thread "main" java.lang.ArithmeticException: / by zero
    // System.out.println(3%0.0); // NaN : Not a Number

    // + 문자열 연결 연산
    String city = "서울시";
    String gu = "강남구";
    System.out.println(city+" "+gu);

    // 비교 연산자 : ==, != -> boolean type반환
    // System.out.println(x2 == y2);
    // System.out.println(x2 != y2);
    
    // 문자열 비교 - 문자열 변수는 참조변수이므로 참조값(주소)을 저장하고 있음
    // System.out.println(city == gu); // city의 값과 gu의 값이 같은지의 여부를 판단하지 않음 - 변수가 참조하는 주소가 같은지 판단
    // System.out.println(city != gu); // city의 값과 gu의 값이 다른지의 여부를 판단하지 않음 - 변수가 참조하는 주소가 다른지 판단

    String name1 = "홍길동";
    String name2 = "홍길동";
    // 각 변수에 저장된 값이 저장되어 있는지 비교 연산
    System.out.println(name1 == name2); // 주소 비교, true : 자바에서 문자열 리터럴의 문자열 풀(String Pool)이라는 개념 때문 - 보안 취약점이기도 함
    String name11 = new String("홍길동");
    String name22 = new String("홍길동");

    System.out.println(name11 == name22); // 주소 비교, false! :  항상 새로운 객체를 생성하므로, 참조가 다르기 때문에 ==는 false를 반환


    // 문자열 객체 메소드 equals를 활용해서 값을 비교하는 기능, 문자열을 반드시 이렇게 비교해야함
    System.out.println(name1.equals(name2)); // 값 비교, true!

    // 논리 연산자 : && || ! ^(XOR) -> boolean 반환
    // 1) 비트 논리 연산자 : & | ~ ^
    System.out.println(45 & 25); // 45 = 00101101 (2)
                                 // 25 = 00011001 (2)
                                 // ------------------
                                 // &    00001001 (2) => 8 + 1 = 9

    System.out.println(45 | 25); // 45 = 00101101 (2)
                                 // 25 = 00011001 (2)
                                 // ------------------
                                 // &    00111101 (2) => 32 + 16 + 8 + 4 + 1 = 61

    System.out.println(~45);     // 45 = 00000000 00000000 00000000 00101101 (2) - 정수는 32비트니까 
                                 // ------------------
                                 // ~    11111111 11111111 11111111 11010010 (2) - 2의 보수에서 맨 앞 비트가 1이면 음수, ???????
    // 2) 비트 산술 연산자 : <<, >>
    // a<<b : a값을 비트표현하고 왼쪽으로 b만큼 이동, a>>b : a값을 비트표현하고 오른쪽으로 b만큼 이동
    // 오른쪽으로 이동하면 왼쪽 빈칸을 부호비트와 같은 값으로 채움
    System.out.println(1<<3); // 1 -> 1000
    System.out.println(8>>3); // 8 -> 1

    // 대입 연산자
    int xVal = 100;
    // 누적 대입 연산자 -> &= |= ^= <<= >>= 가능
    xVal += 100;
    System.err.println(xVal);

    // 삼항 연산자 : 조건식 ? 값 또는 연산식 : 값 또는 연산식 => if ~ else 구문을 연산자로
    int score = 95;
    char grade = (score > 90) ? 'A' : 'B';
    
    // () 연산자
    byte score_sub = (byte) score; // 이것도 연산으로 봄
  }
}
