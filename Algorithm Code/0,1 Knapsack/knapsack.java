import java.io.*;
import java.util.*;

public class knapsack {

    static int W;
    static int item;
    static int table[][];

    public static void knapscakF(ArrayList<ArrayList<Integer>> list) {
        int array[][] = new int[item + 1][W + 1];
        int dummy[][] = new int[item + 1][W + 1];

        
        for (int i = 0; i <= W; i++) {
            array[0][i] = 0;
        }
        for (int i = 0; i <= item; i++) {
            array[i][0] = 0;
        }

       
        for (int i = 1; i <= item; i++) 
        {
            for (int j = 1; j <= W; j++) 
            {
                int a = 0;
                if (j >= list.get(i - 1).get(1)) 
                { 
                    a = list.get(i - 1).get(2) + array[i - 1][j - list.get(i - 1).get(1)];
                }
                int b = array[i - 1][j]; 

               
                if (a > b) {
                    dummy[i][j] = 1;
                    array[i][j] = a;
                } else {
                    dummy[i][j] = 0;
                    array[i][j] = b;
                }
            }
        }

  
        for (int i = 0; i <= item; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.print("Total value: "+array[item][W]);
        System.out.println();
        System.out.print("Item Select: ");
        
        traceback(dummy,array,item,W,list);

        System.out.println();
    }



    public static void traceback(int dummy[][],int[][] array,int n,int m,ArrayList<ArrayList<Integer>>list)
    {
        if(n==0 || m==0)
        {
            return;
        }
        else
        {
            if(array[n][m]!=array[n-1][m] && dummy[n][m]==1)
            {
                int sub=array[n][m]-list.get(n-1).get(2);
                int s=0,d=0;
                for (int i = 0; i <= W; i++) {
                   if(sub==array[n-1][i])
                   {
                    s=n-1;
                    d=i;
                   }
                }

                traceback(dummy,array,s,d,list);
                System.out.print(n+" ");
            }
            else
            {
                traceback(dummy, array, n-1, m, list);
            }
        }

    }



    public static void main(String[] args) {
        File file = new File("input.txt");

        try {
            Scanner in = new Scanner(file);

            W = in.nextInt();
            item = in.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for (int i = 0; i < item; i++) {
                int first = in.nextInt();
                int seco = in.nextInt();
                int third = in.nextInt();

                ArrayList<Integer> value = new ArrayList<>();
                value.add(first); 
                value.add(seco);  
                value.add(third); 
                list.add(value);
            }

            in.close();
            knapscakF(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
