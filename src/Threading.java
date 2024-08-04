public class Threading extends Thread {
    private String name;

    public Threading(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 1; i <= 6; i++){
            System.out.println(i +":"+name);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
