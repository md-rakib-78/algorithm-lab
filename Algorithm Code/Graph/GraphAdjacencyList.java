
package com.mycompany.graphadjacencylist;

import java.util.ArrayList;

public class GraphAdjacencyList {
    
    public static void addEdges(ArrayList<ArrayList<Integer>> adjList,int i,int j)
    {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
  
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
    

    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<5;i++)
        {
            // create 5 empty index;
            adjList.add(new ArrayList<Integer>());           
        }
        
        // 0->1->2->3
        addEdges(adjList,0,1);
        addEdges(adjList,0,2);
        addEdges(adjList,0,3);
        
        //1->0->4
        addEdges(adjList,1,4);
        
        //2->0->3
        addEdges(adjList,2,3);
        
        //3->0->2->4
        addEdges(adjList,3,4);
        
        //4->1->3
        
        // For Display graph list
        
        displayList(adjList);

        
    }
}
