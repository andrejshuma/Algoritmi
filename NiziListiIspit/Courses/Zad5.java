package Courses;
import classes.SLL;
import classes.SLLNode;
import java.util.*;
public class Zad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        SLL<String> lista = new SLL<>();

        for (int i = 0; i <n ; i++) {
            lista.insertLast(scanner.nextLine());
        }

        int L = scanner.nextInt();

        SLL<String> rez1 = new SLL<>();
        SLL<String> rez2 = new SLL<>();
        SLLNode<String> tmp = lista.getFirst();

        while(tmp!=null){
            if(tmp.element.length()==L){
                rez2.insertLast(tmp.element);
            }
            else rez1.insertLast(tmp.element);
            tmp = tmp.succ;
        }

        System.out.println(lista);
        if (rez2.size()==0) System.out.println(rez1);
        else System.out.println(rez1+"->" + rez2);
    }
}
