package oopException.sec03;

public class CatchOrderEx {
  public static void main(String[] args) {
    // 다중 catch 구문 있을 시 catch 순서
    try {
      String data = "a3";
      int arr[] = {1,2,3};
      int var1 = Integer.parseInt(data);
      int var2 = arr[5];
      System.out.println(var1+10);

    // 에러 없이 잘 돌아가는 예외처리
    } catch (NumberFormatException e){
      System.out.println("오류 발생 : 변화 오류");
    } catch (Exception e){
      System.out.println("오류 발생 : 상위 클래스");
    }
    
    // 에러 발생하는 예외처리
    // 모든 예외 처리 클래스는 Exception 클래스를 상속받아서 구현되어 있으므로
    // 상위 클래스인 Exception이 모든 예외를 처리해서 아래에 정의된 예외처리까지 도달하지 못함
    // 하위 클래스의 catch 블록을 위에서 처리해야함
    /*
    } catch (Exception e){ // 맨 밑에서 처리해야함
      System.out.println("오류 발생 : 상위 클래스");
    } catch (NumberFormatException e){ // error! : Unreachable catch block for NumberFormatException
      System.out.println("오류 발생 : 변화 오류");
    }
    */
  }
}
