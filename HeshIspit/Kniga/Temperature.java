package Kniga;
import java.util.*;
public class Temperature {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String,Measurement> mapa = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split(" ");
            String city = input[0];
            Measurement m = new Measurement(input[1],input[2],Float.parseFloat(input[3]));

            if(mapa.get(city)==null || m.temp >mapa.get(city).temp){
                mapa.put(city,m);
            }
        }

        String ovoj = scanner.nextLine();

        if(mapa.get(ovoj)==null){
            System.out.println("Nema takov grad");
        }
        else System.out.println(ovoj+": "+mapa.get(ovoj));
    }
}


//4
//Ohrid,Macedonia 10:00 12:00 23.1
//Skopje,Macedonia 09:00 10:30 24
//Ohrid,Macedonia 12:00 13:00 25
//Skopje,Macedonia 10:00 11:00 26.2
//Ohrid,Macedonia