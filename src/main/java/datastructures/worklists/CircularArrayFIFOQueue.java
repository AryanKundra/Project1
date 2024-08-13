package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FixedSizeFIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See cse332/interfaces/worklists/FixedSizeFIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
    private E[] array;
    private int front;
    private int end;
    private int size;

    private int capacity;

    private boolean isEmpty(){
        return size() == 0;
    }

    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.front = 0;
        this.end = 0;

    }

    @Override
    public void add(E work) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        array[end] = work;
        end = (end + 1) % capacity;
        size++;
    }


    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[front];
    }

    @Override
    public E peek(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int index = (front + i) % capacity;
        return array[index];
    }
    @Override
    public E next() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E result = array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    @Override
    public void update(int i, E value) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();

        }
        int index = (front+i)%capacity;
        array[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
        front = 0;
        end = 0;

        size = 0;

    }

    @Override
    public int compareTo(FixedSizeFIFOWorkList<E> other) {
        // You will implement this method in project 2. Leave this method unchanged for project 1.
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // You will finish implementing this method in project 2. Leave this method unchanged for project 1.
        if (this == obj) {
            return true;
        } else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        } else {
            // Uncomment the line below for p2 when you implement equals
            // FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            // Your code goes here

            throw new NotYetImplementedException();
        }
    }

    @Override
    public int hashCode() {
        // You will implement this method in project 2. Leave this method unchanged for project 1.
        throw new NotYetImplementedException();
    }
}
