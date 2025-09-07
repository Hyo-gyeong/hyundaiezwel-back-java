package c_math;

public class MathQuiz {
    public static void main(String[] args) {
        System.out.printf("소수입니까? : %s \n", isPrime(71));
        System.out.printf("12, 18의 최대공약수 : %d \n", gcd(12,18));
        System.out.printf("12, 18의 최소공배수 : %d \n", lcm(12,18));
        System.out.printf("5! : %d \n", factorial(5));
        System.out.printf("5! : %d \n", factorial2(5, 1));
    }

    private static int factorial(int i) {
        if (i < 0) throw new IllegalArgumentException("음수 펙토리얼은 존재하지 않습니다.");
        if (i <= 1) return 1;
        return i * factorial(i-1);
    }

    // 꼬리 재귀 함수
    // 반환부에 연산이 없는 재귀함수
    // 컴파일러가 내부적으로 반복문 최적화 / 자바 x
    private static int factorial2(int i, int res) {
        if (i < 0) throw new IllegalArgumentException("음수 펙토리얼은 존재하지 않습니다.");
        if (i <= 1) return res; // 최종 결과값 반환
        
        res = i * res;
        return factorial2(i-1, res);
    }


    private static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return a * b/gcd;

    }

    private static int gcd(int a, int b) {
        int min = Math.min(a, b);
        
        for (int i = min; i > 0; i--){
            if (a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }

    // 유클리드 호제법
    // a > b
    // a,b가 최대 공약수 G를 가질 때 a,b를 나눈 나머지는 G의 배수다

    /*
     * a = MG, b = NG
     * a = bq + r
     * MG = NGq + r
     * r = MG - NGq
     * r = G(M - Nq)
     * 
     * b = NG
     * r = PG
     * b = rq + r2
     * NG = PGq + r2
     * r2 = G(Pq - N)
     */

    private static int gcd2(int b, int a) {
        while (a > 0){
            int tmp = b;
            b = a % b;
            a = b;
        }
        return a;
    }


    // 약수
    // n%m=0
    // 약수의 특징 : 약수는 곱해서 피제수 (나누어지는 수)가 되게끔 하는 쌍이 반드시 존재
    private static boolean isPrime(int input) {
        for (int i = 2; i <= Math.sqrt(input); i++){
            if (input % i == 0){
                return false;
            }
        }
        return true;
    }
}
