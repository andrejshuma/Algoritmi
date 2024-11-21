import java.util.*;

public class ZigZag2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            lista.add(scanner.nextInt());
        }
        System.out.println(lista);

        ArrayList<Integer> rez = makeZigZag(lista);
        System.out.println(rez);

    }

    private static ArrayList<Integer> makeZigZag(ArrayList<Integer> lista) {
        ArrayList<Integer> rez = new ArrayList<>();

        rez.add(lista.get(0));

        boolean rastecki = true;

        for (int i = 1; i <lista.size() ; i++) {
            int prev = rez.getLast();
            int curr = lista.get(i);

            if(rastecki && curr>prev){
                rez.add(curr);
                rastecki=false;
            }
            else if(!rastecki && curr<prev){
                rez.add(curr);
                rastecki=true;
            }
        }
        return rez;
    }
}
