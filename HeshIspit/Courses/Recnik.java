package Courses;
import java.util.*;

public class Recnik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, Integer> mapa = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            mapa.put(scanner.nextLine(), i);
        }

        String recenica = scanner.nextLine().replaceAll("[^a-zA-Z0-9 ]","").toLowerCase();

        if(recenica.isEmpty()) {
            System.out.println("Bravo");
            return;
        }
        String [] zborovi = recenica.split("\\s+");

        boolean flag = true;

        for (String zbor : zborovi) {
            if(!mapa.containsKey(zbor)) {
                flag=false;
                System.out.println(zbor);
            }
        }
        if(flag) System.out.println("Bravo");

    }
}
