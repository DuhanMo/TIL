package sample.ch04completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "Hello";
        });


        CompletableFuture<String> thenCompose = helloFuture.thenCompose(CompletableFuture2::getWorldFuture);
        System.out.println(thenCompose.get());

        CompletableFuture<String> thenCombine = helloFuture.thenCombine(getWorldFuture(), (h, w) -> h + " " + w);
        System.out.println(thenCombine.get());

        boolean throwError = true;
        CompletableFuture<String> errorCheckFutureExceptionally = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalStateException();
            }
            System.out.println("error 확인 supply");
            return "Hi";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });

        CompletableFuture<String> errorCheckSupplyHandle = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalStateException();
            }
            System.out.println("error 확인 supply");
            return "Hi";
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("handle - error occur!");
                System.out.println(ex);
                return "Error!";
            }
            return res;
        });

//        System.out.println(errorCheckFutureExceptionally.get());

        System.out.println(errorCheckSupplyHandle.get());
    }


    private static CompletableFuture<String> getWorldFuture(String msg) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("world " + Thread.currentThread().getName());
            return msg + " World";
        });
    }

    private static CompletableFuture<String> getWorldFuture() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("world " + Thread.currentThread().getName());
            return "World";
        });
    }
}
