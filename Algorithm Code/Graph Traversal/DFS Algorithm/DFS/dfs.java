import java.io.*;
import java.util.*;

public class dfs {

    static int v;
    static String color[];
    static int prev[];
    static int d[];
    static int f[];
    static int time = 0;

    public static void dfss(int graph[][]) {
        // Initialize the arrays based on the value of v
        color = new String[v];
        prev = new int[v];
        d = new int[v];
        f = new int[v];

        for (int i = 0; i < v; i++) {
            color[i] = "w";
            prev[i] = -1;
            d[i] = 0;
            f[i] = 0;
        }

        System.out.print("DFS-> ");
        for (int i = 0; i < v; i++) {
            if (color[i].equals("w")) {
                dfs_visit(graph, i);
            }
        }

        print();
    }

    public static void dfs_visit(int graph[][], int s) {
        color[s] = "g";
        time = time + 1;
        d[s] = time;

        System.out.print(" " + s);

        for (int i = 0; i < v; i++) {
            if (color[i].equals("w") && graph[s][i] == 1) {
                prev[i] = s;
                dfs_visit(graph, i);
            }
        }
        color[s] = "b";
        time = time + 1;
        f[s] = time;
    }

    public static void print() {
        System.out.println();
        System.out.print("DIS-> ");
        for (int i = 0; i < v; i++) {
            System.out.print(" " + d[i]);
        }
        System.out.println();
        System.out.print("FIN-> ");
        for (int i = 0; i < v; i++) {
            System.out.print(" " + f[i]);
        }
        System.out.println();
        System.out.print("COL-> ");
        for (int i = 0; i < v; i++) {
            System.out.print(" " + color[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        File f = new File("input.txt");

        try {
            Scanner in = new Scanner(f);

            v = in.nextInt();
            int e = in.nextInt();

            int graph[][] = new int[v][v];

            for (int i = 0; i < e; i++) {
                int p = in.nextInt();
                int s = in.nextInt();

                graph[p][s] = 1;
                graph[s][p] = 1;
            }
            in.close();

            dfss(graph);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
