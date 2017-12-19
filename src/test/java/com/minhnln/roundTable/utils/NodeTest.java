package com.minhnln.roundTable.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class NodeTest {
    private static final Object[] getNode() {
        return new Object[] {
                new Object[] { null, null},
                new Object[] {   10, null},
                new Object[] {   -5, null}
        };
    }

    private static final Object[] setElements() {
        return new Object[]{
                new Object[]{null},
                new Object[]{10},
                new Object[]{-3}
        };
    }

    @Test
    @Parameters(method = "getNode")
    public void constructorWithParameters(Integer element, Node<Integer> next) {
        Node<Integer> node = new Node<>(element, next);

        assertEquals(element, node.getElement());
        assertEquals(next, node.getNext());
    }

    @Test
    @Parameters(method = "setElements")
    public void setElement(Integer element) {
        Node<Integer> node = new Node<>(20, null);
        node.setElement(element);

        assertEquals(element, node.getElement());
    }

    @Test
    @Parameters(method = "getNode")
    public void setNext(Integer element, Node<Integer> next) {
        Node<Integer> node = new Node<>(20, null);
        Node<Integer> newNode = new Node<>(element, next);

        node.setNext(newNode);
        assertEquals(newNode, node.getNext());
    }

}