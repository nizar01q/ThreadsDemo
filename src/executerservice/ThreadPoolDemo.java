package executerservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future = executorService.submit(runnable(": Task 4"));

        System.out.println(future.isDone());
        try {
            future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(future.isDone());

        executorService.execute(runnable(" :Task 1"));
        executorService.execute(runnable(" :Task 2"));
        executorService.execute(runnable(" :Task 3"));
        executorService.shutdown();
    }
    public static Runnable runnable(String msg){
           return ()->{
               System.out.println(Thread.currentThread().getName()+msg);
           };
    }

}
