package Kniga;
import classes.SLL;
import classes.SLLNode;
import java.util.*;
public class brishiJazli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SLL<Integer> lista = new SLL<>();
        for (int i = 0; i < n; i++) lista.insertLast(scanner.nextInt());

        System.out.println(lista);
        SLLNode<Integer> curr = lista.getFirst();

        int max = 1;

        while (curr != null ) {
            int counter = 0;

            while (counter<max){
                curr=curr.succ;
                counter++;
            }
            lista.delete(curr);

            max++;
            curr = curr.succ;
        }
        System.out.println(lista);

    }
}
