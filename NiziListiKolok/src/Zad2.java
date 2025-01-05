import java.util.Scanner;


public class Zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n= scanner.nextInt();

        scanner.nextLine();

        SLL<String> lista = new SLL<>();

        for (int i = 0; i <n ; i++) {
            lista.insertLast(scanner.nextLine());
        }
        int l = scanner.nextInt();
        System.out.println(lista);

        lista.mirror();

        SLLNode<String> curr = lista.getFirst();
        SLLNode<String> rez = null;

        while(curr!=null){
            if(curr.element.length() == l){
                rez=curr;
                lista.delete(curr);
                break;
            }
            curr=curr.succ;
        }
        lista.mirror();
        if(rez!=null){


            lista.insertFirst(rez.element);
        }
        System.out.println(lista);
    }
}