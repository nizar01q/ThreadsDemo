import java.util.stream.LongStream;

public class ParallelDemo {
    long start = 1;
    long end = 1_000_000;
    public static void main(String[] args) {
        long start = 1;
        long end = 1_000_000;
        long startTime = System.currentTimeMillis();
        long seqSum = LongStream.rangeClosed(start,end).sum();
        long endTime = System.currentTimeMillis();
        System.out.println(seqSum );
        System.out.println((endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        long parSum = LongStream.rangeClosed(start,end).parallel().sum();
        endTime = System.currentTimeMillis();
        System.out.println(parSum );
        System.out.println((endTime - startTime) + "ms");


    }
}
