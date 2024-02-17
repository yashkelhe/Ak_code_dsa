package LinkedList;

import java.util.LinkedList;

public class JavaCollectionFramWork_LL {

    // here we are using the java collectionfram work
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        System.out.println(ll);

        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);

    }

}
