package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    }
}
