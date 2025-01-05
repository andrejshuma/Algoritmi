import java.util.*;
public class Zad6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int elem = scanner.nextInt();

        int [ ] niza = new int [n];

        for (int i = 0; i < n; i++) {
            niza[i]= scanner.nextInt();
        }

        int pos = binarySearch(niza,elem);
        if(pos==-1) System.out.println("Ne postoi");
        else System.out.println(pos);
    }

    private static int binarySearch(int[] niza, int target) {
        int left = 0;
        int right = niza.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (niza[mid] == target) {
                return mid;
            } else if (niza[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
