package tree;

import org.junit.Before;
import org.junit.Test;


public class NodeTest {

    Node<Integer> head = new Node<>();

    @Before
    public void createNode() {
        head.setData(0);
        Node<Integer> n1 = new Node<>();
        n1.setData(1);
        Node<Integer> n2 = new Node<>();
        n2.setData(2);
        Node<Integer> end = new Node<>();
        end.setData(3);
        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(end);

    }

    @Test
    public void testNodeReverse() {
        Node<Integer> h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        h =  reverse(head);
        System.out.println();
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
    }

    public Node<Integer> reverse(Node<Integer> node) {
       if (null == node.getNext() || node == null) {
           return node;
       }
       Node<Integer> tmp = reverse(node.getNext());
       node.getNext().setNext(node);
       //node.setNext(null);
       return tmp;
    }


}