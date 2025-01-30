package Courses;
import java.util.*;
public class Zad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();


        HashMap<String, Integer> mapaCounter = new HashMap<>();
        HashMap<String, Person> mapaPerson = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String [ ] delcinja = input[3].split("\\.");
            String mrezha = delcinja[0] +"."+ delcinja[1] +"."+ delcinja[2];
            Person person = new Person(input[0],input[1],Integer.parseInt(input[2]),input[3],input[4],input[5],Integer.parseInt(input[6]));

            if(person.budget >= person.price){
                mapaCounter.put(mrezha, mapaCounter.getOrDefault(mrezha,0)+1);

                if(mapaPerson.get(mrezha)==null || mapaPerson.get(mrezha).price < person.price ){
                    mapaPerson.put(mrezha,person);
                }
            }
        }

        scanner.nextLine();
        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <m ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String [ ] delcinja = input[3].split("\\.");
            String mrezha = delcinja[0] +"."+ delcinja[1] +"."+ delcinja[2];
            System.out.println("IP network: "+mrezha+" has the following number of users:");
            System.out.println(mapaCounter.get(mrezha));
            System.out.println("The user who spent the most from that network is:");
            System.out.println(mapaPerson.get(mrezha).toString());
            System.out.println();
        }
    }
}

