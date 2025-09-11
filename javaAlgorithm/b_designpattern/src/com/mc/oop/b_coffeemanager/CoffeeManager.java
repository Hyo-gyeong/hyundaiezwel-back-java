package com.mc.oop.b_coffeemanager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CoffeeManager {
    public static void main(String[] args) {
        String americanoName = "Americano";
        int americanoPrice = 1000;
        int americanoCost = 500;
        int americanoStock = 10;
        int americanoSafetyStock = 3;
        int americanoSalesCnt = 0;
        
        String mochaName = "Mocha";
        int mochaPrice = 2000;
        int mochaCost = 1000;
        int mochaStock = 10;
        int mochaSafetyStock = 3;
        int mochaSalesCnt = 0;
        
        String latteName = "Latte";
        int lattePrice = 3000;
        int latteCost = 1500;
        int latteStock = 10;
        int latteSafetyStock = 3;
        int latteSalesCnt = 0;
        
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
                    if (drinkNo == 0){
                        if (orderCnt <= americanoStock){
                            americanoStock -= orderCnt;
                            salesAmount += orderCnt * americanoCost;
                            balance = orderCnt * americanoCost;
                        }
                        else {
                            int purchasePrice = orderCnt * americanoCost;
                            if (purchasePrice >= balance){
                                System.out.println("system : 주문을 취소합니다.");
                                continue;
                            }
                            System.out.println("system : " + americanoName +" "+orderCnt +"개 매입합니다.");
                            americanoStock += orderCnt;
                            expensesAmount += purchasePrice;
                            balance -= purchasePrice;

                            americanoStock -=orderCnt;
                            salesAmount += orderCnt * americanoPrice;
                            balance += orderCnt * americanoPrice;
                        }
                        // 안전 재고 수량 확인
                        if (americanoStock <= americanoSafetyStock){
                            int purchasePrice = americanoSafetyStock * 2 * americanoCost;
                            if (balance >= purchasePrice){
                                americanoStock += americanoSafetyStock*2;
                                balance -= purchasePrice;
                                expensesAmount += purchasePrice;
                                System.out.println("system : 안전재고 확보");
                            } else {
                                System.out.println("system : 잔고 부족으로 안전재고 확보 실패");
                            }
                        }
                        System.out.println("\n제품명 : " + americanoName +
                                            "\n판매가 : " + americanoPrice +
                                            "\n판매수량 : " + orderCnt +
                                            "\n결제금액 : " + orderCnt*americanoPrice +
                                            "\n남은 재고 : " + americanoStock);
                    }else if (drinkNo == 1){
                        if (orderCnt <= mochaStock){
                            mochaStock -= orderCnt;
                            salesAmount += orderCnt * mochaCost;
                            balance = orderCnt * mochaCost;
                        }
                        else {
                            int purchasePrice = orderCnt * mochaCost;
                            if (purchasePrice >= balance){
                                System.out.println("system : 주문을 취소합니다.");
                                continue;
                            }
                            System.out.println("system : " + mochaName +" "+orderCnt +"개 매입합니다.");
                            mochaStock += orderCnt;
                            expensesAmount += purchasePrice;
                            balance -= purchasePrice;

                            mochaStock -=orderCnt;
                            salesAmount += orderCnt * mochaPrice;
                            balance += orderCnt * mochaPrice;
                        }
                        // 안전 재고 수량 확인
                        if (mochaStock <= mochaSafetyStock){
                            int purchasePrice = mochaSafetyStock * 2 * mochaCost;
                            if (balance >= purchasePrice){
                                mochaStock += mochaSafetyStock*2;
                                balance -= purchasePrice;
                                expensesAmount += purchasePrice;
                                System.out.println("system : 안전재고 확보");
                            } else {
                                System.out.println("system : 잔고 부족으로 안전재고 확보 실패");
                            }
                        }
                        System.out.println("\n제품명 : " + mochaName +
                                            "\n판매가 : " + mochaPrice +
                                            "\n판매수량 : " + orderCnt +
                                            "\n결제금액 : " + orderCnt*mochaPrice +
                                            "\n남은 재고 : " + mochaStock);
                    } else {
                        if (orderCnt <= latteStock){
                            latteStock -= orderCnt;
                            salesAmount += orderCnt * latteCost;
                            balance = orderCnt * latteCost;
                        }
                        else {
                            int purchasePrice = orderCnt * latteCost;
                            if (purchasePrice >= balance){
                                System.out.println("system : 주문을 취소합니다.");
                                continue;
                            }
                            System.out.println("system : " + latteName +" "+orderCnt +"개 매입합니다.");
                            latteStock += orderCnt;
                            expensesAmount += purchasePrice;
                            balance -= purchasePrice;

                            latteStock -=orderCnt;
                            salesAmount += orderCnt * lattePrice;
                            balance += orderCnt * lattePrice;
                        }
                        // 안전 재고 수량 확인
                        if (latteStock <= latteSafetyStock){
                            int purchasePrice = latteSafetyStock * 2 * latteCost;
                            if (balance >= purchasePrice){
                                latteStock += latteSafetyStock*2;
                                balance -= purchasePrice;
                                expensesAmount += purchasePrice;
                                System.out.println("system : 안전재고 확보");
                            } else {
                                System.out.println("system : 잔고 부족으로 안전재고 확보 실패");
                            }
                        }
                        System.out.println("\n제품명 : " + latteName +
                                            "\n판매가 : " + lattePrice +
                                            "\n판매수량 : " + orderCnt +
                                            "\n결제금액 : " + orderCnt*lattePrice +
                                            "\n남은 재고 : " + latteStock);
                    }
                    
                }
                else if (menu == 2){
                    System.out.println("===========info==========");
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d)\n", americanoName, americanoStock, americanoSalesCnt);
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d)\n", mochaName, mochaStock, mochaSalesCnt);
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d)\n", latteName, latteStock, latteSalesCnt);

                    System.out.printf("잔고 : %4d | 매출 : %8d | 지출 %8d \n", balance, salesAmount, expensesAmount);
                }
                else {
                    System.out.println("system : 종료합니다");
                    break;
                }
            // checked exception : 개발자가 컨트롤 할 수 없는 이슈가 발생할 수 있을 때, 통신중에 상대방 서버가 죽어서 timeoutexception
            // unchecked exception : 개발자 실수 또는 개발자가 컨트롤 할 수 있는 상황, indexoutifboundsexception 등
            } catch (NoSuchElementException e){
                System.out.println("system : 잘못 입력하셨습니다.");
                continue;
            }
        }
    }
}
