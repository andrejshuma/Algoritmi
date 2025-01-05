import java.util.Scanner;
public class DeleteSLL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        SLL<Integer> lista = new SLL<>();
        for (int i = 0; i <n ; i++) {
            lista.insertLast(scanner.nextInt());
        }

        int target = scanner.nextInt();

        SLLNode<Integer> curr = lista.getFirst();
        int counter=0;
        while(curr!=null){
            if(curr.element == target)counter++;
            curr = curr.succ;
        }

        if(counter%2!=0){
            SLLNode<Integer> curr2 = lista.getFirst();
            while(curr2!=null){
                if(curr2.element == target){
                    break;
                }
                curr2 = curr2.succ;
            }
            lista.insertBefore(target,curr2);
        }
        System.out.println(lista);

    }


}
