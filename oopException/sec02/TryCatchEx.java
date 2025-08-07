package oopException.sec02;

public class TryCatchEx {
  public static void main(String[] args) {
    // try - catch - finally(생략가능, 무조건 실행)
    int[] arr = {1,2,3};
    try{
      // 예외처리 안하면 예외 발생하고 프로그램 끝남
      // catch에서 받아주는 예외만 처리해서
      System.out.println(arr[5]); // 예외가 발생했고 처리를 해줬다면 try의 다음 코드에 대한 실행과 예외처리는 발생x

      // 클래스 존재여부 확인
      /* Returns a Class Object: Upon successful loading,
        Class.forName() returns a Class object representing the loaded class. */
      Class class1 = Class.forName("java.lang.Strings");
      System.out.println("클래스가 존재합니다.");
    }catch(ArrayIndexOutOfBoundsException e){
      // ArrayIndexOutOfBoundsException 예외가 발생하지 않으면 다음 예외 처리가됨
      System.out.println("인덱스에서 벗어납니다.");
    }catch(ClassNotFoundException e){
      // ClassNotFoundException 예외 발생 한 경우 정상 종료
      System.out.println("클래스가 존재하지 않습니다.");
    }finally{ // 에러 나든 안나든 무조건 실행됨
      System.out.println("프로그램이 종료됩니다.");
    }
  }
  // catch 블록은 다중으로 정의 가능하고 단 하나만 실행되며 try블록에서는 이후의 코드는 예외가 있든 없든 실행되지 않음
}
