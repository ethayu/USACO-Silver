import java.util.*;
import java.io.*;

public class template {

    public static void main (String[] args) throws FileNotFoundException {

        String filename = "filename";
        Scanner sc = new Scanner(new File(filename + ".in"));

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.close();

    }

}
