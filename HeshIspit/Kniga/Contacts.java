package Kniga;
import java.util.*;
public class Contacts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<String,String> mapa = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            input[0] = input[0].substring(1);

            mapa.put(input[0],input[1]);
        }

        String ovoj = scanner.nextLine().substring(4);

        System.out.println(mapa.getOrDefault(ovoj, "Unknown"));
    }
}
//3
//070111222 IvanIvanoski
//071222333 PetrePetrevski
//022333444 TrajceTrajkovski
//+38970111222
