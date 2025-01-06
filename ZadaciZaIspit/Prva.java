import java.util.*;
public class Prva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int n = scanner.nextInt();
        for (int i = 0; i <n ; i++) tree.insert(scanner.nextInt());
        tree.inorderR(tree.getRoot());
    }
}
