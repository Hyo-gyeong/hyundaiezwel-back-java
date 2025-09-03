package g_devideandconqure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import util.SortUtil;

public class Quiz {
    public static void main(String[] args) {
        // q1(3,40);
        // q2(3465);
        q3();
    }
    
    // 백준 1931
    // 최대/최소 최적화 문제 -> 그리디 가능성 확인 -> 안되면 DP로 전환
    // 회의시간을 어떤 기준으로 선택하면 최대의 개수를 선택할 수 있을까?
    // 회의시간이 짧은 것들은 선택하면 남는 시간이 많으니까 더 많이 선택할 수 있겠다!
    // 앞의 선택이 뒤의 선택을 제한하지만 오히려 최적을 보장함
    // -> 그리디로 가능
    private static void q3() {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        int cnt = sc.nextInt();
        sc.nextLine();
        int i = 0;
        int max = 0;
        while (i < cnt){
            String input = sc.nextLine();
            int start = Integer.parseInt(input.split(" ")[0]);
            int end = Integer.parseInt(input.split(" ")[1]);
            if (end > max){
                max = end;
            }
            if (start != end)
                list.add(new int[] {start, end});
            i++;
        }
        sc.close();
    }

    private static void q2(int i) {
        int[] coins = {500,100,50,10,1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int coin : coins){
            map.put(coin, 0);
        }
        for (int coin : coins){
            map.put(coin, i/coin);
            i %= coin;
        }
        System.out.println(map.toString());
    }

    private static void q1(int a, int b){
        int ans = 1;
        if (b % 2 == 0){
            while (b > 1){
                ans *= Math.pow(a, b/2) * Math.pow(a, b/2);
                b /= 2;
            }
        } else {
            while (b > 1){
                ans *= Math.pow(a, b/2) * Math.pow(a, b/2) * a;
                b /= 2;
            }
        }
        System.out.println(ans);
    }
    
    private static void cpu(){
        int size = 10240;
        int[][] dArr = new int[size][size];

        SortUtil.checkTime(() -> { // 행끼리 값이 모여있기 때문에 행부터 탐색하는게 효율적임
            for (int i = 0; i < dArr.length; i++){
                for (int j = 0; j < dArr.length; j++){
                    dArr[i][j] = i;
                }
            }
        });
    }
}
