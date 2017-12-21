package com.minhnln.roundTable.simulator;

import com.minhnln.roundTable.model.RoundTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    static int numOfChildren;
    static int jumStep;
    static RoundTable table;

    public static void main(String[] args) throws IOException {
        while(!receiveNumberOfChildrenParam()) {}
        while(!receiveJumpStepParam()) {}
        table = new RoundTable(numOfChildren, jumStep);
        table.play();
        System.out.println(table);
    }

    public static boolean receiveNumberOfChildrenParam() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of children (positive number): ");
        String readString = br.readLine();
        try {
            numOfChildren = Integer.parseInt(readString);
        }
        catch (NumberFormatException nfe) {
            System.out.println("Invalid Format! " + readString + " is not a number\n");
            return false;
        }

        if (numOfChildren <= 0) {
            System.out.println("Number of children (" + numOfChildren + ") should be positive\n");
            return false;
        }

        return true;
    }
    public static boolean receiveJumpStepParam() throws IOException {
        boolean result = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the jump step (non-negative number): ");
        String readString = br.readLine();
        try {
            jumStep = Integer.parseInt(readString);
        }
        catch (NumberFormatException nfe) {
            System.out.println("Invalid Format! " + readString + " is not a number\n");
            result = false;
        }

        if (jumStep < 0) {
            System.out.println("Jump step (" + jumStep + ") should be non-negative\n");
            result = false;
        }

        return result;
    }


}
