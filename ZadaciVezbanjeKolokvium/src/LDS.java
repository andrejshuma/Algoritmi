import java.util.*;
public class LDS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lista.add(scanner.nextInt());
        }

        int rez = najdolgaOpagacka(lista);
        System.out.println(rez);
    }

    private static int najdolgaOpagacka(ArrayList<Integer> lista) {
        int n = lista.size();
        ArrayList<Integer> reshenija = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            reshenija.add(1);
        }
        // 11
        //-16 -23 234 234 -234 -23 -57 5 -235 453 5645
        // 1 1 1 1 1 1 1 1 1 1 1

        //

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <i ; j++) {
                if(lista.get(i) < lista.get(j) && reshenija.get(i) <= reshenija.get(j)+1){
                    reshenija.set(i,reshenija.get(j)+1);
                }
            }
        }

        int max =0;
        for (int i = 0; i <lista.size() ; i++) {
            if(reshenija.get(i)>max)max=reshenija.get(i);
        }
        return max;

    }
}
