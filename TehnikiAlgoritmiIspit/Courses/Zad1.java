package Courses;
import java.util.*;

public class Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(scanner.nextInt());
        }

        list.sort(Comparator.reverseOrder());
        printaj(list);
    }

    private static void printaj(ArrayList<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer);
        }
    }
}
