import java.util.Iterator;
public class LinkedListIterator<K extends Comparable<K>, V>
        implements Iterator<LinkedListNode<K, V>> {
    LinkedListNode<K, V> currentNode;
    public LinkedListIterator(LinkedListNode<K, V> head) {
        this.currentNode = head;
    }
    public boolean hasNext() {
        return this.currentNode != null;
    }
    public LinkedListNode<K, V> next() {
        if (this.currentNode == null) {
            return null;
        }
        LinkedListNode<K, V> temp = this.currentNode;
        this.currentNode = this.currentNode.getNext();
        return temp;
    }
}
