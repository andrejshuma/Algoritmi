import java.util.Scanner;
import java.util.ArrayList;


public class Zad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        SLL<String> lista = new SLL<>();
        for (int i = 0; i < n; i++) {
            lista.insertLast(scanner.nextLine());
        }
        int l = scanner.nextInt();
        System.out.println(lista);

        ArrayList<String> nodesToMove = new ArrayList<>(); // Temporary storage for nodes to move

        SLLNode<String> curr = lista.getFirst();
        while (curr != null) {
            if (curr.element.length() == l) {
                nodesToMove.add(curr.element); // Add element to temporary list
                SLLNode<String> nextNode = curr.succ;
                lista.delete(curr); // Delete node from the list
                curr = nextNode; // Move to the next node
            } else {
                curr = curr.succ; // Move to the next node normally
            }
        }

        // Reinsert all collected nodes at the end
        for (String element : nodesToMove) {
            lista.insertLast(element);
        }

        System.out.println(lista);
    }
}