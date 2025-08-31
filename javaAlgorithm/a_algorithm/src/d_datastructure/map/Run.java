package d_datastructure.map;

import java.util.HashMap;
import java.util.Map.Entry;

import d_datastructure.dto.School;

public class Run {
    public static void main(String[] args) {
        School seoulUniv = new School("서울대", "관악구", "대학교");
        School yeonsaeUniv = new School("연세대", "서울", "대학교");
        School minsa = new School("민사고", "대전", "고등학교");
        School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");

        _HashMap<String,School> schoolMap = new _HashMap<>();

        schoolMap.put("seoulUniv", seoulUniv);
        schoolMap.put("yeonsaeUniv", yeonsaeUniv);
        schoolMap.put("minsa", minsa);
        schoolMap.put("multicampus", multicampus);

        System.out.println(schoolMap.entrySet());
        System.out.println("-------------------------");
        
        schoolMap.put("seoulUniv", new School("서울대 제주캠", "제주도", "대학교"));
        System.out.println(schoolMap.get("seoulUniv"));
        System.out.println("-------------------------");
        System.out.println("seoulUniv");
        System.out.println(schoolMap.entrySet());

        String str = "hashtable";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            String letter = str.charAt(i)+"";
            map.put(letter, map.getOrDefault(letter, 0)+1);
        }
        System.out.println(map.entrySet());
        int max = 0;
        for (Entry<String, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if (value > max){
                max = value;
            }
        }
        for (Entry<String, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if (value == max){
                System.out.println(entry.getKey());
            }
        }
    }
}
