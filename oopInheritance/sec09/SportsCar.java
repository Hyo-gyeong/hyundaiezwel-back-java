package oopInheritance.sec09;

public class SportsCar extends MyCar{ // MyCar이 final이라서 상속 불가능

  @Override
  public void speedUp(){ // MyCar이 final이라서 재정의 불가능 해서 에러남
    speed += 10;
  }

  @Override
  public void stop(){ // final로 지정되어있으므로 재정의 불가능
    System.out.println("스포츠카를 멈춤");
    speed = 0;
  }
  
}
