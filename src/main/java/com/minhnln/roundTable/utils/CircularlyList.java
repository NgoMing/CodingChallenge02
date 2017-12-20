package com.minhnln.roundTable.utils;

public class CircularlyList<E> implements IList<E>, IRotatable {
    private Node<E> tail;
    private int size;

    // constructors
    public CircularlyList() {
        tail = null;
        size = 0;
    }

    public CircularlyList(E[] array) {
        for (int i = 0; i < array.length; i++)
            addLast(array[i]);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public E getFirst() {
        return tail.getNext().getElement();
    }

    @Override
    public E getLast() {
        return tail.getElement();
    }

    @Override
    public void addFirst(E element) {
        if (isEmpty()) {
            tail = new Node(element, null);
            tail.setNext(tail);
        }
        else {
            Node newNode = new Node(element, tail.getNext());
            tail.setNext(newNode);
        }
        size ++;
    }

    @Override
    public void addLast(E element) {
        addFirst(element);
        tail = tail.getNext();
    }

    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;

        Node<E> head = tail.getNext();
        if (head == tail)
            tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    @Override
    public E[] toArray() {
        if (isEmpty())
            return null;

        Node<E> tempNode = tail.getNext();
        E[] array = (E[])new Object[size];

        for (int i = 0; i < size; i++) {
            array[i] = tempNode.getElement();
            tempNode = tempNode.getNext();
        }

        return array;
    }

    @Override
    public void rotate(int numOfStep) throws IllegalArgumentException {
        if (isEmpty())
            return;

        if (numOfStep < 0)
            throw new IllegalArgumentException("number of steps (" + numOfStep + ") should be positive");

        if (numOfStep >= size)
            numOfStep = numOfStep % size;

        for (int i = 0; i < numOfStep; i++)
            this.tail = this.tail.getNext();
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        if (isEmpty())
            return "";

        Node<E> tempNode = tail.getNext();
        for (int i = 0; i < size; i++, tempNode = tempNode.getNext()) {
            report.append(tempNode.getElement() + " ");
        }

        return report.toString();
    }
}
