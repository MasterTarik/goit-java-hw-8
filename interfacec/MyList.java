package interfacec;

public interface MyList <T> extends MyCollection{

    void add(Object value);// добавляет элемент в конец
    void remove(int index);// удаляет элемент под индексом
    T get(int index);// возвращает элемент под индексом
    String getList();
    }
