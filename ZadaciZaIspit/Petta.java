import java.util.*;
public class Petta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Map<String,Integer> recnik = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String  line  = scanner.nextLine();
            recnik.put(line,i);
        }
        String recenica = scanner.nextLine();
        recenica =recenica.replaceAll("[^A-Za-z0-9 ]","");
        if(recenica.isEmpty()){
            System.out.println("Bravo");
            return;
        }

        String [] zborovi = recenica.split(" ");


        int counter=0;
        for (String s : zborovi) {
            if(!recnik.containsKey(s.toLowerCase())) {
                counter++;
                System.out.println(s);
            }
        }
        if (counter==0) System.out.println("Bravo");
    }
}
