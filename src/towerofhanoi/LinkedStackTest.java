package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

public class LinkedStackTest extends TestCase {

    private LinkedStack<Integer> stack;

    public void setUp() {
        stack = new LinkedStack<Integer>();
    }


    public void testIsEmptyAtStart() {
        assertTrue(stack.isEmpty());
        assertTrue(stack.size() == 0);
    }


    public void testPushOne() {
        stack.push(5);
        assertFalse(stack.isEmpty());
        assertTrue(stack.size() == 1);
        assertEquals(5, stack.peek().intValue());
    }


    public void testPushMultiple() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.size() == 3);
        assertEquals(3, stack.peek().intValue());
    }


    public void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop().intValue());
        assertTrue(stack.size() == 1);
        assertEquals(1, stack.peek().intValue());
    }


    public void testPeekDoesNotRemove() {
        stack.push(7);
        assertEquals(7, stack.peek().intValue());
        assertTrue(stack.size() == 1);
    }


    public void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        assertTrue(stack.isEmpty());
        assertTrue(stack.size() == 0);
    }


    public void testPopEmpty() {
        Exception e = null;
        try {
            stack.pop();
        }
        catch (EmptyStackException ex) {
            e = ex;
        }
        assertNotNull(e);
    }


    public void testPeekEmpty() {
        Exception e = null;
        try {
            stack.peek();
        }
        catch (EmptyStackException ex) {
            e = ex;
        }
        assertNotNull(e);
    }


    public void testToStringEmpty() {
        assertEquals("[]", stack.toString());
    }


    public void testToStringNonEmpty() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("[3, 2, 1]", stack.toString());
    }


    public void testToStringDoesNotChangeStack() {
        stack.push(1);
        stack.push(2);
        String s = stack.toString();
        assertEquals("[2, 1]", s);
        assertTrue(stack.size() == 2);
        assertEquals(2, stack.peek().intValue());
    }


    public void testPopSingleElement() {
        stack.push(9);
        assertTrue(stack.pop() == 9);
        assertTrue(stack.isEmpty());
        assertTrue(stack.size() == 0);
    }


    public void testClearEmptyStack() {
        stack.clear();
        assertTrue(stack.isEmpty());
        assertTrue(stack.size() == 0);
        assertEquals("[]", stack.toString());
    }


    public void testToStringOneElement() {
        stack.push(4);
        assertEquals("[4]", stack.toString());
    }


    public void testMultiplePops() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.pop() == 3);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.pop() == 1);
        assertTrue(stack.isEmpty());
    }


    public void testSizeAfterSeveralOperations() {
        assertTrue(stack.size() == 0);

        stack.push(1);
        stack.push(2);
        assertTrue(stack.size() == 2);

        stack.pop();
        assertTrue(stack.size() == 1);

        stack.clear();
        assertTrue(stack.size() == 0);
    }
}
