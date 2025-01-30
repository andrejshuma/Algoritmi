package Kniga;
import java.util.*;
public class Epidemic {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, Integer> mapaVkupno= new HashMap<>();
        HashMap<String, Integer> mapaPozitivni= new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            if(input[2].equals("negative")){
                mapaVkupno.put(input[0],mapaVkupno.getOrDefault(input[0],0)+1);
            }
            else{
                mapaVkupno.put(input[0],mapaVkupno.getOrDefault(input[0],0)+1);
                mapaPozitivni.put(input[0],mapaPozitivni.getOrDefault(input[0],0)+1);
            }
        }

        String opshtina = scanner.nextLine();

        System.out.println((float) mapaPozitivni.get(opshtina) / mapaVkupno.get(opshtina));
    }

}
//     6
//    Centar Stojanoski negative
//    Centar Trajkovski positive
//    Centar Petkovski positive
//    Karpos Stojanoski positive
//    Karpos Trajkovski negative
//    Centar Trajkovski positive
//    Centar
