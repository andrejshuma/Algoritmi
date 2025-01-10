package lista_netezinski_nasocen;
import java.util.*;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        HashMap<String, Integer> time = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String []parts = scanner.nextLine().split(" ");
            time.put(parts[0], Integer.parseInt(parts[1]));
            graph.addVertex(parts[0]);
        }
        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            String []parts = scanner.nextLine().split(" ");
            graph.addEdge(parts[1], parts[0]);
        }

        System.out.println(solve(graph, time));
    }

    private static int solve(AdjacencyListGraph<String> graph, HashMap<String, Integer> time) {
        List<String> sorted = graph.topologicalSort();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String s : sorted) {
            int t = time.get(s);
            max = Math.max(max, t);
            map.put(s, t);
        }
        int ans = 0;
        for (String module : sorted){
            String max_neighbor = "";
            for (String neighbor : graph.getNeighbors(module)){
                if (map.get(module) + time.get(neighbor) > map.get(neighbor)){
                    map.put(neighbor, time.get(neighbor) + map.get(module));
                    if (max_neighbor.isBlank() || map.get(neighbor) > map.get(max_neighbor))
                        max_neighbor = neighbor;
                }
            }
            ans = max_neighbor.isBlank() ? ans : Math.max(ans, map.get(max_neighbor));
        }
        return ans == 0 ? max : ans;
    }
}
