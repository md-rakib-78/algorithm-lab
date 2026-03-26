import java.util.*;
import java.io.*;

public class lcs {

    static char[]x;
    static char[]y;


    public static void lcss()
    {
           int array[][]=new int[x.length+1][y.length+1];
           int dummy[][]=new int[x.length+1][y.length+1];

           for (int i = 0; i <= x.length; i++) {
            array[i][0] = 0;
        }
        for (int j = 0; j <= y.length; j++) {
            array[0][j] = 0;
        }



           for (int i = 1; i <= x.length; i++) {
            for (int j = 1; j <= y.length; j++) {
                if(x[i-1]==y[j-1])
                {
                   array[i][j]=array[i-1][j-1]+1;

                   dummy[i][j]=1;
                }
                else if(array[i][j-1]>array[i-1][j])
                {
                   array[i][j]=array[i][j-1];

                   dummy[i][j]=2;
                }
                else
                {
                    array[i][j]=array[i-1][j];
                    dummy[i][j]=3;
                }

            }
           }


           System.out.println();

           for (int i = 0; i <= x.length; i++) {
            for (int j = 0; j <= y.length; j++) {
                System.out.print(" "+dummy[i][j]);
            }
            System.out.println();
           }

           System.err.println();

           System.out.println("Maximum Length: "+array[x.length][y.length]);

           System.out.println();

           System.out.print("LCS: ");
           traceback(dummy,x.length,y.length);

    }


    public static void traceback(int dummy[][],int i,int j)
    {
        if(i==0 || j==0)
        {
            return;
        }
        else if(dummy[i][j]==3)
        {
            traceback(dummy, i-1, j);
        }
        else if(dummy[i][j]==2)
        {
            
            traceback(dummy, i, j-1);
        }
        else
        {
        
            
            traceback(dummy, i-1, j-1);
            System.out.print(x[i-1]);
            
        }

    }


    public static void main(String[] args) {
        File f = new File("input.txt");

        try {
        
            Scanner in = new Scanner(f);

            String first = in.nextLine();
            String second = in.nextLine();

            x=first.toCharArray();
            y=second.toCharArray();

             
           lcss();

           in.close();
            
            
        } 
        catch (Exception e) 
        {
            
        }
    }
}
