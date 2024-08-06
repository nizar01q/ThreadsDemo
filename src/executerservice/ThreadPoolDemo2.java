package executerservice;

import java.util.concurrent.*;

public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future = executorService.submit(callable(": Task 4"));

        System.out.println(future.isDone());
        try {
            String result = (String) future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(future.isDone());
        executorService.shutdown();

    }
    public static Callable callable(String msg){
           return ()->{
               String message = Thread.currentThread().getName()+msg;
               return message;
           };
    }

}
