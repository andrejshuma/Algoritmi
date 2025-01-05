
import java.util.*;

class Person2 implements Comparable<Person2>{
    String ime;
    String prezime;
    int budzet;
    String IpAddress;
    String time;
    String city;
    int price;

    public Person2(String ime, String prezime, int budzet, String ipAddress, String time, String city, int price) {
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
        Person2 person = (Person2) o;
        return budzet == person.budzet && price == person.price && Objects.equals(ime, person.ime) && Objects.equals(prezime, person.prezime) && Objects.equals(IpAddress, person.IpAddress) && Objects.equals(time, person.time) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, budzet, IpAddress, time, city, price);
    }

    @Override
    public int compareTo(Person2 o) {
        return this.price-o.price;
    }
}
public class Zad4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        CBHT<String, Integer> ipAdresi = new CBHT<>(n);
        CBHT<String, Person2> earliest = new CBHT<>(n);


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
            String[] timeSplit = time.split(":");
            int hour = Integer.parseInt(timeSplit[0]);
            int minutes = Integer.parseInt(timeSplit[1]);
            String city = line[5];
            int price = Integer.parseInt(line[6]);

            if (hour >= 12) {
                if (ipAdresi.search(IpAddress) == null) ipAdresi.insert(IpAddress, 1);
                else ipAdresi.search(IpAddress).element.value++;

                Person2 person = new Person2(ime, prezime, budget, IpAddressPrivatna, time, city, price);

                if (earliest.search(IpAddress) == null) earliest.insert(IpAddress, person);
                else if (hour < Integer.parseInt(earliest.search(IpAddress).element.value.time.split(":")[0])) {
                    earliest.delete(IpAddress);
                    earliest.insert(IpAddress, person);
                } else if (hour == Integer.parseInt(earliest.search(IpAddress).element.value.time.split(":")[0])) {
                    if (minutes < Integer.parseInt(earliest.search(IpAddress).element.value.time.split(":")[1])) {
                        earliest.delete(IpAddress);
                        earliest.insert(IpAddress, person);
                    }
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

            System.out.println("The user who logged on earliest after noon from that network is:");
            System.out.println(earliest.search(IpAddress).element.value.ime + " " + earliest.search(IpAddress).element.value.prezime + " with salary " + earliest.search(IpAddress).element.value.budzet + " from address "+ earliest.search(IpAddress).element.value.IpAddress +  " who logged in at "+ earliest.search(IpAddress).element.value.time);
            System.out.println();
        }
    }
}

