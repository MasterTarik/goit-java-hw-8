package interfaces;

public interface MyQueue<T> extends MyCollection {

    void add(T value);

    void remove(int index);

    T peek();

    T poll();
}
