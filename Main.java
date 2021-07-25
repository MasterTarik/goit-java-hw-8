import interfaces.MyList;
import list.MyArrayList;
import list.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();
        System.out.printf("size %d%n", myList.size());
        myList.add(15);
        myList.add(22);
        myList.add(34);
        myList.add(3);
        myList.add(15);
        myList.add(42);
        System.out.printf("myList in inside = %s%n", myList.toString());
        System.out.printf("size %d%n", myList.size());
        myList.remove(2);
        System.out.printf("myList %s%n", myList.toString());
        System.out.printf("size %d%n", myList.size());
        System.out.printf("tValueOf = %s%n", myList.toString());

        MyList<Character> myLinkedList = new MyLinkedList<>();
        myLinkedList.add('t');
        System.out.printf("myLinkedList: %s%n", myLinkedList.toString());
        System.out.printf("get = %s%n", myLinkedList.get(0));
        System.out.printf("get = %s%n", myLinkedList.get(3));
        myLinkedList.add('a');

    }
}