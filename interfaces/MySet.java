package interfaces;

public interface MySet<K, T> extends MyCollection {

    void put(K key, T value);

    void remove(K key);

    T get(K key);

}
