package sample;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // 익명 내부 클래스
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("do it!");
            }
        };

        RunSomething lambda = () -> System.out.println("do lambda!");

        runSomething.doIt();
        lambda.doIt();

        // 자바에서 제공하는 함수형 인터페이스
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        plus10.apply(3); // 13
        plus10.compose(multiply2).apply(3); // 16, compose 를 먼저 한 후 apply 동작
        plus10.andThen(multiply2).apply(3); // 26, apply 를 먼저 한 후 andThen 동작

        Consumer<Integer> printT = i -> System.out.println(i); // 뭔가를 리턴하지 않고 소비만한다.
        printT.accept(15);

        Supplier<Integer> get10 = () -> 10;// 인자가 없다. 제공만 하는 인터페이스
        System.out.println(get10);

        Predicate<String> startWithDu = s -> s.startsWith("du"); // 인자값을 받아서 true, false 를 리턴해주는 인터페이스
        Predicate<Integer> isOdd = i -> i % 2 == 0;

        UnaryOperator<Integer> plus10Unary = i -> i + 10;
        System.out.println(plus10Unary.apply(10));

        BiFunction<Integer, Integer, Integer> plus2Param = (i, j) -> i + j;
        BinaryOperator<Integer> plus2ParamBinary = (i, j) -> i + j;

        // 람다 표현식
        // 바디가 한줄이면 괄호 생략 가능
        Supplier<Integer> get1000 = () -> 1000;
        BinaryOperator<Integer> sum = (a, b) -> a + b;
    }

    // 변수 캡쳐
    private void run() {
        // 로컬 변수를 캡처할 수 있다. -> 로컬 변수를 람다 내에서 사용 가능 (final 이거나 effective final 일 경우만)
        final int baseNumber = 15; // 자바8 부터는 final 을 생략 가능, 해당 변수가 사실상 변경을 안한다면 final로 선언이 된다.
        IntConsumer printInt = i -> System.out.println(i + baseNumber);

        // 익명클래스와 내부클래스처럼 변수를 쉐도잉 하지 않는다. (가리지 않는다 & 덮어쓰지 않는다.)
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }
    }
}
