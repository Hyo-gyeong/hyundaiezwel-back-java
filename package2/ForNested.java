package package2;

public class ForNested {
  // static : JVM이 클래스 인스턴스를 생성하지 않고도 실행할 수 있어야 하기 때문.
  // Java 프로그램의 실행은 JVM이 main() 메서드를 호출하면서 시작됩니다.
  // 그런데 JVM이 프로그램을 시작할 때, 아직 어떤 객체도 생성되지 않은 상태입니다.
  // 따라서 객체를 만들지 않고도 호출할 수 있어야 하므로 main()은 static으로 선언되어야 합니다.
  // 비유: 왜 static이어야 할까?
  // 프로그램 시작 전에는 아직 **설계도(클래스)**만 있고 **집(객체)**은 없는 상태입니다.
  // 그런데 main()이 객체 메서드면 집이 있어야 실행할 수 있죠.
  // 그래서 설계도만 보고도 실행 가능한 정적(static) 메서드여야 합니다.
  // static 메서드는 클래스 로딩 시점에 바로 메모리에 올라가므로, 객체 없이도 접근 가능 
  public static void main(String[] args) {
    for (int i = 1; i < 10; i++){
      for (int j = 2; j < 10; j++){
        System.err.print(j + " * " + i + " = " + (i*j) + "\t");
      }
      System.err.println();
    }
  }
}
