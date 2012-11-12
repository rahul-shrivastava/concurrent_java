import sun.font.TrueTypeFont;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 11/11/12
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class NonBlockingCounter {
    final AtomicInteger aInt=new AtomicInteger();

    public NonBlockingCounter(int i) {
        aInt.set(i);
    }
    public int getVal() {
        return aInt.get();
    }

    public boolean setVal(int i){
        int oldVal=aInt.get();
        int newVal=oldVal+1;
        if (!aInt.compareAndSet(oldVal,newVal)) {
            return false;
        }
        return true;
    }
}
