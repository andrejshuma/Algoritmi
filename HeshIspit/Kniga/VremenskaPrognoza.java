package Kniga;

import java.util.*;

public class VremenskaPrognoza {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String,LinkedList<Measurement>> mapa = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split(" ");
            String city = input[0];
            Measurement m = new Measurement(input[1],input[2],Float.parseFloat(input[3]));

            if(mapa.containsKey(city)){
                LinkedList<Measurement> lista = mapa.get(city);
                boolean flag = true;
                for (Measurement measurement : lista) {
                    if(Objects.equals(measurement.from, m.from) && Objects.equals(measurement.to, m.to)){
                        measurement.temp = (measurement.temp + m.temp)/2;
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    lista.add(m);
                }
                mapa.put(city,lista);
            }
            else{
                LinkedList<Measurement> list = new LinkedList<>();
                list.add(m);
                mapa.put(city,list);
            }
        }

        String ovoj  =scanner.nextLine();

        if(mapa.get(ovoj)==null){
            System.out.println(ovoj+ ": Does not exist");
        }
        else{
            LinkedList<Measurement> lista = mapa.get(ovoj);
            for (Measurement measurement : lista) {
                System.out.println(measurement);
            }
        }
    }
}
//
//4
//Ohrid 10:00 12:00 23.1
//Skopje 09:00 10:30 24
//Ohrid 12:00 13:00 25
//Skopje 10:00 11:00 26.2
//Ohrid