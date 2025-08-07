package package1;

public class TypeCasting {
  public static void main(String[] args) {
    // 타입 변환
    // 데이터 타입을 다른 타입으로 변환하는 것
    // 1. 묵시적 타입 변환(Promotion) - 자동
    // 2. 명시적 타입 변환(Casting) - 강제
    // 타입변환은 변수의 타입이 저장하고자 하는 리터럴 크기보다 크거나 작을 때
    
    // 자동 타입 변환 : 작은 크기의 타입이 큰 크기의 타입으로 저장될 때
    // long 형을 float형에 저장할 수 있나? 8byte를 4byte에 저장?
    // => byte 크기가 아닌 값의 표현 범위에 따라 규정됨
    // byte < short < int < long < float < double

    // 자동 타입 변환
    byte byteVal = 10;
    int intVal = byteVal; // 모두 정수타입이며 int가 더 큰 범위를 갖으므로 int로 형변환됨
    System.out.println(intVal);
    
    char chrVal = '가';
    intVal = chrVal; // 2byte크기의 char가 4byte int변수에 저장하는거니까 
    System.out.println(intVal); // 44032 - 한글 '가'의 unicode
    
    long lngVal = 258960; // 8byte
    float flVal = lngVal; // 4byte - 값의 표현 범위는 충분하기 때문에 자동 형변환 가능
    System.out.println(flVal); // 258960.0

    // 강제 타입 변환 - 데이터 손실 가능
    //intVal = flVal; // float혀의 표현 범위가 int형보다 크므로 큰 범위의 ㅍ현이 작은 범위로 대입 불가능 -> 강제 형변환 일으킬 수 있음
    intVal  = (int) flVal; // (int)리터럴 또는 변수 -> int형으로 강제 타입 변환 발생하게 됨. 이때 표현할 수 없으면 잘라버림
    System.out.println(intVal); // 258960 -> .0은 배제시킴
    flVal = 25.369847f;
    System.out.println(intVal); // 25 - 데이터 손실

    intVal = 103029770;
    byte byteValue = (byte)intVal; // 정수를 바이트타입에 저장 (큰 타입을 작은 타입에)
    System.out.println(byteValue); // byte가 담을 수 있는 범위 외의 수는 사라짐

    intVal = 44032;
    // char로 표현할 수 있는 값이지만 int가 표현할 수 있는 모든 자리수에 0이 들어가있고 이를 마음대로 자르면 안되기 때문에 강제 형변환을 하지 않으면 에러가 남
    chrVal = (char) intVal;
    System.out.println(chrVal);

    // 강제 타입 변환 시 주의
    // 값의 손실 발생 타입 범위 확인해서 형변환 결정
    // 기본타입에 대해서 자바는 객체로 구성해놓음
    // 기본타입객체.MIN_VALUE / .MAX_VALUE 범위 안으로 들어오는지 확인할 필요가 있음
    // 정밀도 손실 발생 가능
    // float의 가수 23bit보다 큰 int값을 float으로 변환할 때 손실 발생 -> int를 실수로 변경하려면 double을 사용하는게 더 안전

    // 연산식에서 자동 타입 변환
    int intVal1 = 10;
    double doubleVal1 = 5.5;
    
    double result = intVal1 + doubleVal1; // 정수 + 실수 -> 정수를 실수로 형변환 후 연산

    int intVal4 = intVal1 / 4; // 정수 / 정수 -> 정수
    intVal4 = (int) result; // 강제 형변환 해야함

    System.out.println(intVal4); // 2
    System.out.println(intVal4/4.0); // 0.5 : 정수 / 실수 -> 실수
    // intVal4 = intVal4 / 4.0; // 정수 / 실수 값은 double이 반환되기 때문에 정수로 자동 형변환 불가능 'Type mismatch: cannot convert from double to int'
    intVal4 = (int) (intVal4 / 4.0); // 강제 타입 변환을 하면 가능하지만 0.5라는 데이터는 손실됨
    System.out.println(intVal4);
  }
}
