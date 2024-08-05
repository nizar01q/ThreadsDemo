class A{
    int num;
    boolean valueSet = false;

    public synchronized void set(int num){
        while (valueSet){
            try {wait();} catch (Exception e) {}
        }
        System.out.println("Set: " + num);
        this.num = num;
        valueSet = true;
        notify();
    }
    public synchronized void get(){
        while (!valueSet){
            try {wait();} catch (Exception e) {}
        }
        System.out.println("Get: "+ num);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable{
    A a;

    public Producer(A a) {
        this.a = a;
        Thread t = new Thread(this,"Producer");
        t.start();
    }

    public void run(){
        int i = 0;
        while (true){
            a.set(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable{
    A a;

    public Consumer(A a) {
        this.a = a;
        Thread t = new Thread(this,"Consumer");
        t.start();
    }

    public void run(){
        while (true){
            a.get();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class InterThread {
    public static void main(String[] args) {
        A a = new A();
        new Producer(a);
        new Consumer(a);
    }
}
