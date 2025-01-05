import java.util.Scanner;
import java.util.ArrayList;

public class Zad1 {
    public static void printArray(ArrayList<Integer> niza){
        System.out.print("{");
        for (int i = 0; i < niza.size() ; i++) {
            System.out.print(niza.get(i));
            if(i< niza.size()-1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int zbir=0;
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            int tmp = scanner.nextInt();
            lista.add(tmp);
            zbir+=tmp;
        }
        float average = (float)zbir / (float)n;
        ArrayList<Integer> nova = new ArrayList<>();
        for (int num : lista){
            if(num>=average){
                nova.add(num);
            }
        }

        printArray(lista);
        printArray(nova);
    }
}