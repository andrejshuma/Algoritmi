package lista_netezinski_nasocen;

import java.util.*;

public class Treta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVertex = scanner.nextInt();
        int numEdges = scanner.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for (int i = 0; i <numVertex ; i++) {
            graph.addVertex(i);
        }

        for (int i = 0; i <numEdges ; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        int L = scanner.nextInt();
        graph.removeVertex(L);

        Set<Integer> visited = new HashSet<>();
        int groups = 0;

        for (Integer s : graph.getAdjacencyList().keySet()) {
            if (!visited.contains(s)) {
                dfs(s,visited,graph);
                groups++;
            }
        }
        System.out.println(groups);
    }
    private static void dfs(Integer vertex, Set<Integer> visited, AdjacencyListGraph<Integer> graph) {
        visited.add(vertex);

        for (Integer neighbor : graph.getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited,graph);
            }
        }
    }
}
