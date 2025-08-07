package oopInheritance.sec09;

public final class MyCar {
  public int speed;

  public void speedUp(){
    speed++;
  }

  public void speedDown(){
    if (speed > 0){
      speed--;
    } else{
      speed = 0;
    }
  }

  // final로 정의했기 때문에 subclass에서 override불가능 -> 수정할 수 없음
  public final void stop(){
    System.out.println("차를 멈춤");
    speed = 0;
  }
}
