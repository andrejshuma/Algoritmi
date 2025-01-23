package Courses;
import classes.SLL;
import classes.SLLNode;
import java.util.*;
public class Zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        SLL<String> lista = new SLL<>();

        for (int i = 0; i <n ; i++) {
            lista.insertLast(scanner.nextLine());
        }

        int L = scanner.nextInt();

        SLL<String> rez = new SLL<>();
        SLLNode<String> tmp = lista.getFirst();

        while(tmp!=null){
            if(tmp.element.length()>=L){
                rez.insertLast(tmp.element);
            }
            tmp = tmp.succ;
        }
        System.out.println(lista);
        System.out.println(rez);
    }
}
