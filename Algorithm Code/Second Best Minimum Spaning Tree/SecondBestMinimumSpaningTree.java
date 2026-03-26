import java.io.*;
import java.util.*;

public class SecondBestMinimumSpaningTree {

    static int ver;
    static int e;
    static int leader[];
    static int rank[];

    public static void makeSet() {
        for (int i = 0; i < ver; i++) {
            leader[i] = i;
            rank[i] = 0;
        }
    }


    public static int findset(int leader[], int node) {
        if (leader[node] == node) {
            return node;
        }
        return leader[node] = findset(leader, leader[node]); 
    }


    public static void unionset(int u, int v) {
       u = findset(leader, u);
       v = findset(leader, v);

        if (rank[u] < rank[v]) {
            leader[u] = v;
        } else if (rank[u] > rank[v]) {
            leader[v] = u;
        } else {
            leader[v] = u;
            rank[u]++;
        }
    }

    public static int calculateMST(ArrayList<ArrayList<Integer>> edges, ArrayList<ArrayList<Integer>> mstEdges) {

        makeSet();
        int mstWeight = 0;

        for (ArrayList<Integer> edge : edges) {
            int u = findset(leader, edge.get(0));
            int v = findset(leader, edge.get(1));
            int w = edge.get(2);

            if (u != v) {
                mstWeight += w;
                unionset(u, v);
                mstEdges.add(edge); 
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        File fi = new File("input.txt");
        try {
            Scanner inp = new Scanner(fi);

            ver = inp.nextInt();
            e = inp.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                int f = inp.nextInt();
                int s = inp.nextInt();
                int w = inp.nextInt();

                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(f);
                edge.add(s);
                edge.add(w);

                list.add(edge);
            }

            list.sort(Comparator.comparingInt(innerList -> innerList.get(2)));

            leader = new int[ver];
            rank = new int[ver];

            ArrayList<ArrayList<Integer>> firstmst = new ArrayList<>();

            int minWeight = calculateMST(list, firstmst);

            System.out.println("Edges in Mst And Weight: ");
            for (ArrayList<Integer> edge : firstmst) {
                System.out.println(edge.get(0) + " - " + edge.get(1) + "  -  " + edge.get(2));
            }
            System.out.println("Mst Total Weight: " + minWeight);


            System.out.println();


            int secondBestMST = Integer.MAX_VALUE;
            ArrayList<ArrayList<Integer>> secondBestEdges = new ArrayList<>();

            for (ArrayList<Integer> removedEdge : firstmst) {
                ArrayList<ArrayList<Integer>> tempEdges = new ArrayList<>(list);

                tempEdges.remove(removedEdge);

                makeSet();
                ArrayList<ArrayList<Integer>> tempMstEdges = new ArrayList<>();
                int tempWeight = calculateMST(tempEdges, tempMstEdges);

                
                if (tempMstEdges.size() == ver - 1 && tempWeight < secondBestMST) {
                    secondBestMST = tempWeight;
                    secondBestEdges = new ArrayList<>(tempMstEdges);
                }
            }

           
            System.out.println("Edges in Second Best MST and weight:");
            for (ArrayList<Integer> edge : secondBestEdges) {
                System.out.println(edge.get(0) + " - " + edge.get(1) + "  -  " + edge.get(2));
            }

            System.out.println("Second Best MST Total Weight: " + secondBestMST);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
