package Kniga;

import java.util.*;

public class Passports {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            map.put(input[0],input[1]);
            map2.put(input[1],input[0]);
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <m ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            map2.remove(input[0]);
        }

        String ovoj = scanner.nextLine();

        if(map.containsKey(ovoj) && map2.containsKey(map.get(ovoj))){
            System.out.println("Allowed");
        }
        else System.out.println("Not allowed");
    }
}
//4
//A112233 IvanaIvanovska
//B345680 AleksandarPetreski
//A878999 ElenaTrajkovska
//B783789 IvanIvanov
//2
//PetrankaJanevska PetrankaPetrovska
//AleksandarPetreski AleksandarKocevski
//B783789