import static org.junit.Assert.*;

public class StackTest {

    @org.junit.Test
    public void reset() {
        Stack s = new Stack();
        assertTrue(s.isEmpty());
        s.push("one");
        s.push("two");
        assertFalse(s.isEmpty());
        s.reset();
        assertTrue(s.isEmpty());
    }

    @org.junit.Test
    public void push() {
        Stack s = new Stack(5);
        for (int i = 0; i < 5; i++) {
            s.push(i);
        }
        s.push("hello");
    }

    @org.junit.Test
    public void peek() {
        Stack s = new Stack(5);
        for (int i = 0; i < 5; i++) {
            s.push(i);
        }
        s.push("hello");
        assertEquals("hello", s.peek());
        s.pop();
        assertEquals(4, s.peek());
    }

    @org.junit.Test
    public void pop() {
        Stack s = new Stack(5);
        for (int i = 0; i < 20; i++) {
            s.push(i);
        }
        for (int i = 0; i < 15; i++) {
            s.pop();
        }
        assertEquals(4, s.peek());
    }

    @org.junit.Test
    public void isEmpty() {
    }

    @org.junit.Test
    public void testToString() {
        Stack s = new Stack(5);
        for (int i = 0; i < 5; i++) {
            s.push(i);
        }
        s.push("hello");
        s.push(true);
        assertEquals("0,1,2,3,4,hello,true", s.toString());
    }
    @org.junit.Test
    public void toArray() {
        Stack s = new Stack(5);
        for (int i = 0; i < 5; i++) {
            s.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(s.toArray()[i]);
        }
    }
}