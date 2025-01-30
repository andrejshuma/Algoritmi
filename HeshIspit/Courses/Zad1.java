package Courses;

import Classes.CBHT;

import java.util.*;

public class Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        CBHT<Vraboten, Proekt> mapa = new CBHT<>(10);

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Vraboten vraboten = new Vraboten(input[0],Integer.parseInt(input[1]));
            Proekt proekt = new Proekt(Integer.parseInt(input[2]),Integer.parseInt(input[3]));
            if(mapa.search(vraboten)==null ){
                mapa.insert(vraboten,proekt);
            }
            else if(mapa.search(vraboten).element.value.getFullPay() < proekt.getFullPay()){
                mapa.delete(vraboten);
                mapa.insert(vraboten,proekt);
            }
        }
        System.out.println(mapa);
    }
}
