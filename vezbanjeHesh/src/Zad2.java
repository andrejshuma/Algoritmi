
import java.util.*;

class Person1 implements Comparable<Person1>{
    String ime;
    String prezime;
    int budzet;
    String IpAddress;
    String time;
    String city;
    int price;

    public Person1(String ime, String prezime, int budzet, String ipAddress, String time, String city, int price) {
        this.ime = ime;
        this.prezime = prezime;
        this.budzet = budzet;
        IpAddress = ipAddress;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "<"+ime + ", " + prezime + ", " + budzet + ", " + IpAddress + ", " + time + ", " + city + ", " + price + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person = (Person1) o;
        return budzet == person.budzet && price == person.price && Objects.equals(ime, person.ime) && Objects.equals(prezime, person.prezime) && Objects.equals(IpAddress, person.IpAddress) && Objects.equals(time, person.time) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, budzet, IpAddress, time, city, price);
    }

    @Override
    public int compareTo(Person1 o) {
        return this.price-o.price;
    }
}
public class Zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        CBHT<String, Integer> gradovi = new CBHT<>(n);
        CBHT<String, Person1> payedTheMost = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            //Jovan Todorov    1000    10.73.112.200     16:30   Bitola     760
            String[] line = scanner.nextLine().split("\\s+");
            String ime = line[0];
            String prezime = line[1];
            int budget = Integer.parseInt(line[2]);
            String IpAddress = line[3];
            String time = line[4];

            String city = line[5];
            int price = Integer.parseInt(line[6]);

            if (budget >= price) {
                {
                    if (gradovi.search(city) == null) gradovi.insert(city, 1);
                    else gradovi.search(city).element.value++;

                    Person1 person = new Person1(ime, prezime, budget, IpAddress, time, city, price);

                    if (payedTheMost.search(city) == null) payedTheMost.insert(city, person);
                    else if (price > payedTheMost.search(city).element.value.price) {
                        payedTheMost.delete(city);
                        payedTheMost.insert(city, person);
                    }

                }
            }
        }
            scanner.nextLine();
            int m = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < m; i++) {
                String[] line = scanner.nextLine().split("\\s+");
                String city = line[5];

                System.out.println("City: " + city + " has the following number of customers:");
                System.out.println(gradovi.search(city).element.value);


                System.out.println("The user who spent the most purchasing for that city is:");
                System.out.println(payedTheMost.search(city).element.value.ime + " " + payedTheMost.search(city).element.value.prezime + " with salary " + payedTheMost.search(city).element.value.budzet + " from address " + payedTheMost.search(city).element.value.IpAddress + " who spent " + payedTheMost.search(city).element.value.price);
                System.out.println();


            }
        }
    }


