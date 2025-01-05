import java.util.Scanner;
import java.util.Stack;

public class StackKniga1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] pesticides = new int[n];
        for (int i = 0; i < n; i++) {
            pesticides[i] = scanner.nextInt();
        }

        int[] days = new int[n];
        Stack<Integer> stack = new Stack<>();
        int maxDays = 0;

        for (int i = 0; i < n; i++) {
            int maxDaysForPlant = 0;

            while (!stack.isEmpty() && pesticides[stack.peek()] >= pesticides[i]) {
                maxDaysForPlant = Math.max(maxDaysForPlant, days[stack.pop()]);
            }
            // 7
            // 6 5 8 4 7 10 9 pesticides

            // stack 6


            if (!stack.isEmpty()) {
                days[i] = maxDaysForPlant + 1;
            }

            stack.push(i);
            maxDays = Math.max(maxDays, days[i]);
        }

        System.out.println(maxDays);
    }
}
