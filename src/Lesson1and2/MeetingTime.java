package Lesson1and2;

import java.util.*;
import java.io.*;

public class MeetingTime {

    static HashSet<Integer> bessie = new HashSet<>();
    static HashSet<Integer> elsie = new HashSet<>();

    static void bdfs(int target, int[][] paths, int field, int time) {
        if (field == target) {
            bessie.add(time);
        } else {
            for (int i = 1; i < paths.length; i++) {
                if (paths[i][0] == field) {
                    bdfs(target, paths, paths[i][1], time + paths[i][2]);
                }
            }
        }
    }

    static void edfs(int target, int[][] paths, int field, int time) {
        if (field == target) elsie.add(time);
        for (int i = 1; i < paths.length; i++) {
            if (paths[i][0] == field) {
                edfs(target, paths, paths[i][1], time + paths[i][3]);
            }
        }
    }

    public static void main (String[] args) throws FileNotFoundException {

        String filename = "meeting";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int target = sc.nextInt();
        int[][] paths = new int[sc.nextInt() + 1][4];

        for (int i = 1; i < paths.length; i++) {
            for (int j = 0; j < 4; j++) {
                paths[i][j] = sc.nextInt();
            }
        }

        bdfs(target, paths, 1, 0);
        edfs(target, paths, 1, 0);

        int min = Integer.MAX_VALUE;

        for (int i : elsie) {
            for (int j : bessie) {
                if (i == j * 2) {
                    if (min > i) min = i;
                }
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        if (min == Integer.MAX_VALUE) writer.println("IMPOSSIBLE");
        else writer.println(min);
        writer.close();

    }

}
