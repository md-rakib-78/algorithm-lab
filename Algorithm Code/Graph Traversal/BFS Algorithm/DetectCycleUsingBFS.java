

import java.util.*;

public class DetectCycleUsingBFS {

    public static void addEdges(ArrayList<ArrayList<Integer>> adjList, int i, int j) {
        adjList.get(i).add(j);
    }

    public static void bfso(ArrayList<ArrayList<Integer>> adjList, int start, int vertex) {
        int queue[] = new int[vertex];
        int front = 0;
        int rear = 0;
        int visitor[] = new int[vertex];
        
        queue[rear++] = start;
        visitor[start] = 1;

        while (front != rear) {
            int current = queue[front++];
            System.out.print(current + " ");

            for (int i = 0; i < adjList.get(current).size(); i++) {

                if (visitor[adjList.get(current).get(i)] != 1) {
                    queue[rear++] = adjList.get(current).get(i);
                    visitor[adjList.get(current).get(i)] = 1;
                }
            }

        }
        rear--;
        System.out.println("\n");
        System.out.println(queue[rear]+" ");
        
        int count=0;
        
for(int i=0;i<adjList.get(queue[rear]).size();i++)
{
    for(int j=0;j<adjList.get(start).size();j++)
    {
    if(adjList.get(queue[rear]).get(i) == adjList.get(start).get(j))
    {
       count++;
    }
    }
}

if(count >=2)
{
    System.out.println("Graph have cycle!!");
}
else
{
    System.out.println("Graph has not cycle!!");
}
        
        

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random val = new Random();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        System.out.print("Enter The total Vertex: ");
        int vertex = input.nextInt();

        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        int value;
        int list;

        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex " + i + " list size: ");
            value = input.nextInt();
            for (int j = 0; j < value; j++) {
                System.out.print("vertex " + i + " connected : ");
                list = input.nextInt();
                addEdges(adjList, i, list);
            }
        }

        int start;

        System.out.println("\n");
        System.out.print("starting point: ");
        start = val.nextInt(vertex-1);
        
        System.out.println(start);

        bfso(adjList, 0, vertex);

    }
}
