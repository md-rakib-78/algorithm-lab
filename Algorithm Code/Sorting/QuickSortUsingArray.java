import java.util.*;

public class QuickSortUsingArray{


    public static int quicksort(int arr[],int i,int j)
    {
         int pivot = arr[i];


         while(i<j)
         {

              while(arr[i]<pivot)
              {
                i++;
              }

              while(arr[j]>pivot)
              {
                j--;
              }

              if(i<j)
              {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
              }
         }

         int temp = arr[j];
         arr[j] = pivot;
         arr[i] = temp;

return j;

    }


    public static int quick(int arr[],int i,int j)
    {
        if(i<j)
        {
           int parti =  quicksort(arr,i,j);
        quick(arr, i, parti-1);
        quick(arr, parti+1, j);
        }
        return 0;
    }



    public static void main(String[] arg){
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter array Size: ");
        int size = input.nextInt();

        System.out.print("Enter array Element: ");

        int array[] = new int[size];

        for(int i=0;i<size;i++)
        {
            array[i]=input.nextInt();
        }
         
        int i=0;

        quick(array,i,size-1);


        for (int x : array) {
            
        System.out.print(x+" ");

        }


    }
}
