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

        Predicate<String> startWithDuhan = s -> s.startsWith("du"); // 인자값을 받아서 true, false 를 리턴해주는 인터페이스
        Predicate<Integer> isOdd = i -> i % 2 == 0;

        UnaryOperator<Integer> plus10Unary = i -> i + 10;
        System.out.println(plus10Unary.apply(10));

        BiFunction<Integer, Integer, Integer> plus2Param = (i, j) -> i + j;
        BinaryOperator<Integer> plus2ParamBinary = (i, j) -> i + j;
    }
}
