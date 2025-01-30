package Courses;
import java.util.*;
public class Zad2 {
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

            if(person.budget >= person.price){
                mapaCounter.put(person.city, mapaCounter.getOrDefault(person.city,0)+1);

                if(mapaPerson.get(city)==null || mapaPerson.get(city).price < person.price ){
                    mapaPerson.put(city,person);
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
            System.out.println("The user who spent the most purchasing for that city is:");
            System.out.println(mapaPerson.get(city).toString());
            System.out.println();
        }
    }
}
