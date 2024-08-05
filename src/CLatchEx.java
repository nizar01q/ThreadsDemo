import java.util.concurrent.CountDownLatch;

class CarRepair implements Runnable{
    CountDownLatch latch;

    public CarRepair(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run(){
        System.out.println("Changing Tire");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tire Changed!");
        latch.countDown();
    }
}

public class CLatchEx {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        CarRepair car = new CarRepair(latch);
        Thread w1 = new Thread(car);
        Thread w2 = new Thread(car);
        Thread w3 = new Thread(car);
        Thread w4 = new Thread(car);
        w1.start();
        w2.start();
        w3.start();
//        w4.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Car Balancing Required");
    }
}
