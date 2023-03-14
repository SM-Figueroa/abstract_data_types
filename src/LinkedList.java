import java.util.Iterator;

public class LinkedList<K extends Comparable<K>, V> implements Iterable<LinkedListNode<K, V>> {
    private int size;
    private LinkedListNode<K, V> head;
    public LinkedList() {
        this.size = 0;
        this.head = null;
    }
    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("null key");
        }
        if (value == null) {
            throw new IllegalArgumentException("null value");
        }
        if (this.size == 0) {
            this.head = new LinkedListNode<>(key, value);
            this.size++;
            return;
        }
        LinkedListNode<K, V> temp = this.head;
        for (int i = 0; i < this.size; i++) {
            // might have to use compareTo when using generics
            if (key.compareTo(temp.getKey()) == 0) {
                throw new IllegalArgumentException("duplicate keys");
            }
            if (i != this.size - 1) {
                temp = temp.getNext();
            }
        }
        temp.setNext(new LinkedListNode<>(key, value));
        this.size++;
    }
    public boolean remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("null key");
        }
        if (this.head.getKey().compareTo(key) == 0) {
            this.head = this.head.getNext();
            this.size--;
            return true;
        }
        LinkedListNode<K, V> temp = this.head;
        for (int i = 1; i < this.size; i++) {
            if (key.compareTo(temp.getNext().getKey()) == 0) {
                temp.setNext(temp.getNext().getNext());
                this.size--;
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("null key");
        }
        LinkedListNode<K, V> temp = this.head;
        for (int i = 0; i < this.size; i++) {
            if (key.compareTo(temp.getKey()) == 0) {
                return temp.getValue();
            }
            temp = temp.getNext();
        }
        return null;
    }
    public boolean contains(K key) {
        if (key == null) {
            return false;
        }
        LinkedListNode<K, V> temp = this.head;
        for (int i = 0; i < this.size; i++) {
            if (key.compareTo(temp.getKey()) == 0) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    public int size() {
        return this.size;
    }
    public Iterator<LinkedListNode<K, V>> iterator() {
        return new LinkedListIterator<>(this.head);
    }
}
