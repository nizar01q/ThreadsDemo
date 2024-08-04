class Counter{
    int count;

    public synchronized void increment(){
        count++;
    }
}

public class Ex3 {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable thr = ()->{
          for (int i = 1;i<=1000;i++){
              c.increment();
          }
        };

        Thread t1 = new Thread(thr);


        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
             for (int i = 1;i<=1000;i++){
              c.increment();
          }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + c.count);
    }
}
