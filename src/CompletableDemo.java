import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+" is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        completableFuture.thenRun(()->{
            System.out.println("Completed Running");
        });
        completableFuture.get();

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            return 8;
        }).thenApply(result -> {return result * 2;}).thenApply(result ->{return result+2;});
        System.out.println(completableFuture2.get());
}
}
