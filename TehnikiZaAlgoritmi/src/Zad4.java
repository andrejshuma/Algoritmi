import java.util.*;
public class Zad4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPositions= scanner.nextInt();
        int streetLength = scanner.nextInt();

        ArrayList<Integer> sijalici = new ArrayList<>();

        for (int i = 0; i < numPositions; i++) {
            sijalici.add(scanner.nextInt());
        }
        int counter=0;

        for (int i = 1; i <streetLength ;) {
            int found = 0;
            for (int j = i+2; j >=i-2 ; j--) {
                if(sijalici.contains(j)){
                    found = j;
                    break;
                }
            }
            counter++;
            i = found+3;
        }
        System.out.println(counter);
    }
}
