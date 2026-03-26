import java.io.*;
import java.util.*;

public class PrimsAlgo {

    static int v;
    static boolean visitor[];
    static int prev[];
    static int key[];

    /// Prims Function
    public static void prims(int graph[][]) {
        visitor = new boolean[v];
        prev = new int[v];
        key = new int[v];

        for (int i = 0; i < v; i++) {
            visitor[i] = false;
            prev[i] = -1;
            key[i] = Integer.MAX_VALUE;
        }

        key[0] = 0;
        prev[0] = -1;

        for (int i = 0; i < v - 1; i++) {

            int u = extractMin(key);

            visitor[u] = true;

            for (int j = 0; j < graph.length; j++) {
                if (graph[u][j] != 0 && visitor[j] == false && graph[u][j] < key[j]) {
                    prev[j] = u;
                    key[j] = graph[u][j];
                }
            }

        }

        print(graph);
    }

    /// Extract Minimum Weight
    public static int extractMin(int key[]) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int i = 0; i < v; i++) {

            if (visitor[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
        }

        return min_index;
    }

    /// Print Mst Tree Sequence by prims
    public static void print(int graph[][]) {
        System.out.println();

        System.out.println("Edge\tWeight");
        for (int i = 1; i < v; i++) {
            System.out.println(prev[i] + " - " + i + "\t" + graph[i][prev[i]]);

        }
    }

    /// Main Method Take input from File
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
                int w = in.nextInt();

                graph[p][s] = w;
                graph[s][p] = w;
            }
            in.close();

            prims(graph);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
