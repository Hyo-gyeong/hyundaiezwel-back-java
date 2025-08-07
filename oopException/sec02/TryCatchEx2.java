package oopException.sec02;

class Animal{}
class Dog extends Animal {}
class Cat extends Animal {}

public class TryCatchEx2 {
  public static void main(String[] args) {
    Dog dog = new Dog();
    Cat cat = new Cat();
    try {
      // 오류 유추 가능한 코드 넣음
      ChangeDog(dog);
      ChangeDog(cat); 
    } catch (ClassCastException e){
      System.out.println("변환할 수 없는 타입 입니다." + e);
    }

  }

  public static void ChangeDog(Animal animal){
    Dog dog = (Dog) animal;
  }
}
