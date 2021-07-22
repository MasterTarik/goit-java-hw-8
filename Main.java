import interfacec.MyList;
import list.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<Integer>();
        System.out.printf("size %d%n", myList.size());
        myList.add(15);
        myList.add(22);
        myList.add(34);
        myList.add(3);
        myList.add(15);
        myList.add(42);
        System.out.printf("myList in inside = %s%n", myList.getList());
        System.out.printf("size %d%n", myList.size());
        myList.remove(2);
        System.out.printf("myList %s%n", myList.getList());
        System.out.printf("size %d%n", myList.size());
    }
}