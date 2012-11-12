import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 11/11/12
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Counter {
    private AtomicInteger aInt = new AtomicInteger();

    public int decrement() {
        int val = 0;
        synchronized (aInt) {
            if (aInt.get() > 0) {
                val = aInt.getAndDecrement();
            }
        }
        System.out.println("Val " + val + " is decremented in thread " + Thread.currentThread().getName());
        return val;
    }

    public void increment() {
        int val = aInt.getAndIncrement();
        System.out.println("Val " + val + " is incremented in thread " + Thread.currentThread().getName());
    }

    public int compareAndSet(int newValue) {
        int oldValue = aInt.get();
        while (!aInt.compareAndSet(oldValue, oldValue + 1)) {
            oldValue = aInt.get();
        }
        return oldValue + 1;
    }

    public Counter(int i) {
        aInt.set(i);
    }

    public static void main(String[] args) {

        final Counter c = new Counter(10);
        ExecutorService exServices = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            exServices.execute(new Runnable() {
                @Override
                public void run() {
                    c.decrement();
                    c.increment();
                }
            });
        }
            exServices.shutdown();
            while (!exServices.isTerminated()) {

            }

    }
}
