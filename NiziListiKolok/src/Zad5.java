import java.util.Scanner;
public class Zad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        DLL<Integer> lista = new DLL<>();
        for (int i = 0; i <n ; i++) {
            lista.insertLast(scanner.nextInt());
        }
        System.out.println(lista);
        int k = scanner.nextInt();



        System.out.println(lista);
    }
}