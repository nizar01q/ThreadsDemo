public class VirtualDemo {
    public static void main(String[] args) {
        Runnable vThr = ()->{

            for (int i = 1; i <= 6; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);}

    };
        Thread vThread = Thread.ofVirtual().start(vThr);
        try {
            vThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
