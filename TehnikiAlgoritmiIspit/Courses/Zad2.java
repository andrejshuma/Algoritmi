package Courses;

import java.util.*;

public class Zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] arrival = new int[n];
        int[] departure = new int[n];

        for (int i = 0; i < n; i++) {
            arrival[i] = scanner.nextInt();
            departure[i] = scanner.nextInt();
        }


        System.out.println(minPlatforms(departure, arrival, n));
    }

    private static int minPlatforms(int[] departure, int[] arrival, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int max = 1;
        int br = 1;

        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                i++;
                br++;
            } else if (arrival[i] > departure[j]) {
                j++;
                br--;
            }
            if (br > max) max = br;
        }
        return max;
    }


}
