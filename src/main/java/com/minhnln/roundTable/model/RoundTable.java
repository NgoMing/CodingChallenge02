package com.minhnln.roundTable.model;

import java.lang.StringBuilder;
import com.minhnln.roundTable.utils.CircularlyList;

public class RoundTable {
    final private String REPORT_WINNER = "The winner has the id of ";
    final private String REPORT_LOSER = "The id(s) of child(ren) going out is(are) ";
    final private String REPORT_DELIMITER = ", ";

    private int numOfChildren;              // number of children - n
    private int jumpStep;                   // number of children will be counted in each turn - k
    private CircularlyList<Integer> table =
            new CircularlyList<>();         // table for children to play
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

    // play methods
    public void playEachTurn() {
        table.rotate(jumpStep - 1);
        int idChildOut = table.getFirst();
        table.removeFirst();
        report.append(idChildOut);
    }

    public void play() {
        if (numOfChildren == 1) {
            report.append(REPORT_WINNER + table.getFirst());
            return;
        }

        report.append(REPORT_LOSER);
        if (numOfChildren > 2) {
            for (int i = 0; i < numOfChildren - 2; i++) {
                playEachTurn();
                report.append(REPORT_DELIMITER);
            }
        }
        playEachTurn();
        report.append("\n" + REPORT_WINNER + table.getFirst());
    }

    @Override
    public String toString() {
        return report.toString();
    }
}
