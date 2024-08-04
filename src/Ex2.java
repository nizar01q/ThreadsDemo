public class Ex2  {
    public static void main(String[] args) {
        Runnable thr1 = () ->{
          while (true){
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
              System.out.println("Running");
          }
        };
        Thread t1 = new Thread(thr1);
        t1.setDaemon(true);
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
    }
}
