import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        arrayBlockingQueue.put("element 1");
        arrayBlockingQueue.put("element 2");

        String e1 = arrayBlockingQueue.take();
        String e2 = arrayBlockingQueue.take();

        System.out.println(e1);
        System.out.println(e2);
    }
}
