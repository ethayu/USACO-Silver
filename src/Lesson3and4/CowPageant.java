package Lesson3and4;

import java.util.*;
import java.io.*;

public class CowPageant {

    static int[][] cow;

    public static void main (String[] args) throws FileNotFoundException {

        String filename = "pageant";
        Scanner sc = new Scanner(new File(filename + ".in"));

        cow = new int[sc.nextInt()][sc.nextInt()];
        sc.nextLine();
        for (int i = 0; i < cow.length; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < cow[i].length; j++) {
                if (line.charAt(j) == 'X') {

                }
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.close();

    }

}
