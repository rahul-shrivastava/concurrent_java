import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 11/11/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyCallable implements  Callable<Long>{

    private long countUntil;
    public MyCallable(long countUntil) {
      this.countUntil=countUntil;

    }
    @Override
    public  Long call() throws Exception{
        long sum=0L;
        for (long i=0;i < countUntil;i++) {
            sum=sum+i;
        }

        return Long.valueOf(sum);
    }

  public static void main(String[] args){
      List<Future<Long>> list=new ArrayList<Future<Long>>();
      Future<Long> f;
      Callable<Long> c;
      ExecutorService exService=Executors.newFixedThreadPool(10);
      final long noOfTimes=10;
      for (long i=0;i <noOfTimes; i++ ){
          c= new   MyCallable(noOfTimes);
          f=exService.submit(c);
          list.add(f);
      }

      exService.shutdown();
      while (! exService.isTerminated()) {

  }
      Long l=null;
      for (Future<Long> f1 : list) {
          try {
          l=f1.get();
          } catch(InterruptedException e) {
              e.printStackTrace();
          } catch (ExecutionException e) {
              e.printStackTrace();
          } finally {
              if ( l ==null ) l= new Long(0L);
          }
          System.out.println(l.toString());

      }
}
}
