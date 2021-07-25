package list;

import interfaces.DescendingIterator;
import interfaces.MyList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>, Iterator<T>, DescendingIterator<T> {

    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size = 0;

    public MyLinkedList() {
        this.lastElement = new Node<>(firstElement, null, null);
        this.firstElement = new Node<>(null, null, lastElement);
    }

    @Override
    public void add(T value) {
        final Node<T> tempElement = lastElement;
        lastElement.setCurrentElement(value);
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
        new MyLinkedList<T>();
        this.size = 0;
    }

    @Override
    public void remove(int index) {
        Node<T> prevRemoveElement;
        Node<T> afterRemoveElement = firstElement.getNextElement();
        for (int i = 0; i < index + 2; i++) {
            if (i == (index - 1)) {
                prevRemoveElement = afterRemoveElement;
            }
            afterRemoveElement = afterRemoveElement.getNextElement();
        }

    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        Node<T> target = firstElement.getNextElement();
        for (int i = 0; i < index; i++) {
            target = target.getNextElement();
        }
        return target.getCurrentElement();
    }

    @Override
    public String toString() {
        String str = "[";
        Node<T> bufferNode = firstElement.getNextElement();
        for (int i = 0; i < size; i++) {
            str = str.concat(String.valueOf(bufferNode.getCurrentElement())).concat(" ");
            bufferNode = bufferNode.getNextElement();
        }
        return str.strip().concat("]");
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                return get(count++);
            }
        };
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
