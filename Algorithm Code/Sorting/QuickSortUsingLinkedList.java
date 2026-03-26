
package quick.sort.using.linked.list;

import java.io.*;
import java.util.*;

public class QuickSortUsingLinkedList {

    private Node head = null;
    private int size;

    QuickSortUsingLinkedList() {
        this.size = 0;

    }

    // Create Node
    class Node {

        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
            size++;
        }

    }

    // Add value in Linked list

    public void addList(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node ptr = head;

            while (ptr.link != null) {
                ptr = ptr.link;
            }
            ptr.link = newNode;
        }
    }

    // Get Method for insert value index wise
    public int get(int index) {
        if (index == 0) {
            return head.data;
        } else {
            Node ptr = head;
            int n = 0;

            while (n < index) {
                ptr = ptr.link;
                n++;
            }
            return ptr.data;
        }
    }

    /// Set method for update value index wise
    public void set(int index, int data) {
        if (index == 0) {
            head.data = data;
        } else {
            Node ptr = head;
            int n = 0;
            while (n < index) {
                ptr = ptr.link;
                n++;
            }
            ptr.data = data;
        }
    }

    // Quick method for sorting divide

    public static int quick(QuickSortUsingLinkedList list, int i, int j) {
        int start = i;
        int end = j;
        int pivot = list.get(i);

        while (i < j) {
            while (i <= end && list.get(i) <= pivot) {
                i++;
            }
            while (j >= start && list.get(j) > pivot) {
                j--;
            }
            if (i < j) {
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        list.set(start, list.get(j));
        list.set(j, pivot);
        return j;

    }

    // Quick Sort Method for divide linked list
    public static void quickSort(QuickSortUsingLinkedList list, int i, int j) {
        if (i < j) {
            int partision = quick(list, i, j);

            quickSort(list, i, partision - 1);
            quickSort(list, partision + 1, j);
        }
    }

    /// Main Method
    public static void main(String[] args) throws Exception {

        QuickSortUsingLinkedList list = new QuickSortUsingLinkedList();

        // Create Input Text File
        try {
            File file = new File(
                    "input.txt");
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Read Input Text File
        try {
            File fileo = new File(
                    "input.txt");
            Scanner in = new Scanner(fileo);

            while (in.hasNext()) {
                int num = Integer.parseInt(in.next());
                list.addList(num);

            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /// Print List after call quick sort
        System.out.println();
        System.out.print("Before Apply Quick sort: ");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        /// Call Quick Sort Method

        quickSort(list, 0, list.size - 1);

        ///

        System.out.println();
        System.out.print("After Apply Quick sort: ");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        // Create Output Text File
        File fileOut = new File(
                "output.txt");
        try {
            fileOut.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Write Output Text File
        try {
            Formatter form = new Formatter(
                    "output.txt");

            for (int i = 0; i < list.size; i++) {
                form.format(" %d ", list.get(i));
            }
            form.close();

        } catch (Exception e) {
            System.out.print(e);
        }

    }

}
