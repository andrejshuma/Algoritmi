package Kniga;
import classes.DLL;
import classes.DLLNode;
import java.util.*;
public class ListaOdListi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        DLL<DLL<Integer>> listaOdListi = new DLL<>();
        DLL<Integer> sums = new DLL<>();


        for (int i = 0; i <n ; i++) {
            DLL<Integer> lista = new DLL<>();
            int sum = 0;
            for (int j = 0; j <m ; j++) {
                int num = scanner.nextInt();
                lista.insertLast(num);
                sum+=num;
            }
            sums.insertLast(sum);
            listaOdListi.insertLast(lista);
        }

        int rez = 1;

        DLLNode<Integer> curr = sums.getFirst();

        while(curr!=null){
            rez*= curr.element;
            curr=curr.succ;
        }
        System.out.println(sums);
        System.out.println(rez);
    }
}
