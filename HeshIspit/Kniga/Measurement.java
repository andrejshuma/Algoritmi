package Kniga;

import java.util.Objects;

public class Measurement {
    String from;
    String to;
    float temp;

    public Measurement(String from, String to, float temp) {
        this.from = from;
        this.to = to;
        this.temp = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Measurement that = (Measurement) o;
        return temp == that.temp && Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, temp);
    }

    @Override
    public String toString() {
        return from + " - " + to + " " + temp;
    }
}
