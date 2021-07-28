package interfaces;

public interface MyStack<T> extends MyCollection {

    void push(T value);

    void remove(int index);

    T peek();

    T pop();

}
