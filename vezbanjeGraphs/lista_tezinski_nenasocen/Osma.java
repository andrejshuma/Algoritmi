package lista_tezinski_nenasocen;

import java.util.*;

public class Osma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numVertices = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> vertices = new ArrayList<>();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        int j = 0;

        for (int i = 0; i <numVertices; i++) {
            String [] line = scanner.nextLine().split(" ");
            graph.addVertex(line[0]);
            graph.addVertex(line[1]);
            vertices.add(j++, line[0]);
            vertices.add(j++, line[1]);
        }

        int numEdges = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <numEdges ; i++) {
            String [] line = scanner.nextLine().split(" ");
            graph.addEdge(line[0], line[1], Integer.parseInt(line[2]));
        }
        j =0;
        int sum = 0;

        for (int i = 0; i <numVertices ; i++) {
            Map<String, Integer> shortest = graph.shortestPath(vertices.get(j));
            sum += shortest.get(vertices.get(j+1));
            j += 2;
        }
        System.out.println(sum);
    }
}
