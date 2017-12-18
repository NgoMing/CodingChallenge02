package com.minhnln.roundTable.utils;

public class Node<E> {
    private E element;
    private Node<E> next;

    // constructors
    public Node(E element, Node<E> next) {
        setElement(element);
        setNext(next);
    }

    // access methods
    public E getElement() { return element; }
    public Node<E> getNext() { return next; }

    // update methods
    public void setElement(E element) { this.element = element; }
    public void setNext(Node<E> next) { this.next = next; }
}
