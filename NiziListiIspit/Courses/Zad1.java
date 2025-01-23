package Courses;

import java.util.*;

public class Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Integer> lista = new ArrayList<>();
        int sum =0;
        for (int i = 0; i <n ; i++) {
            lista.add(i,scanner.nextInt());
            sum+=lista.get(i);
        }
        mojToString(lista);
        System.out.println();

        double avg = (double) sum / (double) n;

        ArrayList<Integer> rez = new ArrayList<>();


        for (Integer integer : lista) {
            if (integer >= avg) {
                rez.add(integer);
            }
        }
        mojToString(rez);
    }

    private static void mojToString(ArrayList<Integer> lista) {
        System.out.print("{");
        for (Integer integer : lista) {
            System.out.print(integer);
            if (lista.indexOf(integer) != lista.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print("}");

    }
}
