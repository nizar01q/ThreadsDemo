public class Main {
    public static void main(String[] args) {
        Threading thr = new Threading("First Thread");
        Threading thr2 = new Threading("Second Thread");
        thr2.start();
        thr.start();
    }
}