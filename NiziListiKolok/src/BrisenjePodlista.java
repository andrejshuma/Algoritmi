import java.util.Scanner;


public class BrisenjePodlista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        DLL<Integer> lista1 = new DLL<>();

        for (int i = 0; i <n ; i++) {
            int num = scanner.nextInt();
            lista1.insertLast(num);
        }

        int m = scanner.nextInt();

        DLL<Integer> lista2 = new DLL<>();

        for (int i = 0; i <m ; i++) {
            int num = scanner.nextInt();
            lista2.insertLast(num);
        }

        scanner.close();
        System.out.println(lista1);

        DLLNode<Integer> curr = lista1.getFirst();

        while(curr!=null){
            if(curr.element.equals(lista2.getFirst().element)){
                DLLNode<Integer> tmp1 = curr.succ;
                DLLNode<Integer> tmp2 = lista2.getFirst().succ;
                int counter = 1;
                for (int i = 0; i <m-1 ; i++) {
                    if(tmp1 != null && tmp2!=null && tmp1.element.equals(tmp2.element)){
                        counter++;
                        tmp1=tmp1.succ;
                        tmp2=tmp2.succ;
                    }
                    else break;

                }
                if(counter == m){
                    DLLNode<Integer> del = curr;
                    for (int i = 0; i <m ; i++) {
                        DLLNode<Integer> nextDel = del.succ;
                        lista1.delete(del);
                        del = nextDel;
                    }
                    curr= tmp1;
                }
                else curr = curr.succ;

            }

            else curr = curr.succ;
        }
        System.out.println(lista1);
    }


//22
//1 2 3 4 5 6 1 2 3 4 5 6 1 2 6 5 1 3 4 1 5 2
//3
//4 5 6
}
