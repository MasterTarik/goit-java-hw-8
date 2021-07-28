package list;

import interfaces.DescendingIterator;
import interfaces.MyList;
import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<T> implements MyList<T>, Iterable<T>, DescendingIterator<T> {

    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size = 0;

    public MyLinkedList() {
        this.firstElement = null;
        this.lastElement = null;
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

    public void addIndex(int index, T value) {
        Objects.checkIndex(index, size + 1);
        Node<T> addElem = new Node<>(value);
        if (firstElement == null) {
            firstElement = lastElement = addElem;
        } else if (size == 0) {
            addElem.setNextElement(firstElement);
            firstElement = addElem;
        } else if (index == size) {
            lastElement.setNextElement(addElem);
            lastElement = addElem;
        } else {
            Node<T> currentElem = getNode(index);
            addElem.setNextElement(currentElem.getNextElement());
            currentElem.setNextElement(addElem);
        }
        size++;
    }

    private Node<T> getNode(int index) {
        Node<T> currentElem = firstElement;
        for (int i = 0; i < index; i++) {
            currentElem = currentElem.getNextElement();
        }
        return currentElem;
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
    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).getCurrentElement();
    }

    @Override
    public String toString() {
        String str = "[";
        Node<T> bufferNode = firstElement;
        for (int i = 0; i < size; i++) {
            str = str + String.valueOf(bufferNode.getCurrentElement()) + " ";
            bufferNode = bufferNode.getNextElement();
        }
        return str.strip().concat("]");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter > 0;
            }

            @Override
            public T next() {
                return get(counter--);
            }
        };
    }


    private static class Node<T> {
        private T currentElement;
        private Node<T> nextElement;

        Node(T element) {
            this.currentElement = element;
        }

        Node(T currentElement, Node<T> nextElement) {
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
