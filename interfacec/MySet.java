package interfacec;

public interface MySet extends MyCollection{

    void put(Object key, Object value);//добавляет пару ключ + значение
    void remove(Object key);// удаляет пару по ключу
    Object get(Object key);// возвращает значение(Object value) по ключу

}
