import java.util.*;

public class MergeSort {

public static void mergesorting(int arr[],int s,int e)
{
    if(s<e)
    {
     int mid =(s+e)/2;

          mergesorting(arr, s, mid);
          mergesorting(arr, mid+1, e);
          
          merge(arr, s, e);   
    }
}

//                                     0     6
public static void merge(int arr[],int s,int e)
{
 //             3
    int mid = (s+e)/2;
    //          4
    int len1 = mid-s+1;
 //             3
    int len2 = e - mid;
   //                       4
    int first[] = new int[len1];
    //                       3
    int second[] = new int[len2];
   //      0
    int k =s;

    //copy array element in first part
    for(int i=0;i<len1;i++)
    {
        first[i] = arr[k];
        k++;
    }


    // copy array element in second part
    k= mid+1;
    for(int i=0;i<len2;i++)
    {
        second[i] = arr[k];
        k++;
    }


    //merge

    int index1=0;
    int index2=0;
    int mainIndex = s;

    while(index1<len1 && index2<len2)
    {
        if(first[index1]<second[index2])
        {
            arr[mainIndex] = first[index1];
            index1++;
        }
        else 
        {
            arr[mainIndex] = second[index2];
            index2++;
        }
        mainIndex++;
    }

    while(index1<len1)
    {
        arr[mainIndex]=first[index1];
        mainIndex++;
        index1++;
    }
    while (index2<len2) {
        arr[mainIndex] = second[index2];
        mainIndex++;
        index2++;
    }



}




    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter array Element ");

        int array[] = new int[7];

        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

mergesorting(array, 0, array.length-1);

for (int x : array) {

    System.out.print(x + " ");
}

    }
}
