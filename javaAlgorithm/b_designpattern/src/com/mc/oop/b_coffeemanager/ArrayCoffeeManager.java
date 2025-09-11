package com.mc.oop.b_coffeemanager;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayCoffeeManager {
    public static void main(String[] args) {
        String[] names = {"Americano","Mocha","Latte"};
        int[] prices = {1000, 2000, 3000};
        int[] costs = {500,100,1500};
        int[] stocks = {10,10,10};
        int[] safetyStocks = {3,3,3};
        int[] salesCnt = {0,0,0};
        
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
                    System.out.println("americano(0)");
                    System.out.println("mocha(1)");
                    System.out.println("latte(2)");

                    System.out.print("입력: ");
                    int drinkNo = sc.nextInt();
                    System.out.print("수량: ");
                    int orderCnt = sc.nextInt();

                    if (drinkNo < 0 || drinkNo > 2){
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                    }
                    if (orderCnt <= stocks[drinkNo]){
                        stocks[drinkNo] -= orderCnt;
                        salesAmount += orderCnt * costs[drinkNo];
                        balance = orderCnt * costs[drinkNo];
                    }
                    else {
                        int purchasePrice = orderCnt * costs[drinkNo];
                        if (purchasePrice >= balance){
                            System.out.println("system : 주문을 취소합니다.");
                            continue;
                        }
                        System.out.println("system : " + names[drinkNo] +" "+orderCnt +"개 매입합니다.");
                        stocks[drinkNo] += orderCnt;
                        expensesAmount += purchasePrice;
                        balance -= purchasePrice;

                        stocks[drinkNo] -=orderCnt;
                        salesAmount += orderCnt * prices[drinkNo];
                        balance += orderCnt * prices[drinkNo];
                    }
                    // 안전 재고 수량 확인
                    if (stocks[drinkNo] <= safetyStocks[drinkNo]){
                        int purchasePrice = safetyStocks[drinkNo] * 2 * costs[drinkNo];
                        if (balance >= purchasePrice){
                            stocks[drinkNo] += safetyStocks[drinkNo]*2;
                            balance -= purchasePrice;
                            expensesAmount += purchasePrice;
                            System.out.println("system : 안전재고 확보");
                        } else {
                            System.out.println("system : 잔고 부족으로 안전재고 확보 실패");
                        }
                    }
                    System.out.println("\n제품명 : " + names[drinkNo] +
                                        "\n판매가 : " + prices[drinkNo] +
                                        "\n판매수량 : " + orderCnt +
                                        "\n결제금액 : " + orderCnt*prices[drinkNo] +
                                        "\n남은 재고 : " + stocks[drinkNo]);
                }
                else if (menu == 2){
                    System.out.println("===========info==========");
                    for (int i = 0; i < names.length; i++){
                        System.out.printf("%-10s 재고(%3d) 판매량(%3d)\n", names[i], stocks[i], salesCnt[i]);
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
