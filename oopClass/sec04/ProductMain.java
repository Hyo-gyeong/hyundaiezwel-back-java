package oopClass.sec04;

import java.util.Scanner;
public class ProductMain {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print( "상품명 : ");
    String name = sc.next();
    System.out.print( "가격 : ");
    int price = sc.nextInt();
    System.out.print( "판매 수량 : ");
    int sold = sc.nextInt();
    System.out.print( "재고 수량 : ");
    int stock = sc.nextInt();

    Product prd = new Product();
    prd.inputPrdInfo(name, price, sold, stock);
    prd.showPrdInfo();

    sc.close();
  }
}
