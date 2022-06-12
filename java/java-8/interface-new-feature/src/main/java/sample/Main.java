package sample;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("duhan");
        System.out.println(foo.getName());
        foo.printNameUpperCase();

        Foo.printNameEveryWhere();

        System.out.println("===============");
//        List<String> names = Arrays.asList("duhan", "dudu", "java", "dog");
        List<String> names = new ArrayList<>();
        names.add("duhan");
        names.add("dudu");
        names.add("java");
        names.add("dog");
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator2 = spliterator.trySplit(); // 참조하는 spliterator 가 반으로 쪼개진다.
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("반으로 쪼개진 상 하 spliterator");
        while (spliterator2.tryAdvance(System.out::println));

        System.out.println("=============removeIf============");
        names.removeIf(i -> i.startsWith("du")); // Arrays.asList 는 immutable 이라서 removeIf가 작용되지 않는다.
        names.forEach(System.out::println);


        System.out.println("=============Comparable============");
        List<String> animals = new ArrayList<>();
        animals.add("zebra");
        animals.add("dog");
        animals.add("cat");
        animals.add("quaqa");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        animals.sort(compareToIgnoreCase.reversed());
        animals.forEach(System.out::println);

    }
}
