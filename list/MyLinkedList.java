package list;

import interfaces.MyList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList {

    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size = 0;

    public MyLinkedList() {
        this.lastElement = new Node<>(firstElement, null, null);
        this.firstElement = new Node<>(null, null, lastElement);
    }

    @Override
    public void add(Object value) {
        Node<T> tempElement = lastElement;
        lastElement.setCurrentElement((T) value);
        lastElement = new Node<>(tempElement, null, null);
        tempElement.setNextElement(lastElement);
        tempElement.setPrevElement(firstElement);
        size++;
        System.out.printf("tempElement: %s%n", lastElement);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public void remove(int index) {
        Node<T> prevRemoveElement = firstElement.getNextElement();
        for (int i = 0; i < index; i++) {
            prevRemoveElement = prevRemoveElement.getNextElement();
        }

    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        Node<T> target = firstElement.getNextElement();
        for (int i = 0; i < index; i++) {
            target = target.getNextElement();
        }
        return target.getCurrentElement();
    }

    private class Node<T> {
        private T currentElement;
        private Node<T> nextElement;
        private Node<T> prevElement;

        private Node(Node<T> prevElement, T currentElement, Node<T> nextElement) {
            this.prevElement = prevElement;
            this.currentElement = currentElement;
            this.nextElement = nextElement;
        }

        public T getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(T currentElement) {
            this.currentElement = currentElement;
        }

        public Node<T> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<T> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<T> lastElement) {
            this.prevElement = lastElement;
        }
    }


    public Node<T> getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(Node<T> firstElement) {
        this.firstElement = firstElement;
    }

    public Node<T> getLastElement() {
        return lastElement;
    }

    public void setLastElement(Node<T> lastElement) {
        this.lastElement = lastElement;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
