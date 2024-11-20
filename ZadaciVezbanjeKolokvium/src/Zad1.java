import java.util.*;

public class Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        SLL<Integer> lista = new SLL<>();

        for (int i = 0; i <n ; i++) {
            lista.insertLast(scanner.nextInt());
        }

        int info = scanner.nextInt();

        int counter =0;

        SLLNode<Integer> tmp = lista.getFirst();
        SLLNode<Integer> prvo = null;

        while(tmp!=null){
            if(tmp.element==info && counter==0){
                prvo = tmp;
                counter++;
            }
            else if(tmp.element == info)counter++;
            tmp = tmp.succ;
        }

        if(counter%2!=0){
            lista.insertBefore(info,prvo);
        }


        System.out.println(lista);
    }
}