package Multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<CallableTask> tasks = List.of(new CallableTask("42Seoul"),  new CallableTask("Udemy"), new CallableTask("Java"));

        String result = executor.invokeAny(tasks);

        System.out.println(result);
        executor.shutdown();
    }
}
