import java.util.Scanner;
import java.io.*;

public class TopologicalSort {

    private static node head = null;
    public static int size = 0;

    class node {
        int data;
        node link;

        node(int data) {
            this.data = data;
            this.link = null;
            size++;
        }
    }

    // Add node begining
    public void addBeg(int value) {
        node newnode = new node(value);
        if (head == null) {
            head = newnode;
            return;
        } else {

            newnode.link = head;
            head = newnode;
        }
    }

    // Print Linked List
    public static void prints() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        } else {
            if(cycleDetect==true)
            {
                System.out.println("Topological Sort Not possible becuase this graph have cycle");
            }
            else
            {
                while (head != null) {
                    System.out.print(head.data + " ");
                    head = head.link;
            }
            }
        }
    }

    // Using DFS

    public static int time = 0;
    public static String color[] = new String[5];
    public static int parent[] = new int[5];
    public static int finishTime[] = new int[5];
    public static int discoverTime[] = new int[5];
    public static int array[][] = new int[5][5];
    public static boolean cycleDetect = false;

    public static void DFS() {
        for (int i = 0; i < array.length; i++) {
            color[i] = "w";
            finishTime[i] = 0;
            discoverTime[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            if (color[i] == "w") {
                parent[i] = -1;
                travarse(i);
            }
        }

    }

    // 
    public static void travarse(int s) {

        App list = new App();

        time++;
        discoverTime[s] = time;
        color[s] = "g";

        System.err.print(s + " ");

        for (int i = 0; i < array.length; i++) {

            if (array[s][i] == 1 && color[i] == "w") {
                parent[i] = s;
                color[i] = "g";
                discoverTime[i] = discoverTime[s] + 1;
                travarse(i);
            } else if (array[s][i] == 1 && parent[s] != i && color[i] == "g") {
                cycleDetect = true;
            }
        }
        time = time + 1;
        finishTime[s] = time;
        color[s] = "b";

        list.addBeg(s);
        

    }

    public static void main(String[] args) throws Exception {

        // File Create
        File file = new File("input.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // File Read
        try {
            Scanner in = new Scanner(file);
            while (in.hasNext()) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        int num = Integer.parseInt(in.next());
                        array[i][j] = num;
                    }
                }

            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                System.out.print(array[i][j] + " ");
            }
            System.err.println();
        }

        System.err.println();
        System.out.print("DFS-> ");

        DFS();

        System.out.println();
        System.out.println();

        System.out.print("Parent Node: ");
        for (int p : parent) {
            System.out.print(" " + p);
        }
        System.out.println();
        System.out.print("Color ");
        for (String c : color) {
            System.out.print(" " + c);
        }
        System.out.println();

        System.out.print("Discover Time:  ");
        for (int d : discoverTime) {
            System.out.print(" " + d);
        }
        System.out.println();

        System.out.print("Finishing Time:  ");
        for (int f : finishTime) {
            System.out.print(" " + f);
        }
        System.out.println();

        if (cycleDetect == true) {
            System.out.println("Cycle found! ");
        } else {
            System.out.println("Cycle not found!");
        }

        System.out.println();
        System.out.println();

        prints();
    }
}
