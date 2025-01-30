package Kniga;

import Courses.Person;

import java.util.Objects;

public class Name implements Comparable<Name> {
    String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Name temp = (Name) o;
        return Objects.equals(name, temp.name);
    }

    @Override
    public int hashCode() {
        return (100*(100*( (name).charAt(2)) + (name).charAt(1)) + (name).charAt(0));
    }

    @Override
    public int compareTo(Name o) {
        return this.name.compareTo(o.name);
    }
}
