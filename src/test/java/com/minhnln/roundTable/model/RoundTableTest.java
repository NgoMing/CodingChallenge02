package com.minhnln.roundTable.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class RoundTableTest {
    /* Create test cases for constructor testing
     * Including: number of children
     *            number of children skipped
     */
    private static final Object[] getTableConstructors() {
        return new Object[] {
                new Object[] {5, 1},
                new Object[] {14, 4}
        };
    }

    /* Create sequential test states for playEachTurn method
     * Including: number of children
     *            number of children skipped
     *            each state in the process of play a game
     */
    private static final Object[] getStatesOfEachStepPlaying() {
        return new Object[] {
                new Object[] { 5, 3, new Integer[] {3},
                        new Integer[] {3, 1},
                        new Integer[] {3, 1, 5},
                        new Integer[] {3, 1, 5, 2}}
        };
    }

    /* Create test cases for end-end testing
     * Including: number of children
     *            number of children skipped
     *            list of children which is out
     *            the id of the winner
     */
    private static final Object[] getTestCases() {
        return new Object[] {
                new Object[] {5, 1, new Integer[]{1, 2, 3, 4}, 5},
                new Object[] {7, 3, new Integer[]{3, 6, 2, 7, 5, 1}, 4},
                new Object[] {4, 11, new Integer[]{3, 1, 2}, 4},
                new Object[] {14, 4, new Integer[]{4, 8, 12, 2, 7, 13, 5, 11, 6, 1, 14, 3, 10}, 9},
                new Object[] {8, 3, new Integer[]{3, 6, 1, 5, 2, 8, 4}, 7}
        };
    }

    /* Create test cases for end-end testing of performance
     * Including: number of children
     *            number of children skipped
     *            the if of the winner
     */
    private static final Object[] getTestCasesForPerformace() {
        return new Object[] {
                new Object[] {500000, 10, 20687},
                new Object[] {1000000, 123, 137456}
        };
    }

    @Test
    @Parameters(method = "getStatesOfEachStepPlaying")
    public void playEachTurn(int numOfChildren, int jumpStep, Integer[]... states) throws Exception {
        RoundTable table = new RoundTable(numOfChildren, jumpStep);
        for (Integer[] state : states) {
            table.playEachTurn();
            assertArrayEquals(state, table.getChildrenOut().toArray());
        }
    }

    @Test
    @Parameters(method = "getTableConstructors")
    public void constructor(int numOfChildren, int jumStep) {
        RoundTable table = new RoundTable(numOfChildren, jumStep);
        assertEquals(numOfChildren, table.getNumOfChildren());
        assertEquals(jumStep, table.getJumpStep());
    }

    @Test
    @Parameters(method = "getTestCases")
    public void playNormalCases(int numOfChildren, int jumpStep,
                     Integer[] childrenOutList, int winnerID) throws Exception {
        RoundTable table = new RoundTable(numOfChildren, jumpStep);

        int realWinnerID = table.play();
        assertArrayEquals(childrenOutList, table.getChildrenOut().toArray());
        assertEquals(winnerID, realWinnerID);
    }

    @Test
    @Parameters(method = "getTestCasesForPerformace")
    public void playPerformanceCases(int numOfChildren, int jumpStep, int winnerID) throws Exception {
        RoundTable table = new RoundTable(numOfChildren, jumpStep);

        int realWinnerID = table.play();
        assertEquals(winnerID, realWinnerID);
    }
}