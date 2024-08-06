public class StarvationDemo {
    public static void main(String[] args) {
        Runnable lowPriority = ()->{
            while (true){
            System.out.println("This method is running on low priority");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable highPriority = ()->{
            while (true){
                System.out.println("This method is running on high priority");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread low1 = new Thread(lowPriority);
        Thread high2 = new Thread(highPriority);
        Thread high3 = new Thread(highPriority);

        low1.setPriority(Thread.MIN_PRIORITY);
        high2.setPriority(Thread.MAX_PRIORITY);
        high3.setPriority(Thread.MAX_PRIORITY);

        low1.start();
        high2.start();
        high3.start();
    }
}
