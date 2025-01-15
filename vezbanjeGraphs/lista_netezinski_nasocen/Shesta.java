package lista_netezinski_nasocen;

import java.util.*;
public class Shesta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTasks = scanner.nextInt();
        scanner.nextLine();

        Map<String, Integer> mapa = new HashMap<>();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < numTasks; i++) {
            String[] line = scanner.nextLine().split(" ");
            mapa.put(line[0], Integer.parseInt(line[1]));
            graph.addVertex(line[0]);
        }

        int numDependencies = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numDependencies; i++) {
            String[] line = scanner.nextLine().split(" ");
            graph.addEdge(line[1], line[0]);
        }

        int result = findMinimumCompletionTime(graph, mapa);
        System.out.println(result);
    }

    private static int findMinimumCompletionTime(AdjacencyListGraph<String> graph, Map<String, Integer> mapa) {
        Map<String, Integer> completionTime = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int maxTime = 0;

        for (String task : graph.getAdjacencyList().keySet()) {
            if (!visited.contains(task)) {
                maxTime = Math.max(maxTime, dfs(task, graph, mapa, completionTime, visited));
            }
        }
        return maxTime;
    }

    private static int dfs(String task, AdjacencyListGraph<String> graph, Map<String, Integer> mapa, Map<String, Integer> completionTime, Set<String> visited) {
        if (visited.contains(task)) {
            return completionTime.get(task);
        }
        visited.add(task);

        int maxDependencyTime = 0;
        for (String neighbor : graph.getNeighbors(task)) {
            maxDependencyTime = Math.max(maxDependencyTime, dfs(neighbor, graph, mapa, completionTime, visited));
        }

        int totalTime = mapa.get(task) + maxDependencyTime;
        completionTime.put(task, totalTime);

        return totalTime;
    }
}
