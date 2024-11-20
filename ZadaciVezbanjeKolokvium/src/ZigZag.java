import java.util.Scanner;
public class ZigZag {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list = new SLL<>();

        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        System.out.println(list);

        makeZigZag(list);

        System.out.println(list);
    }

    private static void makeZigZag(SLL<Integer> list) {
        SLLNode<Integer> prev = list.getFirst();

        while(prev.element==0)
        {
            list.delete(prev);
            if(prev.succ!=null)
                prev=prev.succ;
            else break;
        }
        SLLNode<Integer> node=prev.succ;

        while(node!=null)
        {
            if(node.element==0) {
                list.delete(node);
            }

            if(prev.element<0 && node.element<0)
            {
                SLLNode<Integer> n = new SLLNode<Integer>(prev.element*-1,node);
                prev.succ=n;
            }
            if(node.element>0 && prev.element>0) {
                list.delete(node);
            }
            else prev=node;

            node = node.succ;
        }


    }
}
