package oopClass.sec03;

class TV { // 동일 파일 내에서는 public class 한개만, protected가 기본값
  String color; // protected가 기본값
  boolean power;
  int channel;
  
  void power() {
    power = !power;
  }

  void channelUp(){
    ++channel;
  }

  void channelDown() {
    --channel;
  }
  
}
public class TVMain {
  public static void main(String[] args) {
    TV tv; // 참조변수만 선언
    tv = new TV();

    // 멤버변수 접근
    tv.color = "black";
    System.out.println("색상 : " + tv.color);
    
    // 멤버 메소드 접근
    System.out.println("전원 : " + tv.power);
    tv.power();
    System.out.println("전원 : " + tv.power);
    
    // 멤버변수 접근
    tv.channel = 7;
    tv.channelDown();
    System.out.println("채널 : " + tv.channel);

  }
}
