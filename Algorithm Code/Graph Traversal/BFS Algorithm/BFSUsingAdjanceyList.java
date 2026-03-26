

import java.util.*;

public class BFSUsingAdjanceyList {
   
    public static void addEdges(ArrayList<ArrayList<Integer>> adjList,int i,int j)
    {
        adjList.get(i).add(j);
        //adjList.get(j).add(i);
    }

    
        public static void displayList(ArrayList<ArrayList<Integer>> adj)
    {
        for(int i=0;i<adj.size();i++)
        {
            System.out.println("\n vertex "+i);
            System.out.printf("Path frome %d to ",i);
            
            for(int j=0;j<adj.get(i).size();j++)
            {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.printf("\n");
        }
    }
        
        
        public static void bfs(ArrayList<ArrayList<Integer>> adjList,int vertex,int s,int visitor[])
        {
            int queue[] = new int[vertex];
            int front = 0, rear = 0;

            queue[rear++] = s;
            visitor[s] = 1;

            while (front != rear) {

                int curr = queue[front++];  /// dequeue

                System.out.print(curr + " ");

                for (int j = 0; j < adjList.get(curr).size(); j++) {
                    int adjNode = adjList.get(curr).get(j);
                    if (visitor[adjNode] != 1) {
                        visitor[adjNode] = 1;
                        queue[rear] = adjNode;
                        rear++;
                    }

                }

            }  
        }
    
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<ArrayList<Integer>>();
       
        System.out.printf("Enter the total vertex: ");
        int vertex=input.nextInt();

  
        for(int i=0; i<vertex; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < vertex; i++) {
            
            System.out.printf("list no. %d for total limit:", i);
            int limit = input.nextInt();

            for (int j = 0; j < limit; j++) 
            {
                System.out.printf("next path: ");
                int value = input.nextInt();

                addEdges(adjList, i, value);
            }
        }
        
        System.out.printf("\n");
       
        int start;
        int visitor[]=new int[vertex];
        System.out.printf("Start node: ");
        start = input.nextInt();
        bfs(adjList,vertex,start,visitor);

        
    }
}
