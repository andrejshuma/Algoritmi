import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class Zad1 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            lista.add(scanner.nextInt());
        }

        lista.sort(Comparator.reverseOrder());
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
        }

        }
    }
