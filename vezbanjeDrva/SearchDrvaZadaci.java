import java.util.*;
public class SearchDrvaZadaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for (int i = 0; i <n+q ; i++) {

            String [] input = scanner.nextLine().split(" ");
            String command = input[0];

            if(command.equals("insert")){
                tree.insert(Integer.parseInt(input[1]));
            }
            else if(command.equals("ask")){
                BNode<Integer> Node = tree.find(Integer.parseInt(input[1]));
                System.out.println(findDepthOfNode(tree.getRoot(),Node));
                System.out.println(smallerThan(tree.getRoot(), Integer.parseInt(input[1])));
                System.out.println(biggerThan(tree.getRoot(),Integer.parseInt(input[1])));
            }
        }
    }

    private static int biggerThan(BNode<Integer> root, int x) {
        if(root==null)return 0;

        if(x>=root.info){
            return biggerThan(root.right,x);
        }
        else return 1+biggerThan(root.right,x) + biggerThan(root.left,x);
    }

    private static int smallerThan(BNode<Integer> root,int x) {
        if(root==null)return 0;

        if(x> root.info){
            return 1+ smallerThan(root.right,x) + smallerThan(root.left,x);
        }
        else return smallerThan(root.left,x);
    }


    private static int findDepthOfNode(BNode<Integer> root, BNode<Integer> node) {
        if(root == null){
            return 0;
        }
        if(root == node){
            return 1;
        }
        else if(node.info < root.info){
            return 1 + findDepthOfNode(root.left,node);
        }
        else{
            return 1 + findDepthOfNode(root.right,node);
        }
    }
}
