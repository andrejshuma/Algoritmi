package Courses;

import classes.DLL;
import classes.DLLNode;

import java.util.*;

public class Zad12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) list.insertLast(scanner.nextInt());
        int k = scanner.nextInt();

        DLLNode<Integer> curr = list.getFirst();

        System.out.println(list);

        for (int i = 0; i < k; i++) {
            list.insertLast(curr.element);
            list.deleteFirst();
            curr = list.getFirst();
        }
        System.out.println(list);
    }
}
