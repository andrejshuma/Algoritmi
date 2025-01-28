package Kniga;

import java.util.*;

public class Konsultacii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numShortQuestions = scanner.nextInt();
        scanner.nextLine();
        Queue<String> shortQuestions = new LinkedList<>();
        for (int i = 0; i < numShortQuestions; i++) shortQuestions.add(scanner.nextLine());

        int numExcercises = scanner.nextInt();
        scanner.nextLine();
        Queue<String> excercises = new LinkedList<>();
        for (int i = 0; i < numExcercises; i++) excercises.add(scanner.nextLine());

        int numBoth = scanner.nextInt();
        scanner.nextLine();
        Queue<String> both = new LinkedList<>();
        for (int i = 0; i < numBoth; i++) both.add(scanner.nextLine());

        while (!shortQuestions.isEmpty() || !excercises.isEmpty() || !both.isEmpty()) {
            if (!shortQuestions.isEmpty()) {
                String s = shortQuestions.poll();
                System.out.println(s);
            } else {
                if (!both.isEmpty()) {
                    String s = both.poll();
                    System.out.println(s);
                    excercises.add(s);
                }

            }
            if (!excercises.isEmpty()) {
                String s = excercises.poll();
                System.out.println(s);
            } else {
                if (!both.isEmpty()) {
                    String s = both.poll();
                    System.out.println(s);
                    shortQuestions.add(s);
                }
            }
        }
    }
}
