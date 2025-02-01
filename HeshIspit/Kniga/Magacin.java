package Kniga;
import java.util.*;

class Lek {
    String name;
    int price;

    public Lek(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
public class Magacin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String,Lek> map = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] line  =scanner.nextLine().split("@");
            String problem = line[1];
            Lek newLek = new Lek(line[0],Integer.parseInt(line[2]));

            if(!map.containsKey(problem) || newLek.price < map.get(problem).price){
                map.put(problem,newLek);
            }
        }

        String problem = scanner.nextLine();

        System.out.println(map.get(problem).name);
    }
}
//5
//Analgin@Headache@80
//Daleron@Headache@90
//Spazmeks@Stomachache@120
//Lineks@Stomachache@150
//Loratidin@Allergy@150
//Headache
