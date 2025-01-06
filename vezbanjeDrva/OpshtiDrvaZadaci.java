import java.util.*;
public class OpshtiDrvaZadaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        SLLTree<Integer> tree = new SLLTree<>();
        Map<Integer, Tree.Node<Integer>> map = new HashMap<>();

        for (int i = 0; i <n+q ; i++) {
            String [] input = scanner.nextLine().split(" ");
            String command = input[0];

            if(command.equals("root")){
                tree.makeRoot(Integer.parseInt(input[1]));
                map.put(Integer.parseInt(input[1]),tree.root());
            }
            else if(command.equals("add")){
                Integer parent = Integer.parseInt(input[1]);
                Integer child = Integer.parseInt(input[2]);
                Tree.Node<Integer> parentNode = map.get(parent);
                if(parentNode!=null){
                    Tree.Node<Integer> childNode = tree.addChild(parentNode, child);
                    map.put(child,childNode);
                }
            }
            else if(command.equals("ask")){
                Integer value = Integer.parseInt(input[1]);
                SLLTree.SLLNode<Integer> node = (SLLTree.SLLNode<Integer>) map.get(value);
                if(node!=null) System.out.println(countLeaves(node));
            }
        }
    }

    private static int countLeaves(SLLTree.SLLNode<Integer> node) {
        if(node.firstChild==null)return 1;

        SLLTree.SLLNode<Integer> firstChild = node.firstChild;

        int leaves =0;
        while(firstChild!=null){
            leaves+= countLeaves(firstChild);
            firstChild=firstChild.sibling;
        }
        return leaves;
    }
}
