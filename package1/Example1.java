package package1;

import java.nio.channels.Pipe;

public class Example1 {
  public static void main(String[] args){
    // 자바 변수 : type을 표현해야 함
    int value1; /* 변수 선언 */
    value1 = 10; /* 변수에 값 대입 */
    int value = 10; //선언과 동시에 초기화
    int result = value1 + 10; // 

    System.out.println(result);

    // 자바 상수 : 실행 중 값 기억 임시 기억장소 (변수오 같음) 대입 후 실행 중 값이 변하지 않음
    // final [type] [상수명]
    // 변수와 구분하기 위해서 대문자로 명명
    final int PRICE = 1000;
    // PRICE = 300; // The final local variable PRICE cannot be assigned.

    // 리터럴 : 변수에 저장되는 값
    // 정수, 실수, 문자, 문자열, 논리 리터럴
    value = 50; // 50은 정수형 리터럴
    float valf = 50.2f; // 실수 리터럴, f안쓰면 'Type mismatch: cannot convert from double to float'에러남
    char valch = 'c'; // 문자 리터럴
    String str = "abc"; // 문자열 리터럴
    boolean a = true; // 논리 리터럴
    boolean b = false; // 논리 리터럴

    // 데이터 타입
    // 기본 타입 : byte/short/int/long  float/double  boolean   char(엄밀히 말하면 정수타입에 들어감)
    // 참조형 : 기본 타입 제외 나머지 모두 String

    int inta = 10; // int가 기본타입, 0이 기본값, 4byte
    double bdouble = 5.2; //double이 기본타입, 0.0d이 기본값, 8byte
    char chr = 'A'; // char가 기본타입, '\u0000' 기본값, 2byte
    boolean bool = true; // 얘밖에 없으니까 boolean이 기본타입, false가 기본값, 1byte

    long lint = 100L; //L붙이는게 권장, 8byte, 정수범위 안에서는 L이 필수가 아님
    long lint2 = 1000100010001000L; // int크기를 넘어가는 데이터를 저장하려면 L이 필수
    float flt = 5.3f; //double이 기본이고 반드시 f를 붙여야 함, 4byte
    short sint = 10; // 2byte
    byte bint = 1; //1byte, 첫 번쨰 비트 부로 사용하면 나머지 7개를 가지고 숫자 표현

    // 데이터 타입에 따라 사용 메모리 크기가 다름
    // 메모리 최소 단위 : bit -> 0/1  => 8개가 모여 데이터 구성 최소 단위 : 1byte
    // byte : -2^7 ~ 2^7-1 = -128 ~ 127
    // int -2,147,483,648부터 2,147,483,647 까지

    // 실수 저장 - 저장 방식이 정수형과 다르기 때문에 정수 타입보다 훨씬 큰 범위의 값 저장 가능
    // 부동 소수점 방식으로 저장 : 실수를 컴퓨터상에서 근사하여 표현할 때 소수점의 위치를 고정하지 않고 그 위치를 나타내는 수를 따로 적는 것
    // [부호비트] [지수부] [가수부]
    // 4byte 부호비트(1) 지수부 (8비트) 가수부(23비트)
    // 8byte 부호비트(1) 지수부 (11비트) 가수부(52비트)
    // ex) 십진수 12.375를 부동소수점 방식으로 표현하면 1.2375 * 10^1
    // ex) 십진수 314.1592를 부동소수점 방식으로 표현하면 3.141295 * 10^2;
    // ex) 십진수 0.0165를 부동소수점 방식으로 표현하면 1.65 * 10^-2;
    float avg = 88.5f; // f기호 필수, 
    double avg1 = 88.5;
    //  e 사용해서 실수 표현
    double var3 = 3e6; // 3뒤로   0을 6개 추가 : 3000000
    float var4 = 2e-3f; //2앞으로 0을 3개 추가 -> 소수점 이하 3자리 0.002

    System.out.println(var4);
    System.out.println(true);

    // String 타입(문자열) - 레퍼런스 타입
    String name = "홍길동";
    char firstName = '홍'; // 기본타입
    System.out.println(name);
    System.out.println(firstName);
  }
}
