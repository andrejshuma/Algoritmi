package Courses;

public class Proekt {
    int hours;
    int pay;

    public Proekt(int hours, int pay) {
        this.hours = hours;
        this.pay = pay;
    }

    public int getFullPay(){
        return hours*pay;
    }

    @Override
    public String toString() {
        return "<" +hours+", "+pay+">";
    }
}
