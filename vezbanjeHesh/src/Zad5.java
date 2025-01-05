
import java.util.*;

class Person3 implements Comparable<Person3>{
    String ime;
    String prezime;
    int budzet;
    String IpAddress;
    String time;
    String city;
    int price;

    public Person3(String ime, String prezime, int budzet, String ipAddress, String time, String city, int price) {
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
        Person3 person = (Person3) o;
        return budzet == person.budzet && price == person.price && Objects.equals(ime, person.ime) && Objects.equals(prezime, person.prezime) && Objects.equals(IpAddress, person.IpAddress) && Objects.equals(time, person.time) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, budzet, IpAddress, time, city, price);
    }

    @Override
    public int compareTo(Person3 o) {
        return this.price-o.price;
    }
}
public class Zad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        CBHT<String, Integer> ipAdresi = new CBHT<>(n);
        CBHT<String, Person3> payedTheMost = new CBHT<>(n);

        for (int i = 0; i <n ; i++) {
            //Jovan Todorov    1000    10.73.112.200     16:30   Bitola     760
            String[] line = scanner.nextLine().split("\\s+");
            String ime = line[0];
            String prezime = line[1];
            int budget = Integer.parseInt(line[2]);
            String IpAddressPrivatna = line[3];
            String [] split = IpAddressPrivatna.split("\\.");
            String IpAddress = split[0]+"."+split[1]+"."+split[2];
            String time = line[4];
            String city = line[5];
            int price = Integer.parseInt(line[6]);

            if (budget>=price) {
                if (ipAdresi.search(IpAddress) == null) ipAdresi.insert(IpAddress, 1);
                else ipAdresi.search(IpAddress).element.value++;

                Person3 person = new Person3(ime, prezime, budget, IpAddressPrivatna, time, city, price);

                if (payedTheMost.search(IpAddress) == null) payedTheMost.insert(IpAddress, person);
                else if (price > payedTheMost.search(IpAddress).element.value.price) {
                    payedTheMost.delete(IpAddress);
                    payedTheMost.insert(IpAddress, person);
                }
            }
        }
        scanner.nextLine();
        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <m ; i++) {
            String [] line = scanner.nextLine().split("\\s+");
            String IpAddressPrivatna = line[3];
            String [] split = IpAddressPrivatna.split("\\.");
            String IpAddress = split[0]+"."+split[1]+"."+split[2];

            System.out.println("IP network: "+IpAddress+" has the following number of users:");
            System.out.println(ipAdresi.search(IpAddress).element.value);

            System.out.println("The user who spent the most from that network is:");
            System.out.println(payedTheMost.search(IpAddress).element.value.ime + " " + payedTheMost.search(IpAddress).element.value.prezime + " with salary " + payedTheMost.search(IpAddress).element.value.budzet + " from address " + payedTheMost.search(IpAddress).element.value.IpAddress + " who spent " + payedTheMost.search(IpAddress).element.value.price);
            System.out.println();
        }
    }
}


