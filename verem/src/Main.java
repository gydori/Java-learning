import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        /*MyStack verem = new MyStack();

        verem.push(2);
        System.out.println(verem);

        verem.pop();
        System.out.println(verem);

        verem.peek();
        System.out.println(verem);*/
//---------------------------------------------------------------------
        /*DynamicStack ds = new DynamicStack();

        ds.push(3);
        ds.push(2);
        ds.push(5);
        System.out.println(ds.peek());
        System.out.println(ds.pop());
        System.out.println(ds.peek());*/
        //--------------------------------------------------------

/*        NewLinkedList nll = new NewLinkedList();
        nll.insertFirst(5);
        nll.insertAfter(2);
        nll.insertBefore(3);
        System.out.println(nll.toString());
        System.out.println(nll.contains(2));*/

        //-------------------------------------------------------------


        //long[] tomb = {(long) Math.pow(10, 0), (long) Math.pow(10, 1), (long) Math.pow(10, 2), (long) Math.pow(10, 3), (long) Math.pow(10, 4), (long) Math.pow(10, 5), (long) Math.pow(10, 6), (long) Math.pow(10, 7), (long) Math.pow(10, 8)};
        //ListTime.addTime(tomb);
        //ListTime.addGetTime(tomb);
        //ListTime.addGetContainsTime(tomb);

        //MapTime.addGetContainsTime(tomb);

        //--------------------------------------------------------------------
        MyArrayList mal = new MyArrayList();

        mal.add(3);
        mal.add(5);
        mal.add(7);
        mal.add(8);
        mal.add(9);
        mal.add(1, 6);
        mal.add(6, 0);
        //System.out.println(mal.size());
        //System.out.println(mal);
        mal.remove(5);
        System.out.println(mal);
        //System.out.println(mal.contains(10));
        //System.out.println(mal.size());

        Iterator itr = mal.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        mal.forEach(System.out::println);
    }
}
