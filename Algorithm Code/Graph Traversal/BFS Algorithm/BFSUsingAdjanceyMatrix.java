
package com.mycompany.bfs;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the no. of vertex: ");
        int vertex=input.nextInt();
        int adjMatrix[][] = new int [vertex][vertex];
        System.out.print("Number of edge: ");
        int edge = input.nextInt();
        
        // Adding edge
        int row,col;
        for(int i=0;i<edge;i++)
        {
            
            System.out.printf("Row : ");
            row = input.nextInt();
            System.out.printf("col : ");
            col = input.nextInt();

            while (true) {
                if (adjMatrix[row][col] == 1 && adjMatrix[col][row] == 1) {
                    System.out.printf("Row : ");
                    row = input.nextInt();
                    System.out.printf("col : ");
                    col = input.nextInt();
                } else {
                    break;
                }
            }

            adjMatrix[row][col]=1;
            adjMatrix[col][row]=1;
        }
        
        System.out.println();
        System.out.printf("Please enter the starting point: ");
        int startPoint = input.nextInt();
    
        bfs(adjMatrix,startPoint,vertex,edge);
        
    }
    
    
    public static void bfs(int adjMatrix[][],int startPoint,int vertex,int edge)
    {
        int queue[] = new int [vertex];
        int front = 0;
        int rear = 0; 
        int visitor[] = new int[vertex];
        int current;
        
        queue[rear++]=startPoint;
        visitor[startPoint]=1;
        
        while (front != rear) {
            current = queue[front++];
            System.out.print(current + " ");

            for (int i = 0; i < vertex; i++) {
                if (adjMatrix[current][i] == 1 && visitor[i] == 0) {
                    queue[rear++] = i;

                    visitor[i] = 1;

                }
            }
        }

    }

}
