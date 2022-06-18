package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("duhan");
        names.add("issac");
        names.add("musin");
        names.add("sunja");
        names.add("jiyoung");

        // 중계 오퍼레이터
        names.stream()
                .map(name -> {
                    System.out.println(name.toUpperCase()); // 종료 오퍼레이터가 없기 때문에 해당 메서드는 실행되지 않는다.
                    return name;
                });

        // 종료 오퍼레이터
        names.stream()
                .map(name -> {
                    System.out.println(name.toUpperCase() + " " + Thread.currentThread()); // 종료 오퍼레이터가 존재하기 때문에 해당 메서드가 실행된다.
                    return name.toUpperCase();
                })
                .collect(Collectors.toList());
        System.out.println("=====================");

        // parallelStream() : 병렬 처리를 도와주는 스트림 메서드 -> 멀티스레드를 이용하지만 성능이 안좋아 질 수가 있다(컨텍스트 스위칭)
        // 데이터가 방대할 때는 유용할 수 있음
        names.parallelStream()
                .map(name -> {
                    System.out.println(name.toUpperCase() + " " + Thread.currentThread()); // 종료 오퍼레이터가 존재하기 때문에 해당 메서드가 실행된다.
                    return name.toUpperCase();
                })
                .collect(Collectors.toList());
        System.out.println("=====================");

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(c -> c.getTitle().startsWith("spring"))
                .forEach(c -> System.out.println(c.getTitle()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
//                .filter(c -> !c.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(c -> System.out.println(c.getTitle()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()
                .flatMap(Collection::stream) // 리스트 안에 리스트가 스트림으로 흐를 때 그 리스트안에 내용도 전부 flat하게 꺼낸다.
                .forEach(c -> System.out.println(c.getTitle()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean isContainTest = javaClasses.stream()
                .anyMatch(c -> c.getTitle().contains("Test"));
        System.out.println(isContainTest);


        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것 클래스의 제목만 모아서 List로 만들기");
        List<String> classContainSpring = springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(title -> title.contains("spring"))
                .collect(Collectors.toList());
        classContainSpring.forEach(System.out::println);
    }
}
