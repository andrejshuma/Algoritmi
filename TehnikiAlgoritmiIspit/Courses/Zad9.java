package Courses;

import java.util.*;



public class Zad9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numDigits = scanner.nextInt();
        int sum = scanner.nextInt();


        int momSum=0;


        int[] smallestNumber = findSmallestNumber(numDigits, sum);
        for(int num : smallestNumber){
            momSum+=num;
        }

        if(momSum!=sum) System.out.println("Ne postoi");
        else printaj(smallestNumber);

    }

    private static void printaj(int[] smallestNumber) {
        for(int num : smallestNumber){
            System.out.print(num);
        }
    }

    private static int [] findSmallestNumber(int N, int M) {


        int[] digits = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            if (M > 9) {
                digits[i] = 9;
                M -= 9;
            } else {
                digits[i] = M;
                M = 0;
            }
        }

        if (digits[0] == 0) {
            digits[0] = 1;
            for (int i = 1; i < N; i++) {
                if (digits[i] > 0) {
                    digits[i]--;
                    break;
                }
            }
        }

        return digits;
    }
}

