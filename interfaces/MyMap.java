package interfaces;

public interface MyMap<K, V> {

    void put(K key, V value);// добавляет пару ключ + значение
    V remove(K key);// удаляет пару по ключу
    V get(K key);// возвращает значение(Object value) по ключу

}
