import java.util.*;

public class GraphAdjacencyMatrix {

    public static void AdjancencyMatrix(int adMatrix[][], int vertex) {
        Scanner input = new Scanner(System.in);
        int edge;

        /// User input for Adjancency Matrix Graph
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.printf("adMatrix [%c][%c]: ", 65 + i, 65 + j);
                edge = input.nextInt();
                adMatrix[i][j] = edge;
            }
        }

        System.out.printf("\n");
        System.out.printf("\n");

        /// Displya Adjancency Graph
        for (int k = 0; k < vertex; k++) {
            System.out.printf("   %c  ", 65 + k);
        }
        System.out.printf("\n");
        for (int i = 0; i < vertex; i++) {

            System.out.printf("%c ", 65 + i);
            for (int j = 0; j < vertex; j++) {
                System.out.printf("  %d ", adMatrix[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter the graph vertex: ", args);
        int vertex = input.nextInt();

        int adMatrix[][] = new int[vertex][vertex];

        AdjancencyMatrix(adMatrix, vertex);

    }
}
