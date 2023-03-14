import static org.junit.Assert.*;

public class HashTableTester {

    @org.junit.Test
    public void insert() {
        HashTable ht = new HashTable();
        ht.insert("hello");
        assertEquals(1, ht.size());
        ht.insert("my");
        ht.insert("name");
        assertTrue(ht.lookup("name"));
        assertFalse(ht.insert("my"));
        assertFalse(ht.insert("name"));
        assertFalse(ht.insert("hello"));
    }

    @org.junit.Test
    public void delete() {
        HashTable ht = new HashTable();
        ht.insert("hello");
        ht.delete("hello");
        assertEquals(0, ht.size());
        assertTrue(ht.insert("hello"));
        ht.insert("my");
        ht.insert("name");
        ht.insert("is");
        ht.insert("bob");
        ht.delete("my");
        assertFalse(ht.lookup("my"));
    }

    @org.junit.Test
    public void lookup() {
        HashTable ht = new HashTable();
        assertFalse(ht.lookup("anything"));
        ht.insert("value");
        assertTrue(ht.lookup("value"));
        ht.insert("my");
        ht.insert("name");
        ht.insert("is");
        ht.insert("bob");
        assertTrue(ht.lookup("name"));
    }

    @org.junit.Test
    public void size() {
        HashTable ht = new HashTable();
        assertEquals(0, ht.size());
        String temp = "w";
        for (int x = 0; x < 19; x++) {
            ht.insert(temp);
            temp += "w";
        }
        // Hash function depends on capacity so not deterministic. Nice !
        assertFalse(ht.insert("w"));
        assertTrue(ht.lookup("wwwww"));
        assertEquals(19, ht.size());
        ht.delete("w");
        ht.delete("ww");
        assertEquals(17, ht.size());
    }

    @org.junit.Test
    public void capacity() {
        HashTable h = new HashTable();
        assertEquals(15, h.capacity());
        HashTable ht = new HashTable(7);
        assertEquals(7, ht.capacity());
        String temp = "w";
        for (int x = 0; x < 10; x++) {
            ht.insert(temp);
            temp += "w";
        }
        assertEquals(28, ht.capacity());
    }

    @org.junit.Test
    public void getStatsLog() {
        HashTable ht = new HashTable();
        assertEquals("", ht.getStatsLog());
        String temp = "l";
        for (int x = 0; x < 19; x++) {
            ht.insert(temp);
            temp += "l";
        }
        ht.delete("l");
        ht.delete("ll");
        assertEquals("""
                Before rehash # 1: load factor 0.60, 2 collision(s).
                Before rehash # 2: load factor 0.57, 9 collision(s).
                """, ht.getStatsLog());
        for (int x = 0; x < 50; x++) {
            ht.insert(temp);
            temp += "l";
        }
        assertEquals("""
                Before rehash # 1: load factor 0.60, 2 collision(s).
                Before rehash # 2: load factor 0.57, 9 collision(s).
                Before rehash # 3: load factor 0.55, 44 collision(s).
                Before rehash # 4: load factor 0.55, 171 collision(s).
                """, ht.getStatsLog());
    }

    @org.junit.Test
    public void testToString() {
        HashTable ht = new HashTable();
        assertEquals("[null, null, null, null, null, null, null, null, null, " +
                "null, null, null, null, null, null]", ht.toString());
        String temp = "x";
        ht.insert(temp);
        temp += "x";
        assertEquals("[x, null, null, null, null, null, null, null, null, " +
                "null, null, null, null, null, null]", ht.toString());
        for (int x = 0; x < 12; x++) {
            ht.insert(temp);
            temp += "x";
        }
        assertEquals("[x, xx, xxx, xxxx, xxxxx, xxxxxxx, xxxxxxxxxxx, null, " +
                "null, null, null, null, xxxxxxxxxx, null, null, xxxxxxxxxxxxx, xxxxxx, xxxxxxxxx, " +
                "xxxxxxxx, xxxxxxxxxxxx, null, null, null, null, null, null, null, null, null, null]",
                ht.toString());
    }
}
