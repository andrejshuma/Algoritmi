package Kniga;
import java.util.*;
public class Ispit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentiPoTermin = scanner.nextInt();
        int numBoth = scanner.nextInt();
        scanner.nextLine();

        Queue<String> lazgovci = new LinkedList<>();
        for (int i = 0; i <numBoth ; i++) {
            lazgovci.add(scanner.nextLine());
        }

        int numAps = scanner.nextInt();
        scanner.nextLine();

        Queue<String> aps = new LinkedList<>();
        for (int i = 0; i < numAps; i++) {
            aps.add(scanner.nextLine());
        }


        int numRealBoth = scanner.nextInt();
        scanner.nextLine();

        Queue<String> realBoth = new LinkedList<>();
        for (int i = 0; i < numRealBoth; i++) {
            realBoth.add(scanner.nextLine());
        }

        int termin =0;

        while(!realBoth.isEmpty()){
            System.out.println(++termin);
            for (int i = 0; i <studentiPoTermin ; i++) {
                String student;
                if(realBoth.peek()==null) {
                    student = aps.poll();
                }
                else {
                    student = realBoth.poll();
                    lazgovci.remove(student);
                }
                System.out.println(student);
            }
        }
        while(!aps.isEmpty()){
            System.out.println(++termin);
            for (int i = 0; i <studentiPoTermin ; i++) {
                String student;
                if(aps.peek()==null) {
                    student =lazgovci.poll();
                    System.out.println(student);
                }
                student = aps.poll();
                System.out.println(student);
            }
        }
        while(!lazgovci.isEmpty()){
            termin++;
            System.out.println(termin);
            for (int i = 0; i <studentiPoTermin ; i++) {
                if(lazgovci.peek()==null)break;
                String student = lazgovci.poll();
                System.out.println(student);
            }
        }
    }
}
