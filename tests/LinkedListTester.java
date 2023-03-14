import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedListTester {

    @org.junit.Test
    public void insertTest() {
        LinkedList<String, String> L = new LinkedList<>();
        L.insert("five", "5");
        L.insert("one", "1");
        assertEquals("5", L.get("five"));
        assertEquals("1", L.get("one"));
    }

    @org.junit.Test
    public void removeTest() {
        LinkedList<Integer, String> L = new LinkedList<>();
        L.insert(2, "remove this item");
        assertTrue(L.remove(2));
        assertEquals(0, L.size());
    }

    @org.junit.Test
    public void getTest() {
        LinkedList<String, String> L = new LinkedList<>();
        L.insert("one", "DSC");
        L.insert("two", "CSE");
        assertEquals("CSE", L.get("two"));
        assertNull(L.get("five"));
    }

    @org.junit.Test
    public void containsTest() {
        LinkedList<Integer, String> L = new LinkedList<>();
        L.insert(9, "abc");
        L.insert(10, "def");
        L.insert(11, "ghi");
        L.insert(12, "jkl");
        assertTrue(L.contains(9));
        assertFalse(L.contains(8));
        assertTrue(L.contains(12));
    }

    @org.junit.Test
    public void sizeTest() {
        LinkedList<Integer, String> L = new LinkedList<>();
        assertEquals(L.size(), 0);
        L.insert(1, "my");
        assertEquals(L.size(), 1);
        L.insert(2, "name");
        L.insert(3, "is");
        L.insert(4, "bob");
        assertEquals(L.size(), 4);
    }

    @org.junit.Test
    public void iteratorTest() {
        LinkedList<Integer, String> L = new LinkedList<>();
        L.insert(1, "my");
        L.insert(2, "name");
        L.insert(3, "is");
        L.insert(4, "bob");
        L.insert(5, "abc");
        L.insert(6, "def");
        L.insert(7, "ghi");
        L.insert(8, "jkl");
        int i = 1;
        for (LinkedListNode<Integer, String> temp: L) {
            assertEquals((int) temp.getKey(), i);
            i++;
        }
        Iterator<LinkedListNode<Integer, String>> iter = L.iterator();
        for (int x = 0; x < 3; x++) {
            iter.next();
        }
        assertEquals("bob", iter.next().getValue());
    }
}
