package queue;

import interfaces.MyList;
import interfaces.MyQueue;
import list.MyLinkedList;

import java.util.Objects;

public class Queue<T>  implements MyQueue<T>{

    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size = 0;

    public Queue(){
        this.firstElement = null;
        this.lastElement = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        new Queue<>();
        this.size =0;
    }

    @Override
    public void add(T value) {
        Node<T> addElement = new Node<>(value);
        if (firstElement == null) {
            firstElement = lastElement = addElement;
        } else {
            lastElement.setNextElement(addElement);
            lastElement = addElement;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            firstElement = firstElement.getNextElement();
            if (firstElement == null) {
                lastElement = null;
            }
        } else {
            Node<T> prev = getNode(index - 1);
            prev.setNextElement(prev.getNextElement().getNextElement());
            if (index == size - 1) {
                lastElement = prev;
            }
        }
        size--;
    }

    @Override
    public T peek() {
        return firstElement != null ? firstElement.getElement() : null;
    }

    @Override
    public T poll() {
        T res = peek();
        remove(0);
        return res;
    }

    private static class Node<T> {
        private T element;
        private Node<T> nextElement;

        Node(T element){
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement = nextElement;
        }
    }

    private Node<T> getNode(int index) {
        Node<T> currentElem = firstElement;
        for (int i = 0; i < index; i++) {
            currentElem = currentElem.getNextElement();
        }
        return currentElem;
    }
}
