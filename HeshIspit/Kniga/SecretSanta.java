package Kniga;
import java.util.*;
public class SecretSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, HashMap<String,Integer>> mapa = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] line = scanner.nextLine().split("\\s+");
            if(line[0].equals("wish")){
                String from = line[1];
                String to = line[2];
                if(!mapa.containsKey(from)){
                    mapa.put(from,new HashMap<>());
                }
                else if(!mapa.get(from).containsKey(to)){
                    mapa.get(from).put(to,0);
                }
                mapa.get(from).put(to,mapa.get(from).get(to) + 1);
            }
            else if(line[0].equals("ask")){
                if(line[1].equals("employee")){
                    String employee = line[2];
                    System.out.println(mapa.get(employee).size());
                }
                else if(line[1].equals("pair")){
                    String prv = line[2];
                    String vtor = line[3];

                    HashMap<String, Integer> prva = mapa.get(prv);
                    HashMap<String, Integer> vtora = mapa.get(vtor);

                    System.out.println(prva.get(vtor) + vtora.get(prv));
                }
            }
        }
    }
}
