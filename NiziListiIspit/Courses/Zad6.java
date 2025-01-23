package Courses;
import classes.SLL;
import classes.SLLNode;
import java.util.*;
public class Zad6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        SLL<String> lista = new SLL<>();

        for (int i = 0; i <n ; i++) {
            lista.insertLast(scanner.nextLine());
        }

        int L = scanner.nextInt();


        SLLNode<String> tmp = lista.getFirst();
        SLLNode<String> ovoj = lista.getFirst();

        while(tmp!=null){
            if(tmp.element.length()==L){
                ovoj=tmp;
            }
            tmp = tmp.succ;
        }
        System.out.println(lista);
        lista.delete(ovoj);
        lista.insertFirst(ovoj.element);
        System.out.println(lista);

    }
}
