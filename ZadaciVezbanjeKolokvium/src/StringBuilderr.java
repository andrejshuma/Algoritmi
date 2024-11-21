import java.util.*;

public class StringBuilderr {

    public static void putWordsTogether(SLL<String> list) {

        SLLNode<String> curr = list.getFirst();
        StringBuilder str = new StringBuilder();
        while (curr != null) {

            if (!curr.element.equals(",")) {
                str.append(curr.element);
                if (curr.succ == null) {
                    curr.element = str.toString();
                    break;
                }
                list.delete(curr);
            } else {
                curr.element = str.toString();
                str = new StringBuilder();
            }
            curr = curr.succ;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();

        String parts[] = line.split(" ");

        SLL<String> list = new SLL<>();

        for(String part: parts) {
            list.insertLast(part);
        }

        System.out.println(list);

        putWordsTogether(list);

        System.out.println(list);
    }
}