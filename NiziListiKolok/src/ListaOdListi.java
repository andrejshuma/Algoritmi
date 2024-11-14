import java.util.Scanner;
public class ListaOdListi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        DLL<DLL<Integer>> glavna = new DLL<>();

        for (int i = 0; i < n; i++) {
            DLL<Integer> podlista = new DLL<>();
            for (int j = 0; j <m ; j++) {
                podlista.insertLast(scanner.nextInt());
            }
            glavna.insertLast(podlista);
            scanner.nextLine();
        }
        DLL<Integer> sumi = new DLL<>();

        DLLNode<DLL<Integer>> curr = glavna.getFirst();


        while(curr!=null){
            DLLNode<Integer> curr2 = curr.element.getFirst();
            int sum=0;
            while(curr2!=null){
                sum+=curr2.element;
                curr2=curr2.succ;
            }
            sumi.insertLast(sum);
            curr = curr.succ;
        }

        DLLNode<Integer> posledenCurr = sumi.getFirst();
        int mnozenik = 1;
        while(posledenCurr!=null){
            mnozenik*=posledenCurr.element;
            posledenCurr = posledenCurr.succ;
        }
        System.out.println(mnozenik);
    }
}
