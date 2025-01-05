import java.util.*;
import java.util.Stack;
public class StackKniga2 {

    // Delumno tocna
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numBooks = scanner.nextInt();
        int numExams = scanner.nextInt();
        scanner.nextLine();

        List<String> booksArray = Arrays.asList(scanner.nextLine().split(" "));
        Collections.reverse(booksArray);

        String[] exams = scanner.nextLine().split(" ");

        int[] interactionCount = new int[numBooks];

        Stack<String> books = new Stack<>();
        books.addAll(booksArray);


        for (String exam : exams) {
            Stack<String> tempStack = new Stack<>();
            int index = booksArray.indexOf(exam);

            while (!books.isEmpty() && !books.peek().equals(exam)) {
                tempStack.push(books.pop());
            }

            if (!books.isEmpty() && books.peek().equals(exam)) {
                interactionCount[index]++;
                books.pop();
            }

            while (!tempStack.isEmpty()) {
                String tempBook = tempStack.pop();
                books.push(tempBook);
                interactionCount[booksArray.indexOf(tempBook)]++;
            }

            books.push(exam);
        }

        for (int i = 0; i < numBooks; i++) {
            System.out.println(booksArray.get(i) + " " + interactionCount[i]);
        }
    }
}
