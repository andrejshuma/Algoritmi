import java.util.*;

public class Zad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer> lista =new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            lista.add(scanner.nextInt());
        }

        int numberZalutani = 0;
        for (int i = 0; i <n-1 ; i++) {
            if (lista.get(i) > lista.get(i + 1)) {
                numberZalutani++;
            }
        }
        System.out.println(numberZalutani);

        // 1 3 4 5 2 6 8 7

        for (int i = 0; i <n-1 ; i++) {
            if(lista.get(i)> lista.get(i+1)){
                int counter=0;
                for (int j = i+1; j >=0 ; j--) {
                    if(lista.get(i+1)< lista.get(j))counter++;
                }
                System.out.println(lista.get(i+1)+" "+counter);
            }
        }



    }
}
