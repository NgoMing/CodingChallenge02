package com.minhnln.roundTable.simulator;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static java.lang.System.in;
import static org.junit.Assert.*;

public class mainTest {

    @Test
    public void receiveInvalidNumberOfChildrenParam_NotBeIntegerFormat() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("abc".getBytes());
        System.setIn(in);

        assertFalse(main.receiveNumberOfChildrenParam());
    }

    @Test
    public void receiveInvalidNumberOfChildrenParam_NegativeNumber() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("-10".getBytes());
        System.setIn(in);

        assertFalse(main.receiveNumberOfChildrenParam());
    }

    @Test
    public void receiveInvalidJumpStepParam_NotBeIntegerFormat() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("abc".getBytes());
        System.setIn(in);

        assertFalse(main.receiveJumpStepParam());
    }

    @Test
    public void receiveInvalidJumpStepParam_NegativeNumber() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("-10".getBytes());
        System.setIn(in);

        assertFalse(main.receiveJumpStepParam());
    }

}