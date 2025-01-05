import java.util.*;

public class DLLVlezna2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        DLL<Integer> lista = new DLL<>();

        int sum=0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            lista.insertLast(num);
            sum+=num;
        }
        float average = (float) sum / (float) n;

        lista.mirror();

        DLLNode<Integer> curr = lista.getFirst();

        DLL<Integer> pomali = new DLL<>();
        DLL<Integer> pogolemi = new DLL<>();

        while(curr!=null){

            if(curr.element<=average)pomali.insertLast(curr.element);
            else pogolemi.insertLast(curr.element);

            curr =curr.succ;
        }


    }
}
