package Ispitni;
import classes.SLL;
import classes.SLLNode;
import java.util.*;

public class ZigZag{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list = new SLL<>();

        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        System.out.println(list);

        makeZigZag(list);
        //makeZigZag1(list);

        System.out.println(list);
    }

    private static void makeZigZag(SLL<Integer> list) {
        SLLNode<Integer> curr = list.getFirst();
        while (curr!=null){
            if(curr.element==0)list.delete(curr);
            curr=curr.succ;
        }

        curr = list.getFirst();
        SLLNode<Integer> next = curr.succ;

        while (curr!=null && next!=null){
            if(curr.element > 0 && next.element>0){
                list.delete(next);
                curr=next.succ;
                next = next.succ.succ;
                continue;
            }
            else if(curr.element < 0 && next.element<0){
                int nov = curr.element * -1;
                list.insertAfter(nov,curr);
            }
            curr=curr.succ;
            next = next.succ;
        }
    }
    private static void makeZigZag1(SLL<Integer> lista) {
        boolean raste = true;
        SLLNode<Integer> curr = lista.getFirst();

        while(curr!=null && curr.succ!=null){
            if((raste && curr.element >= curr.succ.element )||(!raste && curr.element<= curr.succ.element)){
                lista.delete(curr.succ);
                continue;
            }
            curr=curr.succ;
            raste=!raste;
        }
    }
}
