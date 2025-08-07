package oopClass.sec05;

public class Tv {
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
