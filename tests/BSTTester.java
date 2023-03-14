import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTester {

    @Test
    public void getHeight() {
        BST<Integer, String> bst = new BST<>();
        assertEquals(0, bst.getHeight());
        bst.insert(4, "top");
        assertEquals(1, bst.getHeight());
        bst.insert(3, "left");
        bst.insert(5, "right");
        assertEquals(2, bst.getHeight());
        bst.insert(2, "extend");
        assertEquals(3, bst.getHeight());
    }

    @Test
    public void getInOrderTraversal() {
        BST<Integer, String> bst = new BST<>();
        bst.insert(5, "top");
        bst.insert(4, "left");
        bst.insert(6, "right");
        bst.insert(2, "extend");
        bst.insert(3, "left");
        bst.insert(1, "left");
        bst.insert(8, "right");
        bst.getInOrderTraversal();
    }

    @Test
    public void insert() {
        BST<Integer, String> bst = new BST<>();
        bst.insert(4, "top");
        bst.insert(3, "left");
        bst.insert(5, "right");
        bst.insert(2, "extend");
        assertTrue(bst.contains(4));
        assertTrue(bst.contains(2));
        assertEquals(4, bst.size());
    }

    @Test
    public void remove() {
        BST<Integer, String> bst = new BST<>();
        bst.insert(50, "arbitrary");
        bst.insert(20, "arbitrary");
        bst.insert(10, "arbitrary");
        bst.insert(15, "arbitrary");
        bst.insert(25, "arbitrary");
        bst.insert(22, "arbitrary");
        bst.insert(30, "arbitrary");
        bst.insert(27, "arbitrary");
        bst.insert(5, "arbitrary");
        bst.insert(80, "arbitrary");
        bst.insert(90, "arbitrary");
        bst.insert(100, "arbitrary");
        bst.insert(70, "arbitrary");
        bst.insert(75, "arbitrary");
        bst.insert(95, "arbitrary");

        assertTrue(bst.remove(20));
        assertFalse(bst.contains(20));
        assertTrue(bst.remove(15));

        assertFalse(bst.remove(69));
        assertEquals(13, bst.size());
        assertEquals(5, bst.getHeight());
        assertTrue(bst.remove(5));
        assertTrue(bst.remove(95));
        assertTrue(bst.remove(27));
        assertEquals(4, bst.getHeight());

        BST<Integer, String> empty = new BST<>();
        assertFalse(empty.remove(0));
        empty.insert(5, "five");
        assertTrue(empty.remove(5));
    }

    @Test
    public void search() {
        BST<Integer, String> bst = new BST<>();
        bst.insert(8, "hello");
        bst.insert(5, "my");
        bst.insert(10, "name");
        bst.insert(9, "is");
        bst.insert(4, "bob");

        assertEquals("bob", bst.search(4));
        assertEquals("name", bst.search(10));
        bst.remove(8);
        assertNull(bst.search(8));
    }

    @Test
    public void contains() {
        BST<Integer, String> bst = new BST<>();
        bst.insert(50, "arbitrary");
        bst.insert(25, "arbitrary");
        bst.insert(20, "arbitrary");
        bst.insert(35, "arbitrary");
        bst.insert(30, "arbitrary");
        bst.insert(40, "arbitrary");
        bst.insert(45, "arbitrary");
        bst.insert(15, "arbitrary");
        bst.insert(10, "arbitrary");
        bst.insert(23, "arbitrary");
        bst.insert(75, "arbitrary");
        bst.insert(95, "arbitrary");
        bst.insert(80, "arbitrary");
        bst.insert(90, "arbitrary");
        bst.insert(85, "arbitrary");
        bst.insert(87, "arbitrary");

        assertTrue(bst.contains(23));
        assertTrue(bst.contains(10));

        bst.remove(50);
        bst.remove(10);

        assertFalse(bst.contains(50));
        assertFalse(bst.contains(10));
    }

    @Test
    public void size() {
        BST<Integer, String> bst = new BST<>();
        assertEquals(0, bst.size());
        bst.insert(5, "test");
        assertEquals(1, bst.size());
        bst.insert(50, "arbitrary");
        bst.insert(25, "arbitrary");
        bst.insert(20, "arbitrary");
        bst.insert(35, "arbitrary");
        bst.insert(30, "arbitrary");
        bst.insert(40, "arbitrary");
        bst.insert(45, "arbitrary");
        bst.insert(15, "arbitrary");
        bst.insert(10, "arbitrary");

        bst.remove(10);
        bst.remove(35);
        bst.remove(40);
        bst.remove(15);
        assertEquals(6, bst.size());
    }
}
