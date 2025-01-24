package Kniga;
import classes.SLL;
import classes.SLLNode;
import java.util.*;

public class Rearange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SLL<Integer> lista = new SLL<>();
        SLL<Integer> org = new SLL<>();
        for (int i = 0; i <n ; i++){
            int num = scanner.nextInt();
            lista.insertLast(num);
            org.insertLast(num);
        }

        lista.mirror();

        System.out.println(org);
        SLL<Integer> rez = rearange(org,lista);
        System.out.println(rez);
    }

    private static SLL<Integer> rearange(SLL<Integer> napred,SLL<Integer> nazad) {
        SLL<Integer> rez = new SLL<>();

        SLLNode<Integer> first = napred.getFirst();
        SLLNode<Integer> second = nazad.getFirst();

        int max = napred.size();
        boolean flag = false;
        if(max%2==1){
            max++;
            flag=true;
        }
        int counter= 0;

        while(first!=null && second!=null && counter<max/2){
            rez.insertLast(first.element);
            rez.insertLast(second.element);

            first=first.succ;
            second=second.succ;
            counter++;
        }
        if(flag){
            SLLNode<Integer> curr = rez.getFirst();
            while(curr.succ!=null){
                curr=curr.succ;
            }
            rez.delete(curr);
        }


        return rez;
    }
}
