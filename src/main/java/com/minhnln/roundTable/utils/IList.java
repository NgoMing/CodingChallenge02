package com.minhnln.roundTable.utils;

public interface IList<E> {
    int size();
    boolean isEmpty();

    // access methods
    E getFirst();
    E getLast();

    // update methods
    void addFirst(E e);
    void addLast(E e);

    E removeFirst();

    // test-supporting methods
    E[] toArray();
}
