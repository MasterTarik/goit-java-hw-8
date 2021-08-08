package map;
import java.util.StringJoiner;

class MyHashMap<T, E> {

    private MyHashMap.Node<T, E>[] table;
    private int size;
    private float threshold;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public MyHashMap() {
        table = new MyHashMap.Node[DEFAULT_INITIAL_CAPACITY];
        threshold = table.length * DEFAULT_LOAD_FACTOR;
        size = 0;
    }

    public int size() {
        return size;
    }

    private MyHashMap.Node<T, E> getNextNode(MyHashMap.Node<T, E> current) {
        return current.getNext();
    }

    public void put(T key, E value) {
        if (key == null) {
            putForNullKey(value);
            return;
        }
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        addNode(key, value, hash, index);
    }

    private void addNode(T key, E value, int hash, int index) {
        MyHashMap.Node<T, E> newNode = new MyHashMap.Node<>(hash, key, value, null);
        MyHashMap.Node<T, E> current = table[index];
        if (current == null) {
            table[index] = newNode;
            size++;
            return;
        } else {
            do {
                if (current.hash == hash && (current.key == key || key.equals(current.key))) {
                    current.value = value;
                    return;
                }
                if (current.getNext() != null) {
                    current = current.getNext();
                } else {
                    break;
                }
            } while (current != null);
            current.setNext(newNode);
            size++;
        }
    }

    private void putForNullKey(E value) {
        addNode(null, value, 0, 0);
    }

    private static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private int hash(T key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public E remove(T key) {
        MyHashMap.Node<T, E> removedNode = null;
        MyHashMap.Node<T, E> node = null;
        for (int i = 0; i < table.length; i++) {

            if (table[i] != null) {
                if (table[i].key == key) {
                    removedNode = table[i];
                    if (table[i].getNext() == null) {
                        table[i] = null;
                    } else {
                        table[i] = table[i].getNext();
                    }
                    size--;
                    return removedNode.getValue();
                }
                node = table[i].getNext();
            }
            while (node != null) {
                if (node.key == key) {
                    removedNode = node;
                    if (node.getNext() == null) {
                        node = null;
                    } else {
                        node = node.getNext();
                    }
                    size--;
                    return removedNode.getValue();
                }
            }
        }
        return removedNode.getValue();
    }

    public E get(T key) {
        for (MyHashMap.Node<T, E> node : table) {
            if (node != null) {
                if (node.key == key) {
                    return node.getValue();
                } else {
                    while (node != null) {
                        node = node.getNext();
                        if (node != null) {
                            if (node.key == key) {
                                return node.getValue();
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                MyHashMap.Node<T, E> node = table[i].getNext();
                if (node != null) {
                    while (node != null) {
                        if (node.getNext() != null) {
                            MyHashMap.Node<T, E> next = node.getNext();
                            node.setNext(null);
                            node = next;
                        } else {
                            break;
                        }
                    }
                }
            }
            table[i] = null;
        }
        size = 0;
    }

    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        MyHashMap.Node<K, V> next;

        public Node(int hash, K key, V value, MyHashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public MyHashMap.Node<K, V> getNext() {
            return next;
        }

        public void setNext(MyHashMap.Node<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + ", key=" + key + ", value=" + value + '}';
        }
    }

    @Override
    public String toString() {
        String begining = "MyHashMap{" +
                "size=" + size + ", nodes: [";
        StringJoiner joiner = new StringJoiner(", ", begining, "]}");
        for (MyHashMap.Node<T, E> node : table) {
            if (node == null) {
            } else {
                joiner.add(node.toString());
                while (node.getNext() != null) {
                    node = getNextNode(node);
                    joiner.add(node.toString());
                }
            }
        }
        return joiner.toString();
    }
}