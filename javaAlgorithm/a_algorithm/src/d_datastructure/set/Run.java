package d_datastructure.set;

import d_datastructure.dto.School;

public class Run {
    public static void main(String[] args) {
        School seoulUniv = new School("서울대", "관악구", "대학교");
        School yeonsaeUniv = new School("연세대", "서울", "대학교");
        School minsa = new School("민사고", "대전", "고등학교");
        School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");

        _HashSet_Chaining<School> set = new _HashSet_Chaining<>();
        set.add(seoulUniv);
        set.add(yeonsaeUniv);
        set.add(minsa);
        set.add(multicampus);
        System.out.println(set);
        System.out.println("--------------------------");
        // 주소가 다른 객체더라도 값이 같으면 추가될 수 없도록 School에 hashCode, equals 구현
        set.remove(new School("서울대", "관악구", "대학교"));
        System.out.println(set);
        System.out.println("--------------------------");
        
        for (School school : set){
            System.out.println(school);
        }
    }
}
