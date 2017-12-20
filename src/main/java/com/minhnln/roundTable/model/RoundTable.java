package com.minhnln.roundTable.model;

import java.lang.StringBuilder;
import com.minhnln.roundTable.utils.CircularlyList;

public class RoundTable {
    final private String REPORT_WINNER = "The winner has the id of ";
    final private String REPORT_LOSER = "The id(s) of child(ren) going out is(are) ";

    private int numOfChildren;                      // number of children - n
    private int jumpStep;                           // number of children will be counted in each turn - k
    private CircularlyList<Integer> table =
            new CircularlyList<>();                 // table for children to play

    private CircularlyList<Integer> childrenOut =
            new CircularlyList<>();    // for testing
    private StringBuilder report = new StringBuilder();

    // constructors
    public RoundTable(int numOfChildren, int jumpStep) {
        this.numOfChildren = numOfChildren;
        this.jumpStep = jumpStep;

        // create ids for children playing at the table
        for (int i = 0; i < numOfChildren; i++) {
            table.addLast(i + 1);
        }
    }

    // access methods
    public int getNumOfChildren() {
        return numOfChildren;
    }

    public int getJumpStep() {
        return jumpStep;
    }

    public CircularlyList<Integer> getChildrenOut() {
        return childrenOut;
    }

    /* This is the method for each play:
     * Count from 1 until jumpStep k: rotate the table k times
     * Remove the k'th child: remove the first element of the table after rotating
     */
    public void playEachTurn() {
        table.rotate(jumpStep - 1);
        int idChildOut = table.getFirst();
        table.removeFirst();
        report.append(idChildOut);
        childrenOut.addLast(idChildOut);
    }

    /* This is the main method of challenge - play the round table game
     * @return int: the id of the winner of the game
     */
    public int play() {
        report.append(REPORT_LOSER);
        while (table.size() > 1) {
            playEachTurn();
        }
        int winnerId = table.getFirst();
        report.append("\n" + REPORT_WINNER + winnerId);
        return winnerId;
    }

    @Override
    public String toString() {
        return report.toString();
    }
}
