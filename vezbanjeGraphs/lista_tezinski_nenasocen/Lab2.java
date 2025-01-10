
package lista_tezinski_nenasocen;
import java.util.*;

public class Lab2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        AdjacencyListGraph<String>graph=new AdjacencyListGraph<>();
        String[]niza=new String[2*n];
        int j=0;

        for (int i=0;i<n;i++){
            String  [] parts=sc.nextLine().split(" ");
            graph.addVertex(parts[0]);
            graph.addVertex(parts[1]);
            niza[j++]=parts[0];
            niza[j++]=parts[1];
        }

        int m=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String  [] parts=sc.nextLine().split(" ");
            graph.addEdge(parts[0],parts[1],Integer.parseInt(parts[2]));

        }
        j=0;
        int suma=0;
        for (int i = 0; i < n; i++) {
            Map<String,Integer>shortest=graph.shortestPath(niza[j]);
            suma+=shortest.get(niza[j+1]);
            j+=2;

        }
        System.out.println(suma);
    }
}
