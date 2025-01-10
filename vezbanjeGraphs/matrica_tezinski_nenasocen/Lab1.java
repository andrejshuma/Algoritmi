package matrica_tezinski_nenasocen;


import java.util.*;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(n);
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String city = scanner.nextLine();
            map.put(city,i);
            graph.addVertex(i, city);
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <m ; i++) {
            String [] line = scanner.nextLine().split(" ");
            graph.addEdge(map.get(line[0]),map.get(line[1]),Integer.parseInt(line[2]));
        }
        int sum = 0;
        for (Edge edge : graph.kruskal()) {
            sum+= edge.getWeight();
        }

        System.out.println(sum);
    }
}
