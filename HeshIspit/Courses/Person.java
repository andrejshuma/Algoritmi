package Courses;

import java.util.Objects;

public class Person implements Comparable<Person> {
    String name;
    String surname;
    int budget;
    String privateIP;
    String time;
    String city;
    int price;

    public Person(String name, String surname, int budget, String privateIP, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.privateIP = privateIP;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return budget == person.budget && price == person.price && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(privateIP, person.privateIP) && Objects.equals(time, person.time) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, budget, privateIP, time, city, price);
    }

    @Override
    public int compareTo(Person o) {
        return  this.price - o.price;
    }

    @Override
    public String toString() {
        return name + " " +surname + " with salary "+budget+" from address "+ privateIP+" who spent "+price;

           //     Sara Dobreva with salary 2700 from address 10.73.60.29 who spent 2500
    }

    public String print3(){
        return name + " " +surname + " with salary "+budget+" from address "+ privateIP+" who logged in at "+time;

        //Sara Dobreva with salary 2700 from address 10.73.60.29 who logged in at 14:35
    }
}
