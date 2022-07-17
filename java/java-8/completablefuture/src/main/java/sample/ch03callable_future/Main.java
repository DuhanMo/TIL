package sample.ch03callable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorServicePool = Executors.newFixedThreadPool(4);

        Callable<String> helloCallable = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> duhanCallable = () -> {
            Thread.sleep(3000L);
            return "duhan";
        };

        Callable<String> coffeeCallable = () -> {
            Thread.sleep(1000L);
            return "coffee";
        };

//        Future<String> future = executorService.submit(helloCallable);

//        System.out.println(future.isDone());
//        System.out.println("Start!");
//        System.out.println(future.get());
//        System.out.println(future.isDone());
//        System.out.println("End!");

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(helloCallable, duhanCallable, coffeeCallable));

        for (Future<String> f: futures) {
            System.out.println(f.get());
        }

        String s = executorServicePool.invokeAny(Arrays.asList(helloCallable, duhanCallable, coffeeCallable));
        System.out.println(s);

        executorService.shutdown();
    }
}
