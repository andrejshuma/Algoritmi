import java.util.*;
public class BinarniDrvaZadaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int q= scanner.nextInt();
        scanner.nextLine();
        BTree<String> tree = new BTree<>();
        Map<String,BNode<String>> map = new HashMap<>();

        for (int i = 0; i <n+q ; i++) {
            String [] input = scanner.nextLine().split(" ");
            String command = input[0];

            if(command.equals("root")){
                tree.makeRoot(input[1]);
                map.put(input[1],tree.root);
            }
            else if(command.equals("add")){
                String parentValue = input[1];
                BNode<String> parentNode = map.get(parentValue);
                if(parentNode!=null){
                    String childValue = input[2];
                    String direction = input[3];
                    int where = direction.equals("LEFT") ? 1 : 2;
                    map.put(childValue,tree.addChild(parentNode,where,childValue));
                }
            }
            else if(command.equals("ask")){
                String nodeValue = input[1];
                BNode<String> NODE = map.get(nodeValue);
                if(NODE!=null){
                    //System.out.println(countInside(NODE));
                    //System.out.println(twoChildren(NODE));
                    //System.out.println(maxDepth(NODE));
                    System.out.println(sumDegrees(NODE));
                }

            }
        }
    }

    private static int sumDegrees(BNode<String> node) {
        if(node==null)return 0;
        int degree=0;
        if(node.right!=null)degree = degree+1+sumDegrees(node.right);
        if(node.left!=null)degree = degree+1+sumDegrees(node.left);
        return degree;
    }

    private static int maxDepth(BNode<String> node) {
        if(node==null)return 0;
        return 1+Math.max(maxDepth(node.right),maxDepth(node.left));
    }

    private static int twoChildren(BNode<String> node) {
       if(node==null) return 0;
       int counter=0;
       if(node.left!=null && node.right!=null)counter++;
       if(node.left!=null)counter+=twoChildren(node.left);
       if(node.right!=null)counter+=twoChildren(node.right);
       return counter;
    }

    private static int countInside(BNode<String> node) {
        if(node==null)return 0;
        if(node.left==null && node.right==null)return  0;

        return  1+countInside(node.left) + countInside(node.right);
    }
}
