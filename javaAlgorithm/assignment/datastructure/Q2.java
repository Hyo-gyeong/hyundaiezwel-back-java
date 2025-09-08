import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2 {
    // 카드문제
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> trash = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("N을 입력하세요 : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            queue.offer(i);
        }

        while (queue.size() > 1){
            trash.add(queue.poll());
            int element = queue.poll();
            queue.add(element);
        }
        System.out.println("trash : " +trash.toString()+", card : " + queue.peek());

        sc.close();
    }
}
