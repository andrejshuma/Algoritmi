package Courses;
import java.util.*;
import classes.DLL;
import classes.DLLNode;

public class Zad8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<>();

        for (int i = 0; i <n ; i++) {
            list.insertLast(scanner.nextInt());
        }
        int k = scanner.nextInt();
        System.out.println(list);

        for (int i = 0; i <k ; i++) {
            list.insertLast(list.getFirst().element);
            list.deleteFirst();
        }
        System.out.println(list);
    }
}
