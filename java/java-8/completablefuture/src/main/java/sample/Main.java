package sample;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        Thread customThread = new Thread(() -> {
//            try {
//                Thread.sleep(1000); // 대기 상태 -> 다른스레드에게 우선권이 간다.
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("runnable : " + Thread.currentThread().getName());
//        });


//        Thread customThread = new Thread(() -> {
//            while (true) {
//                System.out.println("runnable : " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000); //
//                } catch (InterruptedException e) {
//                    System.out.println("exit");
//                    return; // interrupt되면 return으로 스레드를 종료한다. return 을 하지 않으면 종료되지 않는다.
//                }
//            }
//        });

        Thread customThread = new Thread(() -> {
                System.out.println("runnable : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000); //
                } catch (InterruptedException e) {
                    throw new IllegalStateException();
                }
        });
        customThread.start();

        System.out.println("Hello main" + Thread.currentThread().getName());
        customThread.join(); // 기다릴 스레드에다가 join을 하게되면 customThread가 종료될때까지 기다린다.
        System.out.println(customThread + "is finished");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}
