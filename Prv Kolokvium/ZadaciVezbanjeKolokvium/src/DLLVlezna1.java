import java.util.*;

public class DLLVlezna1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        
        String [] bukvi =  string.split(" ");
        
        ArrayList<String> bukviArrayList = new ArrayList<>();

        Collections.addAll(bukviArrayList, bukvi);

        ArrayList<String> samoglaski = new ArrayList<>();
        ArrayList<String> soglaski = new ArrayList<>();
        
        boolean pocetok = true;

        while (!bukviArrayList.isEmpty()) {
            String tmp = pocetok ? bukviArrayList.getFirst() : bukviArrayList.getLast();
            String lowerTmp = tmp.toLowerCase();

            boolean eSamoglaska = lowerTmp.equals("a") || lowerTmp.equals("e") || lowerTmp.equals("i") || lowerTmp.equals("o") || lowerTmp.equals("u");

            if(eSamoglaska)samoglaski.add(tmp);
            else soglaski.add(tmp);

            if(pocetok)bukviArrayList.remove(bukviArrayList.getFirst());
            else bukviArrayList.remove(bukviArrayList.getLast());

            pocetok = !pocetok;

        }
        nashPrint(samoglaski);
        nashPrint(soglaski);
    }

    private static void nashPrint(ArrayList<String> soglaski) {
        for (int i = 0; i < soglaski.size(); i++) {
            System.out.print(soglaski.get(i)+" ");
        }
        System.out.println();
    }
}
