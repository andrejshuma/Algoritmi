package matrica_tezinski_nenasocen;
import lista_tezinski_nenasocen.AdjacencyListGraph;

import java.util.*;
public class Deset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVertex = scanner.nextInt();
        scanner.nextLine();

        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(numVertex);

        Map<String, Integer> vertexMap = new HashMap<>();

        for (int i = 0; i <numVertex ; i++) {
            graph.addVertex(i,scanner.nextLine());
            vertexMap.put(graph.getVertex(i),i);
        }

        int numEdges = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <numEdges ; i++) {
            String [] line = scanner.nextLine().split(" ");
            graph.addEdge(vertexMap.get(line[0]), vertexMap.get(line[1]), Integer.parseInt(line[2]));
        }

        List<Edge> list = graph.kruskal();
        int sum=0;

        for (Edge edge : list) {
            sum+=edge.getWeight();
        }
        System.out.println(sum);
    }
}
