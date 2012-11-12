import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 11/11/12
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConcurrentStack<E> {

    static class Node<E> {
        private E item;
        Node<E> next;
        public Node(E item){
            this.item=item;
            this.next=null;
        }
    }
    AtomicReference<Node<E>> head=new AtomicReference<Node<E>>();
    public void push(E item) {
        Node<E> oldHead=head.get();
        Node<E> newHead = new Node<E>(item);
        do {
            oldHead=head.get();
            oldHead.next=newHead;
        } while  (! head.compareAndSet(oldHead,newHead));

    }
    public E pop() {
        Node<E> oldHead,newHead;
        do {
           oldHead=head.get();
           newHead=head.get().next;

        } while (! head.compareAndSet(oldHead,newHead));
        return oldHead.item;

    }
}
