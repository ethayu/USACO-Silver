//ackage Lesson5and6;

import java.util.*;
import java.io.*;

public class PiggyBack {

    static int b, e, p, n, m;
    static ArrayList<Integer>[] relationships;

    static int bfs (int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        int[] counter = new int[n];
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (current == y) {
                return counter[current];
            }
            for (int field : relationships[current]) {
                if ((counter[field] != 0) || (field == x)) continue;
                queue.add(field);
                counter[field] = counter[current] + 1;
            }
        }
        return  - 1;
    }

    public static void main (String[] args) throws FileNotFoundException {

        String filename = "piggyback";
        Scanner sc = new Scanner(new File(filename + ".in"));
        PrintWriter writer = new PrintWriter(new File(filename + ".out"));

        b = sc.nextInt();
        e = sc.nextInt();
        p = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();

        relationships = new ArrayList[m];
        for (int i = 0; i < relationships.length; i++) {
            relationships[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            relationships[a].add(b);
            relationships[b].add(a);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            int bl, el, cl;
            bl = bfs(0, i);
            el = bfs(1, i);
            cl = bfs(i, 7);
            if (min > (bl*b + el*e + cl*p)) min = bl*b + el*e + cl*p;
        }

        writer.println(min);
        writer.close();

    }

}
