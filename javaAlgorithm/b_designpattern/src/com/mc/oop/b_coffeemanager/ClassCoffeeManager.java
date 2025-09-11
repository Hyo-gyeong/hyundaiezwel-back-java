package com.mc.oop.b_coffeemanager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClassCoffeeManager {
    public static void main(String[] args) {

        Coffee[] coffees = {
            new Coffee("Americano", 1000, 500, 10, 3, 0),
            new Coffee("Mocha", 2000, 1000, 10, 3, 0),
            new Coffee("Latte", 3000, 1500, 10, 3, 0)
        };
        
        int balance = 100000;
        int salesAmount = 0;
        int expensesAmount = 0;
        
        while (true){
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("===========menu==========");
                System.out.println("판매등록(1)");
                System.out.println("현황(2)");
                System.out.println("종료(3)");

                int menu = sc.nextInt();
                
                if (menu < 1 || menu > 3){
                    System.out.println("system : 잘못 입력하셨습니다.");
                    continue;
                }
                else if (menu == 1){
                    System.out.println("===========list==========");
                    for (int i = 0; i < coffees.length; i++) {
                        System.out.println(coffees[i].getNames() + "(" + i + ")");
                    }

                    System.out.print("입력: ");
                    int drinkNo = sc.nextInt();
                    System.out.print("수량: ");
                    int orderCnt = sc.nextInt();

                    if (drinkNo < 0 || drinkNo >= coffees.length){
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                    }

                    Coffee selected = coffees[drinkNo]; // 선택한 커피 객체
                    if (orderCnt <= selected.getStocks()){
                        // 재고 충분
                        selected.deductStock(orderCnt);
                        selected.addStock(orderCnt);

                        salesAmount += orderCnt * selected.getPrices();
                        balance += orderCnt * selected.getPrices();
                    }
                    else {
                        // 재고 부족 -> 원두 구입
                        int purchasePrice = orderCnt * selected.getCosts();
                        if (purchasePrice > balance){
                            System.out.println("system : 주문을 취소합니다.");
                            continue;
                        }
                        System.out.println("system : " + selected.getNames() + " " + orderCnt +"개 매입합니다.");

                        selected.addStock(orderCnt);
                        expensesAmount += purchasePrice;
                        balance -= purchasePrice;

                        // 다시 판매 처리
                        selected.deductStock(orderCnt);
                        selected.addStock(orderCnt);

                        salesAmount += orderCnt * selected.getPrices();
                        balance += orderCnt * selected.getPrices();
                    }

                    // 안전 재고 수량 확인
                    if (selected.getStocks() <= selected.getSafetyStocks()){
                        int purchasePrice = selected.getSafetyStocks() * 2 * selected.getCosts();
                        if (balance >= purchasePrice){
                            selected.addStock(selected.getSafetyStocks() * 2);
                            balance -= purchasePrice;
                            expensesAmount += purchasePrice;
                            System.out.println("system : 안전재고 확보");
                        } else {
                            System.out.println("system : 잔고 부족으로 안전재고 확보 실패");
                        }
                    }

                    System.out.println("\n제품명 : " + selected.getNames() +
                                        "\n판매가 : " + selected.getPrices() +
                                        "\n판매수량 : " + orderCnt +
                                        "\n결제금액 : " + orderCnt * selected.getPrices() +
                                        "\n남은 재고 : " + selected.getStocks());
                }
                else if (menu == 2){
                    System.out.println("===========info==========");
                    for (int i = 0; i < coffees.length; i++){
                        Coffee c = coffees[i];
                        System.out.printf("%-10s 재고(%3d) 판매량(%3d)\n", 
                                          c.getNames(), c.getStocks(), c.getSalesCnt());
                    }
                    System.out.printf("잔고 : %4d | 매출 : %8d | 지출 %8d \n", balance, salesAmount, expensesAmount);
                }
                else {
                    System.out.println("system : 종료합니다");
                    break;
                }
            } catch (NoSuchElementException e){
                System.out.println("system : 잘못 입력하셨습니다.");
                continue;
            }
        }
    }
}
