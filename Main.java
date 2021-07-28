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
        myList.clear();
        System.out.printf("myList after clear %s%n", myList.toString());

/*******************************************************************************************************************/

        MyList<Character> myLinkedList = new MyLinkedList<>();
        myLinkedList.add('t');
        System.out.printf("myLinkedList: %s%n", myLinkedList.toString());
        System.out.printf("get = %s%n", myLinkedList.get(0));

        myLinkedList.add('a');
        System.out.printf("myLinkedList: %s%n", myLinkedList.toString());

        myLinkedList.add('r');
        System.out.printf("myLinkedList: %s%n", myLinkedList.toString());


        MyLinkedList<String> myLinkedListString = new MyLinkedList<>();
        myLinkedListString.add("t");
        myLinkedListString.add("ar");
        myLinkedListString.add("k");
        System.out.println("get linkedString = " + myLinkedListString.get(2));

        for (String str : myLinkedListString) {
            System.out.printf("foreach = %s%n", str);
        }

        System.out.printf("myLinkedListString: %s%n", myLinkedListString.toString());

        myLinkedListString.remove(2);
        System.out.printf("after remove [%d], %s%n", 2, myLinkedListString.toString());

        myLinkedListString.addIndex(2, "index");
        System.out.printf("after add element with out index[%d], %s%n", 2, myLinkedListString.toString());


        myLinkedList.clear();
        System.out.printf("myLinkedList after clean: %s%n", myLinkedList.toString());



    }
}