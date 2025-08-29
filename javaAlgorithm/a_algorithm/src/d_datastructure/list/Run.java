package d_datastructure.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import d_datastructure.dto.School;

public class Run {
    public static void main(String[] args) {
        _LinkedList<Integer> list = init();
        System.out.println(list);
        System.out.println(list.indexOf(4));
        System.out.println(list.indexOf(100));
        System.out.println(list.contains(0));
        System.out.println(list.contains(100));
        testGet();
        testRemove();
        testSet();
        testForEach();
        // testSort();
        testGet();
    }

    private static void testForEach(){
        // 제어역전(IOC) : 객체 생성 및 관리의 제어권을 프레임워크 또는 컨테이너에게 넘겨주는 디자인 패턴
        _LinkedList<Integer> list = init();
        for (Integer integer : list){
            System.out.println(integer);
        }
        // 컴파일 될 때 사실상 아래와같이 바뀌며 내부적으로 iterator를 사용
        // for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
        //     Integer integer = it.next();
        //     System.out.println(integer);
        // }

    }

    private static void testSort(){
        School seoulUniv = new School("서울대", "관악구", "대학교");
        School minsa = new School("민사고", "대전", "고등학교");
        School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");
        School yeonsaeUniv = new School("연세대", "서울", "대학교");

        ArrayList<School> schools = new ArrayList<>();
        schools.add(seoulUniv);
        schools.add(minsa);
        schools.add(multicampus);
        schools.add(yeonsaeUniv);

        // Collections.sort(schools);   
        Collections.sort(schools, new Comparator<School>() {
            @Override
            public int compare(School o1, School o2){
                return o1.getName().compareTo(o2.getName());
            }
        });   
        Collections.sort(schools, (School o1, School o2) -> o1.getName().compareTo(o2.getName()));   
        System.out.println(schools);
    }

    private static void testSet(){
        _LinkedList<Integer> list = init();
        System.out.println(list.set(0, 10));
        System.out.println(list);
    }
    private static void testRemove() {
        _LinkedList<Integer> list = init();
        System.out.println(list);
        for (int i = 5; i < 8; i++){
            list.remove(i); // index 5번이 삭제되면 한칸씩 밀려와서 6번을 삭제하려고 할 때 원래 배열에서 7번째 값이 들어와있음
                            // 그래서 5, 7, 9가 삭제됨
        }
        System.out.println(list);
    }

    private static void testGet() {
        _LinkedList<Integer> list = init();
        for (int i = 0; i < 15; i++){
            System.out.println(list.get(i));
        }
    }

    private static _LinkedList<Integer> init(){
        _LinkedList<Integer> list = new _LinkedList<>();
        for (int i = 0; i < 15; i++){ // 배열의 크기가 확장되며 남는 자리는 null로 채워짐. 결과는 toString을 변경해주면 됨
            list.add(i);
        }
        return list;
    }
}
