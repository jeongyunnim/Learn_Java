package Multithreading;

import java.util.concurrent.*;

class CallableTask implements Callable<String> {

    private String name;

    CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " + name;
    }
}

public class CallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> welcomeFuture = executor.submit(new CallableTask("jeseo"));
        executor.shutdown();

        System.out.println("new callable task executed");
        System.out.println("return value: " + welcomeFuture.get());
        System.out.println("Main completed");
    }
}
