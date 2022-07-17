package sample.ch04completable_future;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completedFuture = CompletableFuture.completedFuture("completedFuture()");
//        System.out.println(completedFuture.get());

        // 리턴 타입이 없는 경우
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("runAsync()");
        });
        runAsync.get();

        // 리턴 타입이 있는 경우
        CompletableFuture<Void> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync()");
            return "Return supplyAsync";
        }).thenAccept((msg) -> {
            System.out.println("Thread : " + Thread.currentThread());
            System.out.println(msg.toUpperCase());
        });

        supplyAsync.get();
        // callback method
        // thenAccept -> 리턴값 받아 사용하고, 리턴값 반환하지 않음
        // thenRun -> 리턴값 받지 않고, 리턴값 반환하지 않음 -> thenRunAsync , ~~~Async ->
        // 인자값을 이용해서 커스텀한 스레드풀을 사용할 수 있다.


    }
}
