import java.sql.SQLOutput;
import java.util.*;

public class Kolokviumska {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        BTree<Integer> tree = new BTree<>();
        HashMap<Integer, BNode<Integer>> mapa = new HashMap<>();

        for (int i = 0; i < n + q; i++) {
            String[] token = scanner.nextLine().split(" ");
            switch (token[0]) {
                case "root" -> {
                    Integer rootValue = Integer.parseInt(token[1]);
                    tree.makeRoot(rootValue);
                    mapa.put(rootValue, tree.root);
                }
                case "add" -> {
                    Integer parentValue = Integer.parseInt(token[1]);
                    Integer childValue = Integer.parseInt(token[2]);
                    String direction = token[3];
                    int dir = direction.equals("LEFT") ? 1 : 2;

                    BNode<Integer> parentNode = mapa.get(parentValue);
                    mapa.put(childValue, tree.addChild(parentNode, dir, childValue));
                }
                case "ask" -> {
                    Integer childVal = Integer.parseInt(token[1]);
                    BNode<Integer> node = mapa.get(childVal);
                    System.out.println(BFS(node, 1));
                }
            }
        }

    }

    public static float BFS(BNode<Integer> root, int level) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[2]; // result[0] = sum, result[1] = count
        BFSHelper(root, level, result);
        return (float) result[0] / result[1];
    }

    private static void BFSHelper(BNode<Integer> node, int level, int[] result) {
        if (node == null) {
            return;
        }
        result[0] += level;
        result[1]++;
        BFSHelper(node.left, level + 1, result);
        BFSHelper(node.right, level + 1, result);
    }
}
