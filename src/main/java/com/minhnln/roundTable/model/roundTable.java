package com.minhnln.roundTable.model;

import java.lang.StringBuilder;
import com.minhnln.roundTable.utils.CircularlyList;

public class roundTable {
    final private String REPORT_WINNER = "The winner has the id of ";
    final private String REPORT_LOSER = "The id(s) of child(ren) going out is(are) ";
    final private String REPORT_DELIMITER = ", ";

    private int numOfChildren;              // number of children - n
    private int jumpStep;                   // number of children will be counted in each turn - k
    private CircularlyList<Integer> table;  // table for children to play
    private StringBuilder report = new StringBuilder();

    // constructors
    public roundTable(int numOfChildren, int jumpStep) {
        this.numOfChildren = numOfChildren;
        this.jumpStep = jumpStep;

        int id = 1; // id of each child

        // create ids for children playing at the table
        for (int i = 0; i < numOfChildren; i++) {
            table.addLast(id++);
        }
    }

    // play methods
    public void playEachTurn() {
        table.rotate(jumpStep);
        int idChildOut = table.getFirst();
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
