import java.util.Scanner;

public class Zad4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        DLL<Integer> lista = new DLL<>();

        for (int i = 0; i < n; i++) {
            lista.insertLast(scanner.nextInt());
        }

        int M = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(lista);

        DLLNode<Integer> ovoj = lista.find(M);
        if(ovoj!=null){
            for (int i = 0; i <k ; i++) {
                if(ovoj!=lista.getFirst()){
                    int tmp = ovoj.element;
                    ovoj.element = ovoj.pred.element;
                    ovoj.pred.element = tmp;
                    ovoj = ovoj. pred;
                }
                else {
                    lista.insertLast(ovoj.element);
                    lista.deleteFirst();
                    ovoj = lista.getLast();
                }
            }
        }
        else System.out.println("Elementot ne postoi vo listata");
        System.out.println(lista);

    }

}
