//package Lesson3and4;

import java.io.*;
import java.util.*;

public class CowArt {

    static int red = 0;
    static int green = 0;
    static int blue = 0;
    static int redgreen = 0;

    static boolean isinBounds(int limit, int x, int y) {
        if ((x >= 0) && (x < limit)) {
            if ((y >= 0) && (y < limit)) {
                return true;
            }
        }
        return false;
    }

    static void humancheck(Stack<int[]> matches, char[][] painting) {
        while (!matches.isEmpty()) {
            int x = matches.peek()[0];
            int y = matches.peek()[1];
            char compare = painting[x][y];
            if (compare == 'B') painting[x][y] = '.';
            else painting[x][y] = '@';
            if (compare == '@') painting[x][y] = '.';
            matches.pop();
            for (int i = 0; i < 4; i++) {
                int newx = x + r[i];
                int newy = y + c[i];
                if (isinBounds(painting.length, newx, newy)) {
                    if (painting[newx][newy] == compare) {
                        matches.add(new int[]{newx, newy});
                        humancheck(matches, painting);
                    }
                }
            }
        }
    }

    static int[] r = {-1, 0, 0, 1};
    static int[] c = {0, -1, 1, 0};

    public static void main(String[] args) throws FileNotFoundException {

        String filename = "cowart";

        Scanner sc = new Scanner(new File(filename + ".in"));
        int n = sc.nextInt();

        Stack<int[]> matches = new Stack<>();

        char[][] painting = new char[n][n];

        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < n; j++) {
                painting[i][j] = temp.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((painting[i][j] != '.') && (painting[i][j] != '@')) {
                    if (painting[i][j] == 'B') blue++;
                    else if (painting[i][j] == 'G') green++;
                    else if (painting[i][j] == 'R') red++;
                    matches.add(new int[]{i, j});
                    humancheck(matches, painting);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (painting[i][j] == '@') {
                    redgreen++;
                    matches.add(new int[]{i, j});
                    humancheck(matches, painting);
                }
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));

        writer.println(red + green + blue + " " + (int)(blue + redgreen));
        writer.close();

    }

}