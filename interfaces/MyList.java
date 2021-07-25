package interfaces;

public interface MyList<T> extends MyCollection {

    void add(T value);

    void remove(int index);

    T get(int index);

}
