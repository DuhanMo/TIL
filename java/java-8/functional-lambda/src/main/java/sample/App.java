package sample;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        // static method reference
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("duhan"));

        // instance method reference
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("dudu"));

        // 기본 생성자 레퍼런스
        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting greetingGet = greetingSupplier.get(); // 해당 .get()을 이용해야 인스턴스를 가져올 수 있다.

        // 입력값이 있는 생성자 레퍼런스
        Function<String, Greeting> greetingFunction = Greeting::new;
        Greeting nameParamIsDuhan = greetingFunction.apply("nameParamIsDuhan");

        String[] names = {"duhan", "gildong", "doby"};
//        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase); // static 한 메서드가 아니고 임의객체의 인스턴스 메서드참조
        for (String name : names) {
            System.out.println(name);
        }
    }
}
