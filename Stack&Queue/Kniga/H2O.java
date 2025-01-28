package Kniga;

import java.util.*;

public class H2O {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        scanner.close();

        System.out.println(podeliAtomi(input));
    }

    private static String podeliAtomi(String[] input) {
        StringBuilder rez = new StringBuilder();
        int counter =0;

        Stack<String> hydrogen = new Stack<>();
        Stack<String> oxygen = new Stack<>();

        for (String s : input) {
            if (s.equals("H")) hydrogen.push(s);
            else oxygen.push(s);
        }

        while(!oxygen.isEmpty()){
            if(!hydrogen.isEmpty()){
                hydrogen.pop();
                if(!hydrogen.isEmpty()){
                    hydrogen.pop();
                    oxygen.pop();
                    counter++;
                }
                else {
                    hydrogen.push("H");
                    break;
                }
            }
            else break;
        }
// H H O H H O H H O H H H H H O H O H O O H O O H H H

        while(!hydrogen.isEmpty()){
            hydrogen.pop();
            rez.append("H ");
        }
        while(!oxygen.isEmpty()){
            oxygen.pop();
            rez.append("O ");
        }

        System.out.println(counter);

        return rez.toString();
    }
}
