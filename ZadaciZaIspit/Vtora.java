import java.util.*;
public class Vtora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Map<String,String> recnik = new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] line  = scanner.nextLine().split(" ");
            recnik.put(line[0],line[1]);
        }
        String recenica = scanner.nextLine();

        String [] zborovi = recenica.split(" ");

        for (int i = 0; i < zborovi.length ; i++) {
            int flag =0;
            int zname=0;
            if(Character.isUpperCase(zborovi[i].charAt(0))){
                zborovi[i] = zborovi[i].substring(0, 1).toLowerCase() + zborovi[i].substring(1);
                flag=1;
            }
            char c = '\0';
            if(zborovi[i].charAt(zborovi[i].length()-1)==',' || zborovi[i].charAt(zborovi[i].length()-1)=='.'){
                c=zborovi[i].charAt(zborovi[i].length()-1);
                zborovi[i] = zborovi[i].substring(0, zborovi[i].length()-1);
                zname=1;
            }
            if (recnik.containsKey( zborovi[i])){
                zborovi[i] = recnik.get(zborovi[i]);
            }
            if(flag==1){
                zborovi[i] = zborovi[i].substring(0, 1).toUpperCase() + zborovi[i].substring(1);
            }
            if(zname==1){
                zborovi[i]=zborovi[i]+c;
            }
        }
        for (String s : zborovi) {
            System.out.print(s + " ");
        }
    }
}