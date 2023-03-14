public class BST<K extends Comparable<K>, V> {
    int size;
    Node root;
    boolean left;
    public BST() {
        this.size = 0;
        this.root = null;
        this.left = true;
    }
    public int getHeight() {
        return heightRecursion(this.root);
    }

    private int heightRecursion(Node n) {
        if (n == null) {
            return 0;
        } else {
            return takeMax(1 + heightRecursion(n.leftChild),
                    1 + heightRecursion(n.rightChild));
        }
    }

    private int takeMax(int i, int j) {
        if (i > j) {
            return i;
        } else {
            return j;
        }
    }

    public void getInOrderTraversal() {
        inOrderRecursion(this.root);
    }
    private void inOrderRecursion(Node n) {
        if (n == null) {
            return;
        } else {
            inOrderRecursion(n.leftChild);
            System.out.println(n.key);
            inOrderRecursion(n.rightChild);
        }
    }

    public void insert(K key, V value) {
        if (key ==  null) {
            throw new IllegalArgumentException();
        } else if (this.size == 0) {
            this.root = new Node(key, value);
            this.size++;
        } else {
            insertRecursion(this.root, key, value);
            this.size++;
        }

    }
    private void insertRecursion(Node n, K key, V value) {
        if (key.compareTo(n.key) < 0) {
            if (n.leftChild ==  null) {
                n.leftChild = new Node(key, value);
            } else {
                insertRecursion(n.leftChild, key, value);
            }
        } else if (key.compareTo(n.key) > 0) {
            if (n.rightChild == null) {
                n.rightChild = new Node(key, value);
            } else {
                insertRecursion(n.rightChild, key, value);
            }
        } else {
            n.value = value;
        }
    }
    public boolean remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node toBeRemoved = getNode(this.root, key);
        if (toBeRemoved == null | this.root == null) {
            return false;
        }
        this.root = removeNodeRecursion(this.root, key);
        this.size--;
        return true;
    }

    private Node removeNodeRecursion(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.leftChild = removeNodeRecursion(node.leftChild, key);
        } else if (key.compareTo(node.key) > 0) {
            node.rightChild = removeNodeRecursion(node.rightChild, key);
        } else {
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }
            node.key = getSuccessor(node.rightChild);
            node.rightChild = removeNodeRecursion(node.rightChild, node.key);
        }
        return node;
    }

    private K getSuccessor(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node.key;
    }

    public V search(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node output = getNode(this.root, key);
        if (output == null) {
            return null;
        } else {
            return output.value;
        }
    }

    private Node getNode(Node n, K key) {
        if (n == null) {
            return null;
        } else if (key.compareTo(n.key) == 0) {
            return n;
        } else if (key.compareTo(n.key) < 0) {
            return getNode(n.leftChild, key);
        } else {
            return getNode(n.rightChild, key);
        }
    }

    public boolean contains(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node output = getNode(this.root, key);
        return output != null;
    }

    public int size() {
        return this.size;
    }

    public class Node {
        K key;
        V value;
        Node leftChild;
        Node rightChild;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.leftChild = left;
            this.rightChild = right;
        }
    }

}
