import java.io.*;
import java.util.*;

public class PathFindingUsingDFS{

    static int v;
    static String color[];
    static int prev[];
    static int d[];
    static int f[];
    static int time = 0;
    static int source;
    static int destination;

    public static void dfss(int graph[][]) {

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

        // System.out.print("DFS-> ");
        for (int i = 0; i < v; i++) {
            if (color[i].equals("w")) {
                dfs_visit(graph, i);
            }
        }

        pathFind(source, destination);
    }

    public static void dfs_visit(int graph[][], int s) {
        color[s] = "g";
        time = time + 1;
        d[s] = time;

        // System.out.print(" " + s);

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

    /// Path Finding using DFS
    public static void pathFind(int s, int d) {
        if (s == d) {
            System.out.print(" " + d);
            return;
        } else {
            pathFind(s, prev[d]);
            System.out.print(" " + d);
        }
    }

    /// Main Method
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

            source = in.nextInt();
            destination = in.nextInt();

            in.close();

            dfss(graph);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
