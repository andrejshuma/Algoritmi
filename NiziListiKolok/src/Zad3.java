

import java.util.Scanner;
public class Zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        DLL<Integer> lista = new DLL<>();
        for (int i = 0; i <n ; i++) {
            lista.insertLast(scanner.nextInt());
        }
        System.out.println(lista);
        int k = scanner.nextInt();

        for (int i = 0; i < k; i++) {
            DLLNode<Integer>  curr = lista.getFirst();
            lista.insertLast(curr.element);
            lista.deleteFirst();
        }
        System.out.println(lista);
    }
}
