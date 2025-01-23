package Courses;
import classes.DLL;
import classes.DLLNode;
import java.util.*;

public class Zad11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) list.insertLast(scanner.nextInt());
        int k = scanner.nextInt();

        DLLNode<Integer> curr = list.getLast();

        System.out.println(list);

        for (int i = 0; i <k ; i++) {
            list.insertFirst(curr.element);
            list.deleteLast();
            curr = list.getLast();
        }
        System.out.println(list);


    }
}
