import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEx {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Runnable runnable = ()->{
            String ThreadName = Thread.currentThread().getName();
           try {
               lock.lock();
               System.out.println(ThreadName + ": locked the lock");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
            finally {
               lock.unlock();
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
