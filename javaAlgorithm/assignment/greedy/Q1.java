package greedy;

import java.util.TreeMap;
import java.util.Collections;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int[] coins = {500,100,50,10,1};
        Scanner sc = new Scanner(System.in);
        System.out.print("금액 입력 : ");
        int input = sc.nextInt();

        for (int coin : coins){
            map.put(coin, 0);
        }
        for (int coin : coins){
            map.put(coin, input/coin);
            input %= coin;
        }
        
        System.out.println(map.toString());

        sc.close();
    }
}
