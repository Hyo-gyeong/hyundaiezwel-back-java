package d_datastructure;

public class Run {
    public static void main(String[] args) {
        System.out.println(testAdd());
        testGet();
        testRemove();
    }

    private static void testRemove() {
        _ArrayList<Integer> list = testAdd();
        System.out.println(list);
        for (int i = 5; i < 8; i++){
            list.remove(i); // index 5번이 삭제되면 한칸씩 밀려와서 6번을 삭제하려고 할 때 원래 배열에서 7번째 값이 들어와있음
                            // 그래서 5, 7, 9가 삭제됨
        }
        System.out.println(list);
    }

    private static void testGet() {
        _ArrayList<Integer> list = testAdd();
        for (int i = 0; i < 15; i++){
            System.out.println(list.get(i));
        }
    }

    private static _ArrayList<Integer> testAdd(){
        _ArrayList<Integer> list = new _ArrayList<>();
        for (int i = 0; i < 15; i++){ // 배열의 크기가 확장되며 남는 자리는 null로 채워짐. 결과는 toString을 변경해주면 됨
            list.add(i);
        }
        return list;
    }
}
