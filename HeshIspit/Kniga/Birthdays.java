package Kniga;
import java.util.*;
public class Birthdays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer,ArrayList<String>> mapa = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split(" ");
            Integer mesec = Integer.parseInt(input[1].split("\\.")[1]);

            if(mapa.get(mesec)==null){
                ArrayList<String> list = new ArrayList<>();
                list.add(input[0]);
                mapa.put(mesec,list);
            }
            else if(!mapa.get(mesec).contains(input[0])){
                mapa.get(mesec).add(input[0]);
            }
        }

        int m = scanner.nextInt();
        ArrayList<String> rodendeni = mapa.get(m);
        for (String name : rodendeni) {
            System.out.println(name);
        }
    }
}

//4
//Ivan 20.7.1976
//Ivan 16.7.1988
//Ana 18.7.1966
//Ivan 5.6.1988
//7