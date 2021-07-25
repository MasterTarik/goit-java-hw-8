package list;

import interfaces.MyList;

import java.util.Arrays;

public class MyArrayList<T> implements MyList {

    private T[] elementData;
    private int size = 0;
    private int capacity;

    public MyArrayList() {
        this.capacity = 10;
        this.elementData = (T[]) new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.elementData = (T[]) new Object[capacity];
    }

    @Override
    public void add(Object value) {
        ensureCapacity();
        elementData[size++] = (T) value;
    }

    @Override
    public void remove(int index) {
        System.arraycopy(elementData, index + 1, elementData, index, elementData.length - (index + 1));
        elementData[size--] = null;
    }

    @Override
    public void clear() {
        Arrays.fill(elementData, null);
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return elementData[index];
    }

    @Override
    public String toString() {
        String str = "[";
        for (Object s : elementData) {
            if (s == null) {
                break;
            }
            str = str + String.valueOf(s) + " ";
        }
        return str.strip().concat("]");
    }

    private void ensureCapacity() {
        try {
            if (size + 1 > this.capacity) {
                this.capacity = (this.capacity * 3) / 2 + 1;
                T[] bufCapacity = (T[]) new Object[capacity];
                System.arraycopy(elementData, 0, this.elementData = (T[]) new Object[this.capacity], 0, this.size);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
