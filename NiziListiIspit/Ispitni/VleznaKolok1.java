package Ispitni;
import classes.SLL;
import classes.SLLNode;
import java.util.*;
public class VleznaKolok1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        SLL<String> lista = new SLL<>();

        for (int i = 0; i <n ; i++) lista.insertLast(scanner.next());
        System.out.println(lista);

        SLLNode<String> curr = lista.getFirst();
        int max = lista.size();
        int counter =0;
        while(curr!=null && counter<max){
            if(Character.isLowerCase(curr.element.charAt(0))){
               lista.insertLast(curr.element);
               lista.delete(curr);
            }
            curr=curr.succ;
            counter++;
        }

        System.out.println(lista);
    }
}
