package f2_lambda;

import java.util.List;

import f2_lambda.function.Consumer;
import f2_lambda.function.Predicate;
import f2_lambda.function.Supplier;
import f2_lambda.function.Function;

public class _Lambda {
    /*
    * 1. 매개변수의 타입은 생략한다
    * 2. 매개변수가 하나라면 매개변수 선언부의 괄호는 생략한다.
    * 3. 코드블록에 코드가 한 줄이라면 {}를 생략한다.
    * 4. return문만 존재하는 함수라면 {}과 return 예약어를 생략한다.
    */
    public static void main(String[] args) {
        testConsumer(userName -> System.out.println(userName+"님 환영합니다."));
        testConsumer(userName -> {
            System.out.println("=====================");
            System.out.println(userName+"님 환영합니다.");
            System.out.println("=====================");
        });
        // testConsumer(new Consumer<String>() {
        //     @Override
        //     public void accept(String t) {
        //         System.out.println(t+"님 환영합니다.");
        //     }
        // });

        testSupplier(() -> "lambda supplier");
        testSupplier(() -> {
            System.out.println("==============");
            return "lambda supplier";
        });

        testFunction((a,b) -> "결과 : " + (a+b));
        testFunction((a,b) -> {
            System.out.print("a + b = ");
            System.out.print(a+b);
            return "결과 : " + (a+b);
        });

        testPredicate(n -> n%2 == 0);
        testPredicate(n -> {
            System.out.println("짝수?");
            return n%2 == 0;
        });

        // 메서드 참조
        testConsumer(System.out::println);

        List<Integer> nums = List.of(1,2,3,4,5,6,7,8);
        nums = nums.stream().map(e -> e*10).toList();
        System.out.println(nums);
    }

    public static void testConsumer(Consumer<String> fnc){
        fnc.accept("SHK");
    }

    public static void testSupplier(Supplier<String> fnc){
        System.out.println(fnc.get());
    }

    public static void testFunction(Function<Integer, String> fnc) {
		System.out.println(fnc.apply(1000, 2000));
	}

    public static void testPredicate(Predicate<Integer> fnc){
        System.out.println(fnc.test(1999));
    }
}
