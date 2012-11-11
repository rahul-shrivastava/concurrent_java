import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 11/11/12
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyRunnable implements Runnable {

    private final long countUntil;

    public MyRunnable(long countUntil) {
        this.countUntil = countUntil;


    }

    @Override
    public void run() {

        System.out.println("inside thread: "+ Thread.currentThread().getName());
        long sum = 0;
        for (long i = 0; i < countUntil; i++) {
            sum = sum + i;

        }
        System.out.println(sum);


    }

    public static void main(String[] args) {
        List<Thread> thList = new ArrayList<Thread>();
        MyRunnable r = new MyRunnable(10);
        Thread th;
        for (int i = 0; i < 10; i++) {
            th = new Thread(r);
            th.setName("worker threads " + i);
            th.start();
            thList.add(th);
        }
        int running = 0;
        do {
            running = 0;
            for (Thread t : thList) {
                if (t.isAlive()) {
                    System.out.println("Thread " + t.getName() + " is still running ");
                    running++;
                }
            }
        } while (running > 0);


    }

}
