package lista_netezinski_nasocen;
import java.util.*;

public class Prva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVertex = scanner.nextInt();
        scanner.nextLine();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i <numVertex ; i++) {
            graph.addVertex(scanner.nextLine());
        }

        int numEdges = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <numEdges ; i++) {
            String [] line = scanner.nextLine().split(" ");
            graph.addEdge(line[0], line[1]);
        }

        Set<String> visited = new HashSet<>();
        int groups = 0;

        for (String s : graph.getAdjacencyList().keySet()) {
            if (!visited.contains(s)) {
                dfs(s,visited,graph);
                groups++;
            }
        }
        System.out.println(groups);
    }
    private static void dfs(String vertex, Set<String> visited, AdjacencyListGraph<String> graph) {
        visited.add(vertex);

        for (String neighbor : graph.getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited,graph);
            }
        }
    }
}
