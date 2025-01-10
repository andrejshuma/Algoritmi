import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

class BNode2<E> {

    public E info;
    public BNode2<E> left;
    public BNode2<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode2(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode2() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode2(E info, BNode2<E> left, BNode2<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return ""+info;
    }
}

class BTree<E> {

    public BNode2<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode2<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode2<>(elem);
    }

    public void makeRootNode(BNode2<E> node) {
        root = node;
    }

    public BNode2<E> addChild(BNode2<E> node, int where, E elem) {

        BNode2<E> tmp = new BNode2<E>(elem);

        if (where == BNode2.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode2<E> addChildNode(BNode2<E> node, int where, BNode2<E> tmp) {

        if (where == BNode2.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

}

public class Chetvrta {

    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        BNode2<String> nodes[] = new BNode2[N];
        BTree<String> tree = new BTree<String>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode2<String>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode2.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode2.RIGHT, nodes[index]);
            } else {
                tree.makeRootNode(nodes[index]);
            }
        }


        int cases = Integer.parseInt(br.readLine());
        for (int l = 0; l < cases; l++) {
            String split[] = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];

            BNode2<String> found = getLCA(from, to, tree.root);
            if (found == null) {
                System.out.println("ERROR");
            } else {
                int f = calculate(from, found, 0);
                int t = calculate(to, found, 0);

                if (t + f == -1) System.out.println("ERROR");
                else System.out.println(t + f);
            }


        }
        br.close();
    }

    private static int calculate(String s, BNode2<String> node, int counter) {
        if (node == null) return -1;
        if (node.info.equals(s)) return counter;

        int left = calculate(s, node.left, counter + 2);
        if (left != -1) return left;
        return calculate(s, node.right, counter + 2);
    }

    private static BNode2<String> getLCA(String from, String to, BNode2<String> root) {
        if (root == null || root.info.equals(from) || root.info.equals(to)) return root;

        BNode2<String> left = getLCA(from, to, root.left);
        BNode2<String> right = getLCA(from, to, root.right);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else {
            return root;
        }
    }
}