package Courses;
import classes.DLL;
import classes.DLLNode;
import java.util.*;
public class Zad9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<>();

        for (int i = 0; i <n ; i++) {
            list.insertLast(scanner.nextInt());
        }

        int m = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(list);
        DLLNode<Integer> ovoj = list.find(m);
        if(ovoj==null){
            System.out.println(list);
            return;
        }

        for (int i = 0; i <k ; i++) {
            if(Objects.equals(ovoj.element, list.getFirst().element)){
                list.insertLast(list.getFirst().element);
                list.deleteFirst();
                ovoj = list.find(m);
            }
            else{
                int tmp = ovoj.element;
                ovoj.element = ovoj.pred.element;
                ovoj.pred.element = tmp;
                ovoj = ovoj.pred;
            }
        }
        System.out.println(list);

    }
}
