import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Runnable runnable = ()->{
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println(threadName + ": is trying to acquire access");
            semaphore.acquire();
            System.out.println(threadName + ": has acquired access");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
            System.out.println(threadName + ": has released permit");
        }
    };
        Thread t1 = new Thread(runnable,"1st Thread");
        Thread t2 = new Thread(runnable,"2nd Thread");
        Thread t3 = new Thread(runnable,"3rd Thread");

        t1.start();
        t2.start();
        t3.start();

    }
}
