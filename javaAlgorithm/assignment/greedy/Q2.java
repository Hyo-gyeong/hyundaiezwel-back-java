package greedy;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Q2 {
    public static void main(String[] args) {
        String jsonInput = "{'idx':1,'start':1,'end':10},{'idx':2,'start':5,'end':6},{'idx':3,'start':13,'end':15},"+
                        "{'idx':4,'start':14,'end':17},{'idx':5,'start':8,'end':14},{'idx':6,'start':3,'end':12}";
        jsonInput = jsonInput.replaceAll("[\\{\\}'idxstartend:]", "");

        TreeMap<Integer, Integer> map = new TreeMap<>(); // (end, start)
        String[] jsonArr = jsonInput.split(",");
        for (int i = 0; i < jsonArr.length; i += 3){
            map.put(Integer.parseInt(jsonArr[i+2]), Integer.parseInt(jsonArr[i+1]));
        }
        int end = map.firstKey();
        int cnt = 1;
        for (Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if (value >= end){
                cnt++;
                end = key;
                System.out.println("["+value+"~"+key+"]");
            }
        }
        System.out.println("총 "+cnt+"개의 회의 수용 가능");
        
    }
}
