import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 11/11/12
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyDataStructure {

    private List<String> li = new ArrayList<String>();

    public void add(String a) {

        li.add(a);
    }

    public List<String> getList() {
        return Collections.unmodifiableList(li);
    }

    public MyDataStructure getClone() {
        MyDataStructure clone_1=new MyDataStructure();
        for (String s: li){
            clone_1.add(s);
        }
        return clone_1 ;
    }

    public static void main(String[] args) {
        MyDataStructure md = new MyDataStructure();
        md.add("Rahul");
        md.add("Nidhi");
        List<String> clone_md = md.getList();
        md.add("someonelse");
      //  clone_md.add("cannot add") ;
        for (String s : clone_md) {
            System.out.println(s);
        }
        for (String s : md.getList()) {
            System.out.println(s);

        }

         MyDataStructure clone_2=md.getClone();


    }
}
