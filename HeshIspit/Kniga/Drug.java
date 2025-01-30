package Kniga;

import java.util.Objects;

public class Drug {
    String name;
    int posList;
    int price;
    int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosList() {
        return posList;
    }

    public void setPosList(int posList) {
        this.posList = posList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Drug(String name, int posList, int price, int quantity) {
        this.name = name;
        this.posList = posList;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Drug temp = (Drug) o;
        return this.name.equals(temp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, posList, price, quantity);
    }

    @Override
    public String toString() {
        if(posList==1)
            return name+" "+"POS"+" "+price+" "+quantity;
        else
            return name+" "+"NEG"+" "+price+" "+quantity;
    }

}
