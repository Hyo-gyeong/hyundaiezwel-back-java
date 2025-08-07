package oopClass.sec02;

import java.util.Scanner;

public class Rectangle {
  // int default value = 0
  // default : protected (동일 패키지)
  int width;
  int height;

  // width, height에 갑 저장하기 위한 메서드
  public void input(){
    Scanner sc = new Scanner(System.in);
    System.out.print("가로 입력 : ");
    width = sc.nextInt();
    System.out.print("높이 입력 : ");
    height = sc.nextInt();

    sc.close();
  }

  public void area(){
    System.out.println("사각형 면적 : " + this.width*this.height);
  }
}
