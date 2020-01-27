package Lesson3and4;

import java.util.Scanner;

public class FloodfillPractice1 {

    static int[][] area;

    static int counter;

    //static int[] cx = {1, 1, 0, -1, -1, -1, 0, 1};
    //static int[] cy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] cx = {1, 0, -1, 0};
    static int[] cy = {0, 1, 0, -1};

    static void dfs(int x, int y, int color, int previous) {
        for (int i = 0; i < 4; i++) {
            int q = x + cx[i];
            int r = y + cy[i];
            if ((q < 0) || (q >= area.length)) continue;
            if ((r < 0) || (r >= area[0].length)) continue;
            if (area[q][r] == previous) {
                area[q][r] = color;
                dfs(q, r, color, previous);
            }
        }
    }

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        area = new int[sc.nextInt()][sc.nextInt()];
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                area[i][j] = sc.nextInt();
            }
        }
        int[] change = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (area[i][j] == change[2]) continue;
                int region = area[i][j];
                area[i][j] = change[2];
                dfs(i, j, change[2], region);
                counter++;
            }
        }
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(counter);
    }

}
