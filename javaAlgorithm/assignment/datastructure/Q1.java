import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Q1 {
    // 가장 많은 문자 출력
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열을 입력하세요 : ");
        String input = sc.nextLine();

        int max = 1;
        for (int i = 0; i < input.length(); i++){
            String key = String.valueOf(input.charAt(i));
            int value = map.getOrDefault(key, 0)+1;
            map.put(key, value);
            max = Math.max(max, value);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == max)
            sb.append(key).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        System.out.println(sb.toString());

        sc.close();
    }

}
