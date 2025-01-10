package lista_netezinski_nasocen;
import java.util.*;
public class DedoMraz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVertex = scanner.nextInt();
        int numEdges = scanner.nextInt();
        scanner.nextLine();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for (int i = 0; i <numEdges ; i++) {
            String [] line = scanner.nextLine().split(" ");
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
         int startVertex = scanner.nextInt();

        Set<Integer> visited = new HashSet<>();

        dfs(startVertex,visited,graph);
        System.out.println(visited.size());


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
