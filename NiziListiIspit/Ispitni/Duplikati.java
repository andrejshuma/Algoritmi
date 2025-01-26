package Ispitni;
import classes.SLL;
import classes.SLLNode;
import java.util.*;

public class Duplikati {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SLL<Integer> lista = new SLL<>();
        for (int i = 0; i <n ; i++) lista.insertLast(scanner.nextInt());
        int k = scanner.nextInt();

        int counter = 0;
        SLLNode<Integer> curr = lista.getFirst();

        while(curr!=null){
            if(curr.element.equals(k))counter++;
            curr=curr.succ;
        }
        if(counter%2==1){
            curr = lista.getFirst();
            while(curr!=null){
                if(curr.element.equals(k)){
                    lista.insertAfter(k,curr);
                    break;
                }
                curr=curr.succ;
            }
        }
        System.out.println(lista);
    }
}
