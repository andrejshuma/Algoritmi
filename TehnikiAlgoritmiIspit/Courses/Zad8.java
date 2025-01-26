package Courses;

import java.util.*;

public class Zad8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numZadaci = scanner.nextInt();
        int numVraboteni = scanner.nextInt();

        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < numZadaci; i++) lista.add(scanner.nextInt());

        lista.sort(Comparator.reverseOrder());

        int daysNeeded = 0;
        int totalFreeHours = 0;

        while (!lista.isEmpty()) {
            daysNeeded++;
            int[] hours = new int[numVraboteni];

            for (int i = 0; i < lista.size();) {
                boolean dadena = false;
                for (int j = 0; j < numVraboteni; j++) {
                    if (hours[j] + lista.get(i) <= 8) {
                        dadena = true;
                        hours[j] += lista.get(i);
                        break;
                    }
                }
                if (dadena) {
                    lista.remove(i);
                } else i++;
            }
            for (int i = 0; i < numVraboteni; i++) {
                totalFreeHours += (8 - hours[i]);
            }
        }
        System.out.println(daysNeeded + " " + totalFreeHours);
    }
}
