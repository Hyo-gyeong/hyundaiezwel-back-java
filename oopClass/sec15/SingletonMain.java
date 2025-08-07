package oopClass.sec15;

public class SingletonMain {
  public static void main(String[] args) {
    // Singleton obj1 = new Singleton(); // private으로 정의해서 외부에서 생성 불가
    
    // 객체가 필요한 경우 getter사용
    // obj1과 obj2는 참조변수가 같음
    Singleton obj1 = Singleton.getSingleton();
    Singleton obj2 = Singleton.getSingleton();

    if (obj1 == obj2){
      System.out.println("same");
    } else {
      System.out.println("different");
    }
  }
}
