package Courses;
import java.util.*;



public class Zad7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int position = binarySearch(list, m);

        if (position <0) {
            System.out.println("Ne postoi");

        } else {
            System.out.println(position);
        }
    }

    private static int binarySearch(ArrayList<Integer> list, int m) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == m) {
                return mid;
            }

            if (list.get(mid) < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
