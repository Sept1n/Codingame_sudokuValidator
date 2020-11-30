import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[][] table = new int[9][9];
        ArrayList<Integer> check = new ArrayList<>();
        ArrayList<Integer> correctRowColumnOrSquare = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            correctRowColumnOrSquare.add(i);
        }
        int tripleColumn = 0;
        int tripleRow = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = in.nextInt();
                check.add(table[i][j]);
            }
            Collections.sort(check);
            if(!check.equals(correctRowColumnOrSquare)) {
                System.out.println("false");
                System.exit(1);
            }
            check.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                check.add(table[j][i]);
            }
            Collections.sort(check);
            if(!check.equals(correctRowColumnOrSquare)) {
                System.out.println("false");
                System.exit(1);
            }
            check.clear();
        }
        int count = 0;
        while(count < 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i/3==tripleColumn && j/3==tripleRow) {
                        check.add(table[i][j]);
                    }
                }
            }
            Collections.sort(check);
            if(!check.equals(correctRowColumnOrSquare)) {
                System.out.println("false");
                System.exit(1);
            }
            check.clear();
            tripleRow++;
            if(tripleRow == 3) {
                tripleRow = 0;
                tripleColumn++;
            }
            count++;
        }
        System.out.println("true");

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("true or false");
    }
}