import java.io.*;
import java.util.*;

public class BFSUsingLinkedList {

    public static boolean cycleDetect = false;

    public static void addEdge(LinkedList<LinkedList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
    }

    public static void Bfs(LinkedList<LinkedList<Integer>> adj, int s) {

        int queue[] = new int[adj.size()];
        int front = 0, rear = 0;
        String color[] = new String[adj.size()];
        int level[] = new int[adj.size()];
        int Parent[] = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            color[i] = "w";
            level[i] = -1;
            Parent[i] = -1;
        }

        color[s] = "g";
        level[s] = 0;
        queue[rear++] = s;

        int bfs[] = new int[adj.size()];
        int i = 0;
        while (front < rear) {
            int curr = queue[front++];
            bfs[i++] = curr;

            for (int j = 0; j < adj.get(curr).size(); j++) {
                int node = adj.get(curr).get(j);
                if (color[node] == "w") {
                    level[node] = level[curr] + 1;
                    Parent[node] = curr;
                    color[node] = "g";
                    queue[rear++] = node;
                } else if (color[node] == "g" && Parent[curr] != node) {
                    cycleDetect = true;
                }
            }
            color[curr] = "b";
        }

        // Output File Create
        File files = new File("Output.txt");
        try {
            files.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Write Output File
        try {

            Formatter form = new Formatter(files);

            form.format("%s", "BFS-> ");
            for (int j = 0; j < bfs.length; j++) {
                form.format(" %d ", bfs[j]);
            }
            form.format("\n", "");

            if (cycleDetect == true) {
                form.format(" %s ", "Cycle Found!");
            } else {
                form.format(" %s ", "Cycle Not Found!");
            }
            form.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // New File create
        File file = new File("inputFile.txt");
        try {
            file.createNewFile();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Read List Size
        int size = 0;

        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                in.nextLine();
                size++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();

        for (int i = 0; i < size; i++) {
            list.add(new LinkedList<>());
        }

        // File Read
        try {
            Scanner in = new Scanner(file);
            int i = 0;

            while (in.hasNextLine()) {

                String line = in.nextLine();
                Scanner lineScanner = new Scanner(line);

                while (lineScanner.hasNextInt()) {
                    int value = lineScanner.nextInt();

                    addEdge(list, i, value);
                }

                lineScanner.close();
                i++;
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int start = 1;
        Bfs(list, start);
    }
}
