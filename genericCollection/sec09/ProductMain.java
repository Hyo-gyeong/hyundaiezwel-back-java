package genericCollection.sec09;

import java.util.LinkedList;

public class ProductMain {
  public static void main(String[] args) {
    LinkedList<Product> prdList = new LinkedList<>();
    
    prdList.add(new Product("칙촉", 3000, "과자"));
    prdList.add(new Product("탄산수", 1000, "음료"));
    prdList.add(new Product("딸기", 10000, "과일"));

    System.out.println(prdList.toString());
  }
}
