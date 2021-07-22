package interfacec;

public interface MyQueue extends MyCollection{

    void add(Object value);// добавляет элемент в конец
    void remove(int index);// удаляет элемент под индексом
    Object peek();// возвращает первый элемент в очереди (FIFO)
    Object poll();// возвращает первый элемент в очереди и удаляет его из коллекции

}
