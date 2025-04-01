package opgave01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testAddAndGetFirst() {
        list.add(1);
        assertEquals(1, list.getFirst());
    }

    @Test
    void testAddFirst() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.getFirst());
    }

    @Test
    void testRemoveFirst() {
        list.add(1);
        list.add(2);
        list.removeFirst();
        assertEquals(1, list.getFirst());
    }

    @Test
    void testContains() {
        list.add(1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testGet() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(1));
    }

    @Test
    void testAddAtIndex() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(1, 3);
        assertEquals(3, list.get(1));
    }

    @Test
    void testRemoveAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void testIndexOf() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(3));
    }
}