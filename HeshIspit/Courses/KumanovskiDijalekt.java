package Courses;

import java.util.*;

public class KumanovskiDijalekt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  =scanner.nextInt();
        scanner.nextLine();

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split(" ");
            map.put(input[0],input[1]);
        }

        String recenica = scanner.nextLine();

        String [] zborovi = recenica.split("\\s+");

        for (int i=0; i< zborovi.length;i++) {
            char ch ='0';
            boolean flag = false;
            if(zborovi[i].endsWith(",") || zborovi[i].endsWith(".") || zborovi[i].endsWith("!")){
                ch = zborovi[i].charAt(zborovi[i].length()-1);
                zborovi[i] = zborovi[i].substring(0,zborovi[i].length()-1);
                flag=true;
            }
            if(map.containsKey(zborovi[i])){
                zborovi[i] = map.get(zborovi[i]);
            }
            else if(map.containsKey(zborovi[i].toLowerCase())){
                zborovi[i] = map.get(zborovi[i].toLowerCase());
                zborovi[i] = Character.toUpperCase(zborovi[i].charAt(0)) + zborovi[i].substring(1);
            }
            if(flag)zborovi[i]+=ch;
        }

        StringBuilder nova= new StringBuilder();

        for (String zbor : zborovi) {
            nova.append(zbor);
            nova.append(" ");
        }
        System.out.println(nova);
    }
}
