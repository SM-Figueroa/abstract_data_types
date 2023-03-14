public class LinkedListNode<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private LinkedListNode<K, V> next;
    public LinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    public LinkedListNode<K, V> getNext() {
        return this.next;
    }
    public void setNext(LinkedListNode<K, V> next) {
        this.next = next;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }
    public boolean hasNext() {
        return this.next != null;
    }
}
