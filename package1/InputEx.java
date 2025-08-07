package package1;
// Scanner 클래스를 활용해서 입력 사용 가능 - 객체참조변수 생성 후 사용
import java.util.Scanner;

// Scanner
public class InputEx {
  public static void main(String[] args) {
    // ()안에 필수적으로 입력 장치를 써줘야함.
    // System.in이 기본. 키보드.
    Scanner sc = new Scanner(System.in); // 키보드 입력이므로 문자형이 입력됨
    int num1;
    int num2;
    System.out.print("숫자 1 입력: ");
    num1 = sc.nextInt(); // 입력한 값을 정수로 반환
    System.out.print("숫자 2 입력: ");
    num2 = sc.nextInt();

    System.out.println("두 수의 합 :" + (num1+num2));

    // 실수 입력
    sc.nextFloat();

    // 문자 입력
    sc.next(); // 문자가 기본 입력이니까

    // Scanner 객체는 메모리를 할당받기 때문에 사용 후에는 해제해야 함
    sc.close();
  }
}
