package Kniga;
import classes.SLL;
import classes.SLLNode;
import java.util.*;
public class NaizmenicnoSpoiListi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SLL<Integer> prva = new SLL<>();
        for (int i = 0; i <n ; i++) prva.insertLast(scanner.nextInt());


        int m = scanner.nextInt();
        SLL<Integer> vtora = new SLL<>();
        for (int i = 0; i <m ; i++) vtora.insertLast(scanner.nextInt());
// 5 5 7 9 8 1 1 4 5 6 8 9 4
        SLL<Integer> rez = new SLL<>();

        System.out.println(prva);
        System.out.println(vtora);
        boolean prv = true;
        while(prva.size() > 2 && vtora.size()>2){
            SLLNode<Integer> first = prva.getFirst();
            SLLNode<Integer> second = vtora.getFirst();
            if(prv){
                rez.insertLast(first.element);
                rez.insertLast(first.succ.element);
                rez.insertLast(second.element);
                rez.insertLast(second.succ.element);
            }
            else{
                rez.insertLast(second.element);
                rez.insertLast(second.succ.element);
                rez.insertLast(first.element);
                rez.insertLast(first.succ.element);
            }
            prv=!prv;
            prva.deleteFirst();
            prva.deleteFirst();
            vtora.deleteFirst();
            vtora.deleteFirst();
        }
        SLLNode<Integer> first = prva.getFirst();
        SLLNode<Integer> second = vtora.getFirst();

        while(first!=null){
            rez.insertLast(first.element);
            first=first.succ;
        }

        while(second!=null){
            rez.insertLast(second.element);
            second=second.succ;
        }

        System.out.println(rez);
    }
}
