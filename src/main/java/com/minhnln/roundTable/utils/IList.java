package com.minhnln.roundTable.dataStructure;

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
    E removeLast();

    // test-supporting methods
    E[] toArray();
}
