import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockOne implements Runnable{
    private Lock lock1;
    private Lock lock2;

    public LockOne(Lock lock1,Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + "is trying to lock 1");
        lock1.lock();
        System.out.println(threadName + "locked 1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadName + "is trying to lock 2");
        lock2.lock();
        System.out.println(threadName + "locked 2");

        lock1.unlock();
        System.out.println(threadName + "unlocked lock 1");
        lock2.unlock();
        System.out.println(threadName + "unlocked lock 2");
    }
}

class LockTwo implements Runnable{
    private Lock lock1;
    private Lock lock2;

    public LockTwo(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "is trying to lock 2");
        lock2.lock();
        System.out.println(threadName + "locked 2");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadName + "is trying to lock 1");
        lock1.lock();
        System.out.println(threadName + "locked 1");

        lock2.unlock();
        System.out.println(threadName + "unlocked lock 2");
        lock1.unlock();
        System.out.println(threadName + "unlocked lock 1");

    }
}



public class DeadLockDemo {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable runnable1 = new LockOne(lock1,lock2);
        Runnable runnable2 = new LockTwo(lock1,lock2);

        Thread t1 = new Thread(runnable1,"Thread 1: ");
        Thread t2 = new Thread(runnable2,"Thread 2: ");

        t1.start();
        t2.start();
    }
}
