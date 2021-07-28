package queue;

import interfaces.MyStack;

import java.util.Objects;

public class Stack<T> implements MyStack<T> {

    private int size = 0;
    private Node<T> firstElement;
    private Node<T> lastElement;

    Stack() {
        this.firstElement = null;
        this.lastElement = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        new Stack<>();
        size = 0;
    }

    @Override
    public void push(T value) {
        Node<T> addElement = new Node<>(value);
        if (firstElement == null) {
            firstElement = lastElement = addElement;
        } else {
            lastElement.setNext(addElement);
            lastElement = addElement;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            firstElement = firstElement.getNext();
            if (firstElement == null) {
                lastElement = null;
            }
        } else {
            Node<T> prev = getNode(index - 1);
            prev.setNext(prev.getNext().getNext());
            if (index == size - 1) {
                lastElement = prev;
            }
        }
        size--;
    }

    @Override
    public T peek() {
        return getNode(size - 1).getElement();
    }

    @Override
    public T pop() {
        T res = peek();
        remove(size - 1);
        return res;
    }

    static class Node<T> {
        private T element;
        private Node<T> next;

        Node(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> getNode(int index) {
        Node<T> currentElem = firstElement;
        for (int i = 0; i < index; i++) {
            currentElem = currentElem.getNext();
        }
        return currentElem;
    }
}
