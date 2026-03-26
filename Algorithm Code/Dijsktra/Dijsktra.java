import java.io.*;
import java.util.*;

public class Dijsktra {

    static int v;
    static boolean visitor[];
    static int prev[];
    static int distance[];

    /// Prims Function
    public static void dijsktra(int graph[][],int source) {
        visitor = new boolean[v];
        prev = new int[v];
        distance = new int[v];

        for (int i = 0; i < v; i++) {
            visitor[i] = false;
            prev[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        prev[source] = -1;

        for (int i = 0; i < v - 1; i++) {

            int u = extractMin(distance);

            visitor[u] = true;

            for (int j = 0; j < graph.length; j++) {
                if (graph[u][j] != 0 && visitor[j] == false && distance[u]!=Integer.MAX_VALUE && distance[u]+graph[u][j]<distance[j]) {
                    prev[j] = u;
                    distance[j]=distance[u]+graph[u][j];
                }
            }

        }

        print(distance,source);
    }

    /// Extract Minimum Weight
    public static int extractMin(int dis[]) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int i = 0; i < v; i++) {

            if (visitor[i] == false && dis[i] < min) {
                min = dis[i];
                min_index = i;
            }
        }

        return min_index;
    }

    /// Print Mst Tree Sequence by prims
    public static void print(int dis[],int source) {
        System.out.println();

        System.out.println("Vertex - Distance from source");
        for (int i = 0; i < v; i++) {
            System.out.println(i + " - " + dis[i]);

        }

        //cheack out
        //System.out.println("vaertex 2 parent :"+prev[2]);

        for (int i = 0; i < v; i++) {
           
            System.out.println();
            System.out.print("Path for "+source+" to "+i+" : ");
            path(source,i);

        }
    }


    //path method
    public static void path(int s,int d)
    {
        
        if(s==d)
        {
           System.out.print(d+" ");
           return;
        }
        else
        {
            path(s, prev[d]);
            System.out.print(d+" ");

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

            int source =in.nextInt();

            in.close();

            dijsktra(graph,source);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
