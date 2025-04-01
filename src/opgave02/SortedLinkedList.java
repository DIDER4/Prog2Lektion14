package opgave02;

import opgave02.models.SortedListEaaa;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedLinkedList<E extends Comparable<E>> implements SortedListEaaa<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null || head.data.compareTo(e) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null && current.next.data.compareTo(e) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(E e) {
        if (head == null) return false;

        if (head.data.equals(e)) {
            head = head.next;
            size--;
            return true;
        }

        Node<E> current = head;
        while (current.next != null && !current.next.data.equals(e)) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        size--;
        return true;
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new NoSuchElementException();
        head = head.next;
        size--;
    }

    @Override
    public E getLast() {
        if (head == null) throw new NoSuchElementException();
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void removeLast() {
        if (head == null) throw new NoSuchElementException();
        if (head.next == null) {
            head = null;
        } else {
            Node<E> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    @Override
    public Iterator<E> descendingIterator() {
        throw new UnsupportedOperationException("Descending iterator not supported");
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}