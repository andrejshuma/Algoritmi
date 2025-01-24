package Kniga;
import classes.SLL;
import classes.SLLNode;
import java.util.*;
public class min_max {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SLL<Integer> lista = new SLL<>();
        for (int i = 0; i <n ; i++) lista.insertLast(scanner.nextInt());

        SLL<Integer> min = new SLL<>();
        SLL<Integer> max = new SLL<>();

        podeli(lista,min,max);

        System.out.println(lista);
        System.out.println();
        System.out.println(min);
        System.out.println(max);
    }

    private static void podeli(SLL<Integer> lista, SLL<Integer> min, SLL<Integer> max) {
        int [] minmax = {0,Integer.MAX_VALUE}; // minmax [0] = max & minmax [1] min
        najdi(lista.getFirst(),minmax);

        SLLNode<Integer> curr = lista.getFirst();
        while(curr!=null){
            int razlikaMin = curr.element-minmax[1];
            int razlikaMax = minmax[0]- curr.element;
            if(curr.element==minmax[0])max.insertLast(curr.element);
            else if(curr.element==minmax[1])min.insertLast(curr.element);
            else if(Math.abs(razlikaMin) <= Math.abs(razlikaMax))min.insertLast(curr.element);
            else max.insertLast(curr.element);
            curr = curr.succ;
        }
    }

    private static void najdi(SLLNode<Integer> curr, int[] minmax) {
        while(curr!=null){
            if(curr.element<minmax[1]){
                minmax[1]=curr.element;
            }
            if(curr.element>minmax[0]){
                minmax[0]=curr.element;
            }
            curr= curr.succ;
        }
    }
}
