package sample.ch02executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * executors:
 * 스레드를 만들고 관리하는 작업을 애플리케이션에서 분리 후
 * 해당 작업을 Executors 에게 위임
 * <p>
 * 하는 일:
 * 스레드 만들기: 애플리케이션에서 사용할 스레드풀을 만들어 관리
 * 스레드 관리: 스레드 생명 주기를 관리
 * 작업 처리 및 실행: 스레드로 실행할 작업을 제공할 수 있는 API 를 제공
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();
        executorServiceSingle.submit(() -> System.out.println("submit: " + Thread.currentThread())); // submit 은 다음스레드가 행위를 할 때까지 계속해서 대기한다. 프로그램이 끝나지 않음

        executorServiceSingle.submit(() -> System.out.println("submit: " + Thread.currentThread())); // submit 은 다음스레드가 행위를 할 때까지 계속해서 대기한다. 프로그램이 끝나지 않음
        executorServiceSingle.shutdown(); // graceful shutdown


        ExecutorService executorServicePool2 = Executors.newFixedThreadPool(2); // 스레드 2개가 서로 나누어 작업을 실행한다.
        // executors 에는 스레드 풀이 있고 블락킹 큐가 존재.
        // 작업을 수행할 스레드가 없다면 블락킹 큐에 작업을 넣어놓고 이후 처리
        executorServicePool2.submit(getRunnable("duhan"));
        executorServicePool2.submit(getRunnable("hello"));
        executorServicePool2.submit(getRunnable("starbucks"));
        executorServicePool2.submit(getRunnable("coffee"));
        executorServicePool2.shutdown();


        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("hi scheduled"), 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("fixed rate"), 1, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
        // runnable 은 반환값이 없다.
        // callable 은 반환값이 존재. -> 스레드가 끝난 후 반환값을 받아올 수 있다.
    }

    private static Runnable getRunnable(String msg) {
        return () -> System.out.println(msg+" : " + Thread.currentThread().getName());
    }
}
