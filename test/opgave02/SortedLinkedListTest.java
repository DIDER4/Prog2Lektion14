package opgave02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListTest {
    private SortedLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SortedLinkedList<>();
    }

    @Test
    void testAdd() {
        list.add(3);
        list.add(1);
        list.add(2);
        assertEquals(1, list.getFirst());
        assertEquals(3, list.getLast());
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.remove(2));
        assertFalse(list.contains(2));
        assertEquals(2, list.size());
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
    void testGetFirst() {
        list.add(2);
        list.add(1);
        assertEquals(1, list.getFirst());
    }

    @Test
    void testRemoveFirst() {
        list.add(1);
        list.add(2);
        list.removeFirst();
        assertEquals(2, list.getFirst());
    }

    @Test
    void testGetLast() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.getLast());
    }

    @Test
    void testRemoveLast() {
        list.add(1);
        list.add(2);
        list.removeLast();
        assertEquals(1, list.getLast());
    }
}