import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void enQueue() {
        Queue q = new Queue(5);
        for (int i = 0; i < 7; i++) {
            q.enQueue(i);
        }
        assertEquals("0,1,2,3,4,5,6", q.toString());
    }

    @Test
    public void deQueue() {
        Queue q = new Queue(5);
        for (int i = 0; i < 7; i++) {
            q.enQueue(i);
        }
        assertEquals(0, q.deQueue());
        assertEquals("1,2,3,4,5,6", q.toString());
        q.deQueue();
        q.deQueue();
        assertEquals("3,4,5,6", q.toString());
    }

    @Test
    public void peek() {
        Queue q = new Queue(5);
        for (int i = 0; i < 3; i++) {
            q.enQueue(i);
        }
        assertEquals(0, q.deQueue());
        assertEquals(1, q.peek());
        assertEquals(1, q.deQueue());
        assertEquals(2, q.peek());
        assertEquals(2, q.deQueue());
        assertNull(q.peek());
    }

    @Test
    public void reset() {
        Queue q = new Queue(5);
        for (int i = 0; i < 7; i++) {
            q.enQueue(i);
        }
        q.reset();
        assertNull(q.peek());
        assertTrue(q.isEmpty());
    }

    @Test
    public void isEmpty() {
        Queue q = new Queue(5);
        assertTrue(q.isEmpty());
        for (int i = 0; i < 7; i++) {
            q.enQueue(i);
        }
        assertFalse(q.isEmpty());
        q.reset();
        assertTrue(q.isEmpty());
    }

    @Test
    public void testToString() {
        Queue q = new Queue(5);
        for (int i = 0; i < 7; i++) {
            q.enQueue(i);
        }
        assertEquals(0, q.deQueue());
        assertEquals("1,2,3,4,5,6", q.toString());
        q.reset();
        String[] s = new String[]{"H","E","L","L","O"};
        for (int i = 0; i < 5; i++) {
            q.enQueue(s[i]);
        }
        assertEquals("H,E,L,L,O", q.toString());
        q.enQueue(5);
        q.enQueue(true);
        assertEquals("H,E,L,L,O,5,true", q.toString());
        q.deQueue();
        assertEquals("E,L,L,O,5,true", q.toString());
    }
    @org.junit.Test
    public void toArray() {
        Queue q = new Queue(5);
        for (int i = 0; i < 7; i++) {
            q.enQueue(i);
        }
        for (int i = 0; i < 7; i++) {
            System.out.println(q.toArray()[i]);
        }
    }
}