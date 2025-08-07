package genericCollection.sec03;

public class ProductMain {
  public static void main(String[] args) {
    Product<TV, String> product1 = new Product<>();
    Product<Car, String> product2 = new Product<>();

    product1.setKind(new TV());
    product1.setModel("스마트 TV");
    product2.setKind(new Car());
    product2.setModel("디젤");

    String tvModel = product1.getModel();
    String carModel = product2.getModel();

    System.out.println(tvModel + " " + carModel);
  }
}
