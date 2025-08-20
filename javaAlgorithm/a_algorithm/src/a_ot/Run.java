package a_ot;

public class Run {
    public static void main(String[] args) {
        // a에 담긴 값을 b에, b에 담긴 값을 a에 넣어주세요
        // 단, 대입연산자만 사용해야 합니다
        // 값을 직접 변수에 할당할 수는 없습니다

        swap();
        swapUsingBits();
        
    }

    public static void swap(){
         int a = 10;
        int b = 15;

        // int tmp = a;
        // a = b;
        // b = tmp;
        System.out.println("a:"+a+", b:"+b);
    }

    public static void swapUsingBits(){
        int a = 10;
        int b = 15;

        // (a^b)^b = a
        // (b^a)^a) = b
        a = a^b;
        b = a^b;
        a = b^a;
        System.out.println("a:"+a+", b:"+b);

        // a xor 0 은 언제나 0
        // a xor 1 은 언제나 not a

        // a = 1001
        // b = 0101
    }
}
