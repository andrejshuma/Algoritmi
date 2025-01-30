package Courses;
import java.util.*;
public class Zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();


        HashMap<String, Integer> mapaCounter = new HashMap<>();
        HashMap<String, Person> mapaPerson = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String city = input[5];
            Person person = new Person(input[0],input[1],Integer.parseInt(input[2]),input[3],input[4],input[5],Integer.parseInt(input[6]));
            String [] timeDivided = input[4].split(":");
            int hour = Integer.parseInt(timeDivided[0]);
            int minutes = Integer.parseInt(timeDivided[1]);

            if(hour >= 12){
                mapaCounter.put(person.city, mapaCounter.getOrDefault(person.city,0)+1);

                if(mapaPerson.get(city)==null ){
                    mapaPerson.put(city,person);
                }
                else if( Integer.parseInt(mapaPerson.get(city).time.split(":")[0]) > hour){
                    mapaPerson.put(city,person);
                }
                else if(Integer.parseInt(mapaPerson.get(city).time.split(":")[0]) == hour){
                    if(Integer.parseInt(mapaPerson.get(city).time.split(":")[0]) > minutes){
                        mapaPerson.put(city,person);
                    }
                }
            }
        }

        scanner.nextLine();
        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <m ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String city = input[5];
            System.out.println("City: "+city+" has the following number of customers:");
            System.out.println(mapaCounter.get(city));
            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(mapaPerson.get(city).print3());
            System.out.println();
        }
    }
}
