import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalAlgo {

    static int v;
    static int e;

    /// Disjoint element
    public static void makeSet(int parent[],int rank[])
    {
        for (int i = 0; i < v; i++) {
            parent[i] = i;
            rank[i]=0;
        }
    }

    /// Find set
    public static int findSet(int parent[],int node)
    {
           if(parent[node] == node)
           {
            return node;
           }
           return findSet(parent, parent[node]);
    }


    /// Union
    
    public static void unionSet(int u,int v,int parent[],int rank[])
    {
          // u = findSet(parent, u);
          // v = findSet(parent, v);

           if(rank[u]<rank[v])
           {
              parent[u] = v;
           }
           else if(rank[u]>rank[v])
           {
               parent[v] = u;
           }
           else
           {
              parent[v] = u;
              rank[u]++;
           }
    }
    

    public static void main(String[] args) {

        // Create a new File
        File file = new File("input.txt");

        try {
       
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /// End Create New File

        // Read data From file
        try {
            Scanner in = new Scanner(file);

            v = in.nextInt();
            e = in.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();


            for (int i = 0; i < e; i++) {
                int f = in.nextInt(); 
                int s = in.nextInt();
                int w = in.nextInt(); 

                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(f);
                edge.add(s);
                edge.add(w);

                list.add(edge);
            }

            list.sort(Comparator.comparingInt(innerList -> innerList.get(2)));

            int parent[] = new int[v];
            int rank[] = new int[v];

            makeSet(parent, rank);

            int minWeight = 0;

            System.out.println("Edge\tweght");
            for (int i = 0; i < e; i++) {
                int u = findSet(parent, list.get(i).get(0));
                int v = findSet(parent, list.get(i).get(1));
                int w = list.get(i).get(2);

                if(u != v)
                {
                    minWeight+=w;
                    unionSet(u, v, parent, rank);
                    System.out.println(u+"   "+v+"  -  "+w);
                }
            }


            System.out.println();

               System.out.println("Total Weight: "+minWeight);

            System.out.println();
            System.out.print("Leader: ");

            for (int i : parent) {
                System.out.print(" "+i);
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// end read file


}
