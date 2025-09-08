import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3 {
    // 요세푸스 순열 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N을 입력하세요: ");
        int n = sc.nextInt();
        System.out.print("K를 입력하세요: ");
        int k = sc.nextInt();
        bruteForce(n, k);
        System.out.println(recursive(n, k)+1);
        
        sc.close();
    }

    private static void bruteForce(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            queue.add(i);
        }
        while (!queue.isEmpty()){
            for (int j = 0; j < k-1; j++){
                int element = queue.remove();
                queue.add(element);
            }
            list.add(queue.remove());
        }
        System.out.println(list.toString());

    }

    private static int recursive(int n, int k) {
        if (n == 1){ // 남은 사람이 1명이면
            return 0; // 인덱스 0번의 사람이 살아남음
        }
        // recursive(n,k)는 recursive(n-1,k)를 이용해서 푼다. 즉, 한 명을 죽이고, 배열을 회전하는 것을 반복하여 1명이 남을 때까지 푼다
        /*
         * 예시 설명)
         * recursive(5,2)
         * = 0, 1, 2, 3, 4 에서 2번째를 죽이고 시작점 다시 잡기위해 배열을 회전하기
         * = 2, 3, 4, 0
         * 이때 인덱스를 새로 매기면 2, 3, 4, 0에서 0, 1, 2, 3이 됨
         * 즉, recursive(5,2)의 결과 배열은 (recursive(4,2)의 시작 배열에 +2를 한 후 % 5를 한 값이 됨
         * 따라서 recursive(n,k)를 retrun (recursive(n-1,k)+k)%n 공식으로 풀이 가능
         */
        return (recursive(n-1, k) + k) % n;
    }
}
