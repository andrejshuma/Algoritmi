package lista_netezinski_nasocen;

import java.util.*;


public class Petta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numEdges = scanner.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < numEdges; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        int startVertex = scanner.nextInt();
        int wantedSum = scanner.nextInt();

        int count = findPathsWithSum(graph, startVertex, wantedSum,0);
        System.out.println(count);
    }


    private static int findPathsWithSum(AdjacencyListGraph<Integer> graph, int currentVertex, int wantedSum, int currentSum) {
        currentSum += currentVertex;
        if (currentSum > wantedSum) {
            return 0;
        }
        int count = 0;
        if (currentSum == wantedSum) {
            count++;
        }
        for (Integer neighbor : graph.getNeighbors(currentVertex)) {
            count += findPathsWithSum(graph, neighbor, wantedSum, currentSum);
        }
        return count;
    }
}
