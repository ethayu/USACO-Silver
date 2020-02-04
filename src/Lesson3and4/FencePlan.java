package Lesson3and4;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class FencePlan {

    static int min = Integer.MAX_VALUE;
    static int maxx = Integer.MIN_VALUE;
    static int maxy = Integer.MIN_VALUE;
    static int minx = Integer.MAX_VALUE;
    static int miny = Integer.MAX_VALUE;

    static void dfs(int y, int[][] coords, int[] visited,
                    ArrayList<int[]> relationships, int[] currentrelationship) {
        visited[y] = 1;
        maxx = Math.max(coords[y][0], maxx);
        maxy = Math.max(coords[y][1], maxy);
        minx = Math.min(coords[y][0], minx);
        miny = Math.min(coords[y][1], miny);
        for (int i = 0; i < relationships.size(); i++) {
            if (relationships.get(i)[0] == y) {
                if (visited[relationships.get(i)[1]] == 0) {
                    dfs(relationships.get(i)[1], coords, visited, relationships, relationships.get(i));
                }
            }
        }
    }

    public static void main (String[] args) throws FileNotFoundException {

        String filename = "fenceplan";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] coords = new int[n][2];

        for (int i = 0; i < n; i++) {
            coords[i   ][0] = sc.nextInt();
            coords[i][1] = sc.nextInt();
        }

        ArrayList<int[]> relationships = new ArrayList<>();

        for (int i = 0; i < m; i++) {
        }

        int[] visited = new int[n];


        for (int[] i : relationships) {
            if (visited[i[0]] == 1) continue;
            maxx = Math.max(coords[i[0]][0], maxx);
            maxy = Math.max(coords[i[0]][1], maxy);
            minx = Math.min(coords[i[0]][0], minx);
            miny = Math.min(coords[i[0]][1], miny);
            visited[i[0]] = 1;
            dfs(i[1], coords, visited, relationships, i);
            min = Integer.min(min, 2 * (maxx - minx + maxy - miny));
            maxx = Integer.MIN_VALUE;
            maxy = Integer.MIN_VALUE;
            minx = Integer.MAX_VALUE;
            miny = Integer.MAX_VALUE;
        }
        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(min);
        writer.close();

    }

}
