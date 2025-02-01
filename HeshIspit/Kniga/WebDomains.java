package Kniga;
import java.util.*;
public class WebDomains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            int times = Integer.parseInt(input[0]);
            String [] domain = input[1].split("\\.");

            if(!map.containsKey(input[1])){
                map.put(input[1],times );
            }
            else{
                map.put(input[1],map.get(input[1])+times );
            }

            if(domain.length>1) {
                for (int j = 1; j < domain.length; j++) {
                    String subdomain = domain[j];
                    for (int k = j + 1; k < domain.length; k++) {
                        subdomain += ".";
                        subdomain += domain[k];
                    }
                    if (!map.containsKey(subdomain)) {
                        map.put(subdomain, times);
                    } else {
                        map.put(subdomain, map.get(subdomain) + times);
                    }
                }
            }
        }

        int m = scanner.nextInt();
        scanner.nextLine();
        System.out.println(map);
        for (int i = 0; i <m ; i++) {
            String line = scanner.nextLine();
            if(map.get(line)!=null){
                System.out.println(map.get(line));
            }else System.out.println("Not Found");
        }
    }
}
//4
//900 google.mail.com
//50 yahoo.com
//1 intel.mail.com
//5 wiki.org
//5
//mail.com
//com
//org
//yahoo.com
//test