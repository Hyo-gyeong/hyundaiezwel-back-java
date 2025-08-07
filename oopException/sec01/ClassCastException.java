package oopException.sec01;

public class ClassCastException {
  public static void main(String[] args) {
    // 사용자 정의 클래스에 강제 형변환 연산을 진행할 때
    Dog dog = new Dog();
    // Dog 객체 참조 인수 전달 -> 자동 형변환 발생, Animal타입으로 변경된 후 Dog타입으로 강제 변환 가능
    ChangeDog(dog); 

    // Cat 객체가 참조 인수로 전달 -> 자동 형변환 발생, Animal 타입으로 변경은 되었지만 Dog타입으로 강제 변환은 불가능
    Cat cat = new Cat();
    // ChangeDog(cat); // java.lang.ClassCastException

    // => 문법적으로 문제가 없지만 컴파일시 에러가 나는 것들은 전부 예외처리를 해줘야 함
  }

  public static void ChangeDog(Animal animal){
    Dog dog = (Dog) animal;
  }
}

class Animal{
}

class Dog extends Animal{
}

class Cat extends Animal{
}
