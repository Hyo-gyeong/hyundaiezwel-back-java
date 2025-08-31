package d_datastructure.queue;

public class Run {
    public static void main(String[] args) {
        _Queue<Integer> queue = new _Queue<>();
        // for (int i = 0; i < 10; i++){
        //     queue.enqueue(i);
        // }
        // for (int i = 0; i < 10; i++){
        //     System.out.println(queue.toString());
        //     queue.dequeue();
        // }

        // 백준 1158 요세푸스 문제
        StringBuilder sb = new StringBuilder("<");
        int len = 7;
        int n = 3;
        for (int i = 1; i <= len; i++){
            queue.enqueue(i);
        }
        int cnt = len;
        while (cnt > 0){
            for (int i = 0; i < n-1; i++){
                int kill = queue.dequeue();
                queue.enqueue(kill);
            }
            int num = queue.dequeue();
            sb.append(num).append(", ");
            cnt--;
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.deleteCharAt(sb.lastIndexOf(" "));
        sb.append(">");
        System.out.println(sb.toString());
    }
}
