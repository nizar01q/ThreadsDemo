public class Ex1 {
    public static void main(String[] args) {
        Runnable thr1 = () -> {
            String thrName1 = Thread.currentThread().getName();
            for (int i = 1; i <= 6; i++) {
                System.out.println(i + ":" + thrName1);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable thr2 = () -> {
            String thrName2 = Thread.currentThread().getName();
            for (int i = 1; i <= 9; i++) {
                System.out.println(i + ":" + thrName2);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(thr1, "First Thread");
        Thread t2 = new Thread(thr2, "Second Thread");

        t1.start();
        t2.start();
    }
}
