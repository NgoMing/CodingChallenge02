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
        boolean result = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of children (positive number): ");
        try {
            numOfChildren = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
            result = false;
        }

        if (numOfChildren <= 0) {
            System.err.println("Number of children (" + numOfChildren + ") should be positive");
            result = false;
        }

        return result;
    }
    public static boolean receiveJumpStepParam() throws IOException {
        boolean result = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the jump step (positive number): ");
        try {
            jumStep = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
            result = false;
        }

        if (jumStep < 0) {
            System.err.println("Jump step (" + jumStep + ") should be positive");
            result = false;
        }

        return result;
    }
}
