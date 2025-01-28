package Kniga;

import java.util.*;

public class TancoviGrupi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] candidates = scanner.nextLine().split(" ");

        Stack<String> lGroupM = new Stack<>();
        Stack<String> lGroupZ = new Stack<>();

        Stack<String> sGroupM = new Stack<>();
        Stack<String> sGroupZ = new Stack<>();

        Stack<String> oGroupM = new Stack<>();
        Stack<String> oGroupZ = new Stack<>();

        for (String candidate : candidates) {
            char group = candidate.charAt(0);
            char gender = candidate.charAt(1);

            if (group == 'L') {
                if (gender == 'M') {
                    lGroupM.push(candidate);
                } else {
                    lGroupZ.push(candidate);
                }
            } else if (group == 'S') {
                if (gender == 'M') {
                    sGroupM.push(candidate);
                } else {
                    sGroupZ.push(candidate);
                }
            } else if (group == 'O') {
                if (gender == 'M') {
                    oGroupM.push(candidate);
                } else {
                    oGroupZ.push(candidate);
                }
            }
        }

        Stack<String> unpairedCandidates = new Stack<>();

         formPairs(lGroupM, lGroupZ);

         formPairs(sGroupM, sGroupZ);

         formPairs(oGroupM, oGroupZ);


        unpairedCandidates.addAll(lGroupM);
        unpairedCandidates.addAll(lGroupZ);
        unpairedCandidates.addAll(sGroupM);
        unpairedCandidates.addAll(sGroupZ);
        unpairedCandidates.addAll(oGroupM);
        unpairedCandidates.addAll(oGroupZ);
        
        System.out.println("Falat " + unpairedCandidates.size());

        System.out.println("Треба да дојдат:");

        for (String candidate : unpairedCandidates) {
            if(candidate.endsWith("M")) System.out.println(candidate.charAt(0)+"Z");
            else System.out.println(candidate.charAt(0)+"M");
        }
    }

    private static void formPairs(Stack<String> maleGroup, Stack<String> femaleGroup) {
        while (!maleGroup.isEmpty() && !femaleGroup.isEmpty()) {
             maleGroup.pop();
             femaleGroup.pop();
        }
    }
}
