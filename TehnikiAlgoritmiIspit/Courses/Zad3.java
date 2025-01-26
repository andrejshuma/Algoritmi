package Courses;

import java.util.*;

public class Zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int C = 40;
        int[] time = new int[n];
        int[] pay = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
            pay[i] = scanner.nextInt();
        }

        System.out.println(greedyKnapsack(C, n, time, pay));
    }

    private static int greedyKnapsack(int c, int n, int[] time, int[] pay) {
        sortiraj(pay, time, n);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (c > time[i]) {
                c -= time[i];
                max += pay[i];
            } else {
                max += (c*pay[i])/time[i];
                break;
            }
        }
        return max;
    }

    private static void sortiraj(int[] pay, int[] time, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((float) pay[i] / (float) time[i] < (float) pay[j] / (float) time[j]) {
                    int tmpP = pay[i];
                    int tmpT = time[i];
                    pay[i] = pay[j];
                    time[i] = time[j];
                    pay[j] = tmpP;
                    time[j] = tmpT;
                }
            }
        }
    }
}
