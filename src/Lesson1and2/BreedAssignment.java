package Lesson1and2;

import java.util.*;
import java.io.*;

public class BreedAssignment {

    static int counter = 0;

    static void dfs(int[][] restrictions, int index, int[] assignment) {

        HashSet<Integer> breeds = new HashSet<>();
        breeds.add(0);
        breeds.add(1);
        breeds.add(2);

        for (int i = 1; i < index; i++) {
            if (restrictions[i][index] == 2) {
                breeds.remove(assignment[i]);
            } else if (restrictions[i][index] == 1){
                HashSet<Integer> temp = new HashSet<>();
                temp.add(assignment[i]);
                breeds.retainAll(temp);
            }
        }
        if (index == assignment.length - 1) counter += breeds.size();
        else for (int i : breeds) {
            assignment[index] = i;
            dfs(restrictions, index + 1, assignment);
        }

    }

    public static void main (String[] args) throws FileNotFoundException {

        String filename = "assign";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int nofcows = sc.nextInt();
        int nofrestrictions = sc.nextInt();
        int[][] restrictions = new int[nofcows+1][nofcows+1];

        sc.nextLine();

        for (int i = 0; i < nofrestrictions; i++) {
            String line = sc.nextLine();
            if (line.charAt(0) == 'S') restrictions[Character.getNumericValue(line.charAt(2))][Character.getNumericValue(line.charAt(4))] = restrictions[Character.getNumericValue(line.charAt(4))][Character.getNumericValue(line.charAt(2))] = 1;
            else restrictions[Character.getNumericValue(line.charAt(2))][Character.getNumericValue(line.charAt(4))] = restrictions[Character.getNumericValue(line.charAt(4))][Character.getNumericValue(line.charAt(2))] = 2;
        }

        int[] assignment = new int[nofcows + 1];
        assignment[1] = 1;

        dfs(restrictions, 2, assignment);


        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(counter*3);
        writer.close();

    }

}
