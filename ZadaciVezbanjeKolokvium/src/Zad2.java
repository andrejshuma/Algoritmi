import java.util.*;
public class Zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numListi = scanner.nextInt();
        int numElem = scanner.nextInt();

        DLL<DLL> listaOdListi = new DLL<>();

        long rez = 1;

        for (int i = 0; i <numListi ; i++) {
            DLL<Integer> podLista = new DLL<>();
            long sum = 0;
            for (int j = 0; j <numElem ; j++) {
                int num = scanner.nextInt();
                podLista.insertLast(num);
                sum+=num;
            }
            listaOdListi.insertLast(podLista);
            rez*=sum;
        }

        System.out.println(rez);

    }


}
