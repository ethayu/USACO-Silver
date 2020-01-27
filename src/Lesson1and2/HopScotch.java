package Lesson1and2;

import java.util.*;
import java.io.*;

public class HopScotch {

    static int counter = 0;
    static int[][] area;

    static void dfs(int x, int y) {
        if ((x == area.length - 1) && (y == area[x].length - 1)) {
            counter++;
            return;
        }
        else if (!((x == area.length) || (y == area[x].length))) {
            for (int i = x + 1; i < area.length; i++) {
                for (int j = y + 1; j < area[i].length; j++) {
                    if (area[x][y] != area[i][j]) {
                        dfs(i, j);
                    }
                }
            }
        }
    }

    public static void main (String[] args) throws FileNotFoundException {

        String filename = "hopscotch";
        Scanner sc = new Scanner(new File(filename + ".in"));

        area = new int[sc.nextInt()][sc.nextInt()];
        sc.nextLine();
        for (int i = 0; i < area.length; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < area[i].length; j++) {
                area[i][j] = (int)line.charAt(j);
            }
        }

        dfs(0, 0);

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(counter % 1000000007);
        writer.close();

    }

}
